package sant.menu.burger.dao.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp {
	
	@Id
	@Column(name="EMP_ID")
	private Integer empId;
	
	@Column
	private String name;

	public Integer getCustomerId() {
		return empId;
	}

	public void setCustomerId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [emp=" + empId + ", name=" + name + "]";
	}
	
}
