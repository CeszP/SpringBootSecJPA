package com.cpp.HelloSpring.service;

import com.cpp.HelloSpring.dao.UserDao;
import com.cpp.HelloSpring.domain.Role;
import com.cpp.HelloSpring.domain.Usr;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserDao userDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usr user = userDao.findByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles =  new ArrayList<GrantedAuthority>();
        
        for(Role role:user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new User(user.getUsername(), user.getPassword(), roles);
    }
    
}
