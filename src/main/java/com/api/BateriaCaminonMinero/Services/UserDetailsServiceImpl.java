package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TrabajadoresRepository trabajadoresRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TrabajadoresModel trabajadoresModel = trabajadoresRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        Collection<? extends GrantedAuthority> authorities = trabajadoresModel.getRolesModel() != null ?
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + trabajadoresModel.getRolesModel().getName())) :
                null;


        return new User(
                trabajadoresModel.getUsername(),
                trabajadoresModel.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
