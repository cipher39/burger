package sant.burger.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sant.burger.consumer.dao.model.Emp;
import sant.burger.consumer.service.BurgerConsumerService;

@RestController
@RequestMapping(value="burger-consumer")
public class BurgerConsumerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BurgerConsumerController.class);
	
	@Autowired
	private BurgerConsumerService consumerService;
	
	@RequestMapping(value="/name/{id}")
	public String getEmployeeName(@PathVariable Integer id) {
		LOGGER.info("inside BurgerConsumerController.getEmployeeName, id={}", id);
		String name = consumerService.getName(id);
		LOGGER.info("OUT BurgerConsumerController.getEmployeeName. Name: {}", name);
		return name;
	}
	
	@RequestMapping(value="/emp/{id}")
	public Emp getEmployee(@PathVariable Integer id) {
		Emp e = consumerService.getEmployee(id);
		return e;
	}
	
	public void addEmployee() {
		Emp emp = new Emp();
		emp.setCustomerId(1234);
		emp.setName("jack");
		LOGGER.info("adding a new customer with Emp = {}", emp);
		LOGGER.info("status after SAVING: {}", consumerService.addEmployee(emp));		
	}
	
	

}
