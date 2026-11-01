package cn.popo.zhaoxinyuansecurity.mapper;

import cn.popo.zhaoxinyuansecurity.entity.AppGrantedAuthority;
import cn.popo.zhaoxinyuansecurity.entity.AppUserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface AppUserMapper {
    @Select("SELECT id, username, password FROM t_user WHERE username = #{username}")
    AppUserDetails selectUserByUsername(String username);

    @Select("SELECT r.role as authority FROM t_user_role ur LEFT JOIN t_role r ON ur.role_id = r.id WHERE ur.user_id = #{userId}")
    List<AppGrantedAuthority> selectUserAuthorities(Integer userId);
}