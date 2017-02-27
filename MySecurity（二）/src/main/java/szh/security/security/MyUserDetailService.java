package szh.security.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import szh.security.dao.UserDao;
import szh.security.entity.MyUser;
@Service
public class MyUserDetailService implements UserDetailsService  {
	@Autowired
	UserDao userdao;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		MyUser user =userdao.getUserByName(username);
		if(user==null)
		{
			throw new  UsernameNotFoundException("找不到该用户");
		}
//		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
//		grantedAuthorities.add(grantedAuthority);
		return new MyUserDetail(user, getAuthorities(user.getUser_role()));
	}

	private Collection<GrantedAuthority> getAuthorities(String role) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

}
