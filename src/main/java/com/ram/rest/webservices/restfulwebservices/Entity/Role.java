/**
 * 
 */
package com.ram.rest.webservices.restfulwebservices.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ram shankar
 *
 */
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String rolename;

	protected Role() {
		
	}
	
	public Role(Long id,String rolename) {
		super();
		this.id=id;
		this.rolename=rolename;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
