package org.formation.ajc.family.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Person {

	public static enum Role {
		ROLE_ADMIN, ROLE_USER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String login;
	
	@JsonIgnore
	private String password;
	
	@ElementCollection(targetClass=Role.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles", joinColumns=@JoinColumn(name = "app_user_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		super();
		addRole(Role.ROLE_USER);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @Override
	// public String getUsername() {
	// return login;
	// }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	// @Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}

	// @Override
	// public Collection<? extends GrantedAuthority> getAuthorities() {
	// return Collections.emptySet();
	// }
	//
	// @Override
	// public boolean isEnabled() {
	// return true;
	// }
	//
	// @Override
	// public boolean isAccountNonExpired() {
	// return true;
	// }
	//
	// @Override
	// public boolean isAccountNonLocked() {
	// return true;
	// }
	//
	// @Override
	// public boolean isCredentialsNonExpired() {
	// return true;
	// }
}