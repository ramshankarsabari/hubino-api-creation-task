package com.ram.rest.webservices.restfulwebservices.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.rest.webservices.restfulwebservices.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
