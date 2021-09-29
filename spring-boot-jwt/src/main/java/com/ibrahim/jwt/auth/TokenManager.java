package com.ibrahim.jwt.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;



@Service
public class TokenManager {

    private static final String secretKey = "ibrahim";
    private static final int validity = 5 * 60 * 1000; //5 dakika

    public String generateToken(String userName){

       return  Jwts.builder().setSubject(userName).setExpiration(new Date(System.currentTimeMillis() + validity)).setIssuer("www.ibrahim.com").setIssuedAt(new Date(System.currentTimeMillis())).signWith(SignatureAlgorithm.ES256, secretKey).compact();
        //token olusturma bitme tarihi arasina 5 dakika koyduk
        //issue issuedat felan hepsi bir claim dir
    }

    public Boolean tokenValidate(String token){
        if(getUsernameToken(token) != null && isExpired(token)){
            return true;
        }
        return false;
    }

    public String getUsernameToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject(); //username donecek, cunku biz subject e username koyduk
    }

    public boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
        //simdiki zamanin ilersindeyse olusturma tarihi gecerlidir
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
