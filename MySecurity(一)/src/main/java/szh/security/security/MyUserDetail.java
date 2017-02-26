package szh.security.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import szh.security.entity.MyUser;

public class MyUserDetail implements UserDetails {
	private MyUser myUser;
	private Collection<? extends GrantedAuthority> authorities;

	public MyUserDetail(MyUser user,Collection<? extends GrantedAuthority> authorities) {
		this.myUser = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		return myUser.getUser_password();
	}

	@Override
	public String getUsername() {
		return myUser.getUser_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
