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

import sant.burger.consumer.dao.model.EmpDTO;

@Service
public class BurgerConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BurgerConsumerService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getName(Integer id) {
		String uri = "http://localhost:8080/burger/EmpDTO/name/" + id;
		LOGGER.info("calling uri: {}", uri);
		String name = "";
		
//		Method 1:
//		HttpHeaders httpHeaders = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
//		ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//		name = resp.getBody();
		
//		Method 2: .getForEntity for GET, .postForEntity for POST
		name = restTemplate.getForEntity(uri, String.class).getBody();
		
		LOGGER.info("Exiting BurgerConsumerService.getName() name={}", name);
		return name;
	}
	
	public EmpDTO getEmployee(Integer id) {
		String uri = "http://localhost:8080/burger/emp?id=" + id;
		LOGGER.info("calling uri: {}", uri);
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<EmpDTO> entity = new HttpEntity<EmpDTO>(httpHeaders);
		ResponseEntity<EmpDTO> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, EmpDTO.class);
		EmpDTO emp =  resp.getBody();
		LOGGER.info("Exiting BurgerConsumerService.getEmployee() EmpDTO={}", emp);
		return emp;
	}
	
	public boolean addEmployee(EmpDTO emp) {
		String uri = "http://localhost:8080/burger/addemployee";
		LOGGER.info("calling uri: {}\t EmpDTO: {}", uri, emp);
		
//		Method 1:
//		HttpEntity<EmpDTO> entity = new HttpEntity<EmpDTO>(EmpDTO, new HttpHeaders());
//		ResponseEntity<Boolean> resp = restTemplate.exchange(uri, HttpMethod.POST, entity, Boolean.class);
		
//		Method 2:
		LOGGER.info("calling restTemplate.postForEntity()");
		ResponseEntity<Boolean> resp = restTemplate.postForEntity(uri, emp, Boolean.class);
		
		return resp.getBody();
	}

}
