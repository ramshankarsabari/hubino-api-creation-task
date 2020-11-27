package com.ram.rest.webservices.restfulwebservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.rest.webservices.restfulwebservices.Entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
