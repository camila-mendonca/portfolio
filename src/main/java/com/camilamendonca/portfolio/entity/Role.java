package com.camilamendonca.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;

	@Override
	public String getAuthority() {
		return name;
	}

	public String getName() {
		return name;
	}

}
