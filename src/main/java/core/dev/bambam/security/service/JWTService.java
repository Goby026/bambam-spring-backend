package core.dev.bambam.security.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;

public interface JWTService {

    //metodo para crear el token
    public String create(Authentication auth) throws JsonProcessingException;

    //    validar el token
    public boolean validate(String token);

    //    obtener los claims
    public Claims getClaims(String token);

    public String getUsername(String token);

    public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;

    public String resolve(String token);

}
