/**
 * 
 */
package com.ram.rest.webservices.restfulwebservices.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.rest.webservices.restfulwebservices.Entity.Users;

/**
 * @author Ram shankar
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
	Optional<Users> findByName(String name);
}
