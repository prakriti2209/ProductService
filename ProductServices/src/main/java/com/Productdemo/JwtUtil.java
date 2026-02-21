package com.Productdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;



@Component
public class JwtUtil {
    private String SECRET="this-is-my-secret-key-for-java-project";

    public Claims getTokenData(String userToken){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(userToken)
                .getBody();
    }
     public boolean checkToken(String token){
        try{
            getTokenData(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
     }

}
