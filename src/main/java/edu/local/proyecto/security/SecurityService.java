package edu.local.proyecto.security;

import edu.local.proyecto.dao.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import edu.local.proyecto.dao.repository.UsuarioRepository;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository urepo;
    
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        UsuarioEntity ue = urepo.findById(nombre).get();
        
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        UserDetails udet = new User(ue.getUsuario(), ue.getClave(), roles);
        return udet;
    }
    
}
