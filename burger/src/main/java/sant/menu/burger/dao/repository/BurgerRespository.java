package sant.menu.burger.dao.repository;

import org.springframework.data.repository.CrudRepository;

import sant.menu.burger.dao.model.Emp;


public interface BurgerRespository extends CrudRepository<Emp, Integer> {
	Emp findByEmpId(Integer empId);
}
