package org.buscacep.controllers;

import javax.transaction.Transactional;

import org.buscacep.daos.AddressDAO;
import org.buscacep.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class AddressController {
	
	@Autowired
    private AddressDAO addressDAO;
	
	@RequestMapping("/")
	public ModelAndView index(Address address){
		ModelAndView modelAndView = new ModelAndView("home");
		if(address.getId() > 0)
			modelAndView.addObject(addressDAO.find(address.getId()));
		return modelAndView;
	}

	@RequestMapping(value="/saveAddress",method=RequestMethod.POST)
    public ModelAndView save(Address address){
		if(address.getId() > 0)
			addressDAO.edit(address);
		else	
			addressDAO.save(address);
    	return new ModelAndView("redirect:listAddress");
    }
	
	@RequestMapping(value="/listAddress",method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("listAddress", addressDAO.getAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/removeAddress/{id}",method=RequestMethod.GET)
    public ModelAndView remove(@PathVariable Long id){
		addressDAO.remove(id);
    	return new ModelAndView("redirect:/listAddress");
    }
}
