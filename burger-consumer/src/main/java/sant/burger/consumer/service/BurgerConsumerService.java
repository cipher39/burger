package sant.burger.consumer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sant.burger.consumer.dao.model.Emp;

@Service
public class BurgerConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BurgerConsumerService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getName(Integer id) {
		String uri = "http://localhost:8080/burger/emp/name/" + id;
		LOGGER.info("calling uri: {}", uri);
		HttpHeaders httpHeaders = new HttpHeaders();
		
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		
		ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		String name = resp.getBody();
		LOGGER.info("Exiting BurgerConsumerService.getName() name={}", name);
		return name;
	}
	
	public Emp getEmployee(Integer id) {
		String uri = "http://localhost:8080/burger/emp?id=" + id;
		LOGGER.info("calling uri: {}", uri);
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Emp> entity = new HttpEntity<Emp>(httpHeaders);
		ResponseEntity<Emp> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, Emp.class);
		Emp emp =  resp.getBody();
		LOGGER.info("Exiting BurgerConsumerService.getEmployee() emp={}", emp);
		return emp;
	}
	
	public boolean addEmployee(Emp emp) {
		String uri = "http://localhost:8080/burger/addemployees";
		LOGGER.info("calling uri: {}", uri);
		
		HttpEntity<Emp> entity = new HttpEntity<Emp>(emp, new HttpHeaders());
		ResponseEntity<Boolean> resp = restTemplate.exchange(uri, HttpMethod.POST, entity, Boolean.class);
		
		return resp.getBody();
	}

}
