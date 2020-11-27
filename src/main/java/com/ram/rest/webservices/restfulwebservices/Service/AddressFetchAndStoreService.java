package com.ram.rest.webservices.restfulwebservices.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ram.rest.webservices.restfulwebservices.Entity.Address;
import com.ram.rest.webservices.restfulwebservices.Entity.Users;
import com.ram.rest.webservices.restfulwebservices.Others.External;
import com.ram.rest.webservices.restfulwebservices.Repository.AddressRepository;
import com.ram.rest.webservices.restfulwebservices.Repository.UserRepository;

@Service
public class AddressFetchAndStoreService {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public static External getExternalAddressData(String ipaddr)
	{
//	    String uri = "http://api.ipstack.com/134.201.250.155?access_key=626053333c5203dcd83c391d63485afb";
		String uri = "http://api.ipstack.com/"+ipaddr+"?access_key=626053333c5203dcd83c391d63485afb";
	    RestTemplate restTemplate = new RestTemplate();
	    External result = restTemplate.getForObject(uri, External.class);
	    return result;
	}

	@Transactional
	public void doUpdateAddress(long userid, String ipaddr) {
		External externalAddress = getExternalAddressData(ipaddr);
		Optional<Users> users = userRepository.findById(userid);
		Users userFetched = users.get();
		
		Address addr = new Address(externalAddress.getCity(),externalAddress.getRegion_name(),externalAddress.getCountry_name());
		addr.setUsers(userFetched);
		userFetched.addAddress(addr);
		em.merge(addr);
	}
	
}
