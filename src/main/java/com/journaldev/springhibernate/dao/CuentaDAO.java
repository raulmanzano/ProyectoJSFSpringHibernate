package com.journaldev.springhibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.springhibernate.model.Cuenta;



//@NamedQuery(name = "DeptEmployee_findByEmployeeNumber", 
//query = "from DeptEmployee where employeeNumber = :employeeNo")

//@NamedNativeQuery(name = "Cuenta_getByIdPerson", 
//	      query = "select * from cuenta where id_person=:id_person",
//	      resultClass = Cuenta.class)
//
@NamedQuery(name = "Cuenta_getByIdPerson", 
query = "from cuenta where id_person = :id_person")

@Repository("cuentaDAO")
public class CuentaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CuentaDAO.class);
	 
	@Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
     
    public void addCuenta(Cuenta c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Person saved successfully, Person Details="+c);
    }
 
    
    @SuppressWarnings("unchecked")
	public List<Cuenta> listCuenta() {
        Session session = this.sessionFactory.getCurrentSession();        
        List<Cuenta> cuentasList = session.createQuery("from Cuenta").list();        
        for(Cuenta c : cuentasList){
            logger.info("Cuenta List::"+c);
        }
        return cuentasList;
    }
    
    @SuppressWarnings("unchecked")
	public List<Cuenta> listCuentaByPersonId(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();                        
        //NativeQuery query = session.getNamedNativeQuery("Cuenta_getByIdPerson");
        Query query = session.getNamedQuery("Cuenta_getByIdPerson");
        query.setParameter("id_person",id);
        List<Cuenta> cuentasList = query.list();
        for(Cuenta c : cuentasList){
            logger.info("Cuenta List::"+c);
        }
        return cuentasList;
    }

	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		
	}
 
}
