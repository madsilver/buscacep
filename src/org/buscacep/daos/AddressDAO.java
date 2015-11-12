package org.buscacep.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.buscacep.models.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Address address){
		manager.persist(address);
	}
	
	public void edit(Address address){
		manager.merge(address);
	}
	
	public void remove(Long id){
		manager.createQuery("delete Address a where a.id=:id").setParameter("id", id).executeUpdate();
	}
	
	public List<Address> getAll(){
		return manager.createQuery("select a from Address a", Address.class).getResultList();
	}
	
	public Address find(Long id) {
		TypedQuery<Address> query = manager.createQuery(
						"select a from Address a where a.id=:id",
						Address.class).setParameter("id", id);
		return query.getSingleResult();
	}

}
