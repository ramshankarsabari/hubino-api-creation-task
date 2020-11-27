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
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	private String deptname;
	
	protected Department() {}
	
	public Department(Long id,String deptname) {
		super();
		this.id=id;
		this.deptname=deptname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}
