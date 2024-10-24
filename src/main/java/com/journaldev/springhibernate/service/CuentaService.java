package com.journaldev.springhibernate.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.springhibernate.dao.CuentaDAO;
import com.journaldev.springhibernate.model.Cuenta;
import com.journaldev.springhibernate.model.Person;

@Service("cuentaService")
@ManagedBean(name="cuentaService")
@SessionScoped
public class CuentaService {

	@Autowired
	private CuentaDAO cuentaDAO;

	private Person persona= null;
	
	public String verCuentas(Person persona) {
		this.persona=persona;
		return "/cuenta.xhtml";
		
	    
	}
	
	@Transactional
    public List<Cuenta> listCuentas() {
		if (persona==null)
			return (List<Cuenta>) cuentaDAO.listCuenta(); 
        return cuentaDAO.listCuentaByPersonId(persona.getId());
    }
	
	@Transactional
    public void addCuenta(Cuenta cuenta) {
		cuenta.setPerson(this.persona);
		cuentaDAO.addCuenta(cuenta);
    }

	public Person getPersona() {
		return persona;
	}

	public void setPersona(Person persona) {
		this.persona = persona;
	}
	
	
	
}
