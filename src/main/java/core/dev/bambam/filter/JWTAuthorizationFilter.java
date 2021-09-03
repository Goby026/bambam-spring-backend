/*
Este filtro se ejecuta en cada peticion HTTP
*/
package core.dev.bambam.filter;
import core.dev.bambam.security.service.JWTService;
import core.dev.bambam.security.service.JWTServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTService jwtService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilterInternal(request, response, chain);

        String header = request.getHeader(JWTServiceImpl.HEADER_STRING);

        if ( !requiresAuthentication(header) ){
            chain.doFilter(request, response);
            return;
        }

//        boolean validtoken = this.jwtService.validate();


        UsernamePasswordAuthenticationToken authentication = null;

        if (this.jwtService.validate(header)){
            authentication = new UsernamePasswordAuthenticationToken(this.jwtService.getUsername(header), null, this.jwtService.getRoles(header));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    protected  boolean requiresAuthentication(String header){
        if (header == null || !header.startsWith(JWTServiceImpl.TOKEN_PREFIX)){
            return false;
        }
        return true;
    }
}
