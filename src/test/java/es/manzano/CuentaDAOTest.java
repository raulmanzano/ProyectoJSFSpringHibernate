package es.manzano;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.springhibernate.dao.CuentaDAO;
import com.journaldev.springhibernate.dao.PersonDAO;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/es/manzano/applicationContext.xml"})
public class CuentaDAOTest implements ApplicationContextAware {

	@Autowired
	 private CuentaDAO cuentaDAO;
	@Autowired
	 private PersonDAO personDAO;

	 @Override
	    public void setApplicationContext(ApplicationContext context)
	            throws BeansException
	    {
	     
	    }
	
	
	@Test
	@Transactional
	public void test() {
		
		//System.out.println(cuentaDAO.listCuenta());
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		//System.out.println(personDAO.listPersons());
	}

}


