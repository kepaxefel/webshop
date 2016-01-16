package com.shop.domains;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false, insertable = true, updatable = true)
	private int id;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name= "Surname")
	private String surname;
	
	@Column(name= "Login")
	private String login;
		
	@Column(name= "Password")
	private String password;
	
	@Column(name= "Gender")
	private boolean gender;
	
	@Column(name= "Email")
	private String email;
	
	@Column(name= "Number")
	private String number;
	
    @Column(name = "role")
    private String role;

    //@Column(name = "created_date")
    //@CreatedDate
    // private LocalDateTime createdDate;
	
	public User(){		
	}
	
	public User(String name, String surname, String login, String password, String email, String number, boolean gender, String role){//, Set<Order> orders){
		this.name = name;
		this.surname = surname;
		this.login = login;		
		this.email = email;
		this.number = number;
		this.gender = gender;
		//this.orders = orders;
		this.role = role;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}	

	
	public boolean isGender() {
		return gender;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNumber() {
		return number;
	}
	
    public String getRole() {
		return role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + this.role));
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public LocalDateTime getCreatedDate() {
//		return createdDate;
//	}

//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate;
//	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}	
}
