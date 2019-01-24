package com.app.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements UserDetails {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idx;
	
    private String email;
    
    private String password;
    
    private String name;
    
    private Boolean status;
    
    private LocalDateTime updDate;
    
    private LocalDateTime regDate;
    
    private LocalDateTime recentAccessDate;

    private String role = "ROLE_USER";

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    	authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

	@Override
	public String getUsername() {
		return email;
	}

}
