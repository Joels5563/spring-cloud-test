package util;

import common.CommonConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jwt.JWTInfo;

import java.time.Instant;
import java.util.Date;

/**
 * @author zhouchao
 * @Description JWT工具类
 * @date 2017/10/30 9:53
 */
public class JwtHelper {
    private static final String JWT_SECRET = "dontletotherkonw";

    /**
     * 加密token
     */
    public static String generateToken(JWTInfo jwtInfo, int expire) throws Exception {
        return Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(new Date(Instant.now().plusSeconds(expire).toEpochMilli()))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /**
     * 解析token
     */
    private static Jws<Claims> parserToken(String token) throws Exception {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
    }

    /**
     * 获取token中的用户信息
     */
    public static JWTInfo getInfoFromToken(String token) throws Exception {
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(),
                StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),
                StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)));
    }

}
