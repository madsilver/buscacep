package org.buscacep.daos;

import java.util.ArrayList;

import org.buscacep.models.Address;

public class AddressDAO {
	
	private ArrayList<Address> enderecos;

	/**
	 * Constructor
	 */
	public AddressDAO(){
		
		enderecos = new ArrayList<>();
		
		enderecos.add(new Address("Avenida Emilio Carlos","Vila Maia","Guarujá","São Paulo","11410140"));
		enderecos.add(new Address("Rua Serra de Botucatu","Tatuapé","São Paulo","São Paulo","03356000"));
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
