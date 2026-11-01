package cn.popo.zhaoxinyuansecurity.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AppGrantedAuthority implements GrantedAuthority {
    String authority;
}