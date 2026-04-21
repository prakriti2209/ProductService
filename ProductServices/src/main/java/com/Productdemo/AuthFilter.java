package com.Productdemo;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
@Component
public class AuthFilter extends OncePerRequestFilter{
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String AuthHeader=request.getHeader("Authorization");
      if(AuthHeader!=null&& AuthHeader.startsWith("Bearer ")) {

          String userToken = AuthHeader.substring(7);
          if (jwtUtil.checkToken(userToken)){
              Claims claims= jwtUtil.getTokenData(userToken);
              String username=claims.getSubject();
              String role=(String) claims.get("role");

              UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(username,null, List.of(new SimpleGrantedAuthority("ROLE_"+role)));
              SecurityContextHolder.getContext().setAuthentication(auth);
          }
      }
      filterChain.doFilter(request,response);
    }
}
