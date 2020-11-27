/**
 * 
 */
package com.ram.rest.webservices.restfulwebservices.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Ram shankar
 *
 */
@Entity
public class Users {
	// User : id, name, email, password, role_id, department_id
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy="users",fetch = FetchType.LAZY)
	private List<Address> address = new ArrayList<>();

	@ManyToOne
	private Role role;
	
	@ManyToOne
	private Department department;

	
	public Users() {
		
	}
	
	public Users(Long id, String name, String email, String password,Department department,Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.department = department;
		this.role = role;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void addAddress(Address address) {
		this.address.add(address);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", role=" + role + ", department=" + department + "]";
	}

}
