package cn.popo.zhaoxinyuansecurity.service;

import cn.popo.zhaoxinyuansecurity.entity.AppGrantedAuthority;
import cn.popo.zhaoxinyuansecurity.entity.AppUserDetails;
import cn.popo.zhaoxinyuansecurity.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    AppUserMapper appUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserDetails user = appUserMapper.selectUserByUsername(username);
        if (user != null) {
            List<AppGrantedAuthority> authorities = appUserMapper.selectUserAuthorities(user.getId());
            user.setAuthorities(authorities);
        }
        return user;
    }
}