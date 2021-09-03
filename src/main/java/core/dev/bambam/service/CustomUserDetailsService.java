package core.dev.bambam.service;

import core.dev.bambam.entity.Role;
import core.dev.bambam.entity.Usuario;
import core.dev.bambam.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = this.userRepository.findByUsername(username);

        if (usuario == null){
            this.logger.error("Error en el login: no existe el usuario "+username+"en el sistema!");
            throw new UsernameNotFoundException("Username: "+username+"no existe");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for ( Role role : usuario.getRoles() ) {
            authorities.add(new SimpleGrantedAuthority( role.getAuthority() ));
        }

        if (authorities.isEmpty()){
            this.logger.error("Error en el login: "+username+"no tiene roles asignados!");
            throw new UsernameNotFoundException("Username: "+username+"no tiene roles asignados!");
        }

        this.logger.info("usuario: "+ usuario);
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
