/*
Este filtro se ejecuta cada ves que se realiza un login
*/
package core.dev.bambam.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.dev.bambam.entity.Usuario;
import core.dev.bambam.security.service.JWTService;
import core.dev.bambam.security.service.JWTServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JWTService jwtService;

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.setRequiresAuthenticationRequestMatcher( new AntPathRequestMatcher("/api/login","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = this.obtainUsername(request);
        String password = this.obtainPassword(request);

        if (username != null && password != null){
            this.logger.info("username desde request parameter (form-data)"+ username);
            this.logger.info("password desde request parameter (form-data)"+ password);
        }else{
            Usuario usuario = null;

            try {
                usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

                username = usuario.getUsername();
                password = usuario.getPassword();
                this.logger.info("username desde request InputStream (raw-json)"+ username);
                this.logger.info("password desde request InputStream (raw-json)"+ password);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = this.jwtService.create(authResult);

        response.addHeader(JWTServiceImpl.HEADER_STRING, JWTServiceImpl.TOKEN_PREFIX+token);

        Map<String , Object> body = new HashMap<String, Object>();

        body.put("token", token);
        body.put( "user", (User) authResult.getPrincipal() );
        body.put( "msg",  String.format("Inicio de sesion correcto, %s", ((User) authResult.getPrincipal()).getUsername()) );

//        convirtiendo el body a un objeto JSON con la clase ObjectMapper()
        response.getWriter().write( new ObjectMapper().writeValueAsString(body) );
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        Map<String , Object> body = new HashMap<String, Object>();
        body.put("msg", "Error de autenticación: username o password incorrecto");
        body.put("error: ", failed.getMessage());

        response.getWriter().write( new ObjectMapper().writeValueAsString(body) );
        response.setStatus(401);
        response.setContentType("application/json");

    }
}
