package com.cetnext.certo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class login {

    public login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public login(Long id, String username, @Email String email, @Size(min = 4, max = 15) String password,
			Boolean acceptedTermsAndConditions, com.cetnext.certo.models.address address) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.acceptedTermsAndConditions = acceptedTermsAndConditions;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAcceptedTermsAndConditions() {
		return acceptedTermsAndConditions;
	}
	public void setAcceptedTermsAndConditions(Boolean acceptedTermsAndConditions) {
		this.acceptedTermsAndConditions = acceptedTermsAndConditions;
	}
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    @Email
    private String email;
    @Size(min = 4 , max = 15)
    private String password;

    @Column(name = "accepted_terms_and_conditions")
    private Boolean acceptedTermsAndConditions;
    @OneToOne(cascade = CascadeType.ALL)
    private address address;

}