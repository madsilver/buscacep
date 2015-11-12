package org.buscacep.daos;

import java.util.ArrayList;

import org.buscacep.models.Address;

public class AddressMockDAO {
	
	private ArrayList<Address> enderecos;

	/**
	 * Constructor
	 */
	public AddressMockDAO(){
		
		enderecos = new ArrayList<>();
		enderecos.add(new Address("Avenida Emilio Carlos","","","Vila Maia","Guaruja","Sao Paulo","11410140"));
		enderecos.add(new Address("Rua Sergipe","","","Jardim Cunhambebe","Guaruja","Sao Paulo","11450110"));
		enderecos.add(new Address("Rua Serra de Botucatu","","","Tatuape","Sao Paulo","Sao Paulo","03356000"));
	}
	
	/**
	 * Search address by zipcode
	 * @param zipcode
	 * @return Address
	 */
	public Address Search(String zipcode){
		Address match = new Address();
		for(Address address : enderecos){
			if(address.getZipcode().equals(zipcode)){
				match = address;
			}
		}
		return match;
	}
	
	
	
	
}
