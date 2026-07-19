package sant.burger.consumer.dao.model;

public class Emp {
	private Integer customerId;
	private String name;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [customerId=" + customerId + ", name=" + name + "]";
	}
	
}
