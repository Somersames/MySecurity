package szh.security.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import szh.security.entity.MyUser;
@Service
public class MyUserDetailService implements UserDetailsService  {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		MyUser myUser = new MyUser();
		System.out.println(username + "loadµÄÖµ");
		myUser.setUser_name("a");
		myUser.setUser_password("aa");
		myUser.setUser_role("ROLE_ADMIN");
		return new MyUserDetail(myUser, getAuthorities());
	}

	private Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

}
