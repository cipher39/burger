package sant.menu.burger.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sant.menu.burger.dao.model.Emp;
import sant.menu.burger.dao.repository.BurgerRespository;

@Service
public class BurgerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BurgerService.class);
	
	@Autowired
	private BurgerRespository repo;
	
	public Emp getEmployee(Integer id) {
		LOGGER.info("IN BurgerService.getEmployee() with id= {}", id);
		Emp customer = repo.findByEmpId(id);
		LOGGER.info("OUT BurgerService.getEmployee() with customer= {}", customer);
		return customer;
	}
	
	public boolean addEmployee(Emp emp) {
		LOGGER.info("IN BurgerService.addEmployee() with emp={}", emp);
		boolean resp = false;
		try {
			repo.save(emp);
			resp = true;
		}catch(Exception e){
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("OUT BurgerService.addEmployee() with resp= {}", resp);
		return resp;
	}

}
