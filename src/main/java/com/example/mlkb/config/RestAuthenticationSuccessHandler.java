package com.example.mlkb.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final int expirationTime;
    private final String secret;

    public RestAuthenticationSuccessHandler(@Value("${jwt.expirationTime}") int expirationTime,
                                            @Value("${jwt.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        UserDetails principal = (UserDetails) authentication.getPrincipal(); // 1
        long actualTime = System.currentTimeMillis();
        String token = JWT.create() // 2
                .withSubject(principal.getUsername()) //
                .withIssuedAt(new Date(actualTime))
                .withExpiresAt(new Date(actualTime + expirationTime)) // 4
                .sign(Algorithm.HMAC256(secret)); // 5
        response.addHeader("Authorization", "Bearer " + token);

        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/api");
        cookie.setHttpOnly(true);
        //TODO: When in production must do cookie.setSecure(true);
        cookie.setMaxAge(18000000);
        System.out.println("udało się!");
        response.addCookie(cookie);
    }
}
