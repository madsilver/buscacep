package org.buscacep.controllers;

import org.buscacep.daos.AddressMockDAO;
import org.buscacep.models.Address;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressRestController {
	
    @RequestMapping(value = "/findAddress", produces = MediaType.APPLICATION_JSON_VALUE)
    public Address findAddress(@RequestParam(value = "zipcode", required = true) String zipcode){
    	
    	Address address = new Address();
    	AddressMockDAO addressDAO = new AddressMockDAO();
    	
    	if(zipcode.length() > 8){
    		return address;
    	}
    	
    	String[] arrZipcode= new String[]{
    			zipcode,
    			zipcode.substring(0,7)+"0",
    			zipcode.substring(0,6)+"00",
    			zipcode.substring(0,5)+"000"
    			}; 

		for(String strZipcode : arrZipcode){
			address = addressDAO.Search(strZipcode);
			if(address.getZipcode() != null){
				return address;
			}
		}
		return address;
	}    

}
