package sant.menu.burger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sant.menu.burger.dao.model.Emp;
import sant.menu.burger.service.BurgerService;

@RestController
@RequestMapping(value="/burger")
public class BurgerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BurgerController.class);
	
	@Autowired
	private BurgerService burgerService;
	
	@RequestMapping(value="/emp/name/{id}", method=RequestMethod.GET)
	public String getEmployeeName(@PathVariable Integer id) {
		LOGGER.info("IN BurgerController.getEmployeeName() with id= {}", id);
		String empName = burgerService.getEmployee(id).getName();
		LOGGER.info("OUT BurgerController.getEmployeeName() with customerName= {}", empName);
		return empName;
	}
	
	@RequestMapping(value="/addemployee", method=RequestMethod.POST)
	public boolean addEmployee(@RequestBody Emp emp) {
		LOGGER.info("IN BurgerController.addEmployee() with emp={}", emp);
		boolean resp = burgerService.addEmployee(emp);
		LOGGER.info("OUT BurgerController.addEmployee() with resp= {}", resp);
		return resp;
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public Emp getEmployee(@RequestParam Integer id) {
		LOGGER.info("IN BurgerController.getEmployee() with id= {}", id);
		Emp emp = burgerService.getEmployee(id);
		LOGGER.info("OUT BurgerController.getEmployee() with getEmployee= {}", emp);
		return emp;
	}

}
