package rednet;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import jwt.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import util.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author zhouchao
 * @Description 路由过滤器
 * @date 2017/10/27 10:45
 */
@Component
public class RouteFilter extends ZuulFilter {

    @Autowired
    private UserService userService;

    /**
     * 前置过滤器
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 优先级为0，数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String url = request.getRequestURL().toString();
        System.out.println(String.format("%s RouteFilter request to %s",
                request.getMethod(), url));
        String token = request.getHeader("Authorization");
        if (!url.contains("login")) {
            if (StringUtils.isEmpty(token)) {
                //不存在用户token,则跳转到登录页面
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().println("token is  empty");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    //Authorization: Bearer <token>
                    JWTInfo userInfo = JwtHelper.getInfoFromToken(token.substring(7));
                    List<String> authList = userService.getAuthList(userInfo.getUniqueName());
                    if (!authList.contains(request.getRequestURI())) {
                        //该用户没有此权限
                        ctx.setSendZuulResponse(false);
                        ctx.setResponseStatusCode(401);
                        try {
                            ctx.getResponse().getWriter().println("user don't have auth");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    //JWT出错
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(401);
                    try {
                        ctx.getResponse().getWriter().println("user don't have auth");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
