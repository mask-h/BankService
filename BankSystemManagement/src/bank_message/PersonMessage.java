package bank_message;

public class PersonMessage {
	
	private String name;
	private String idCard;
	private String tel;
		
	public PersonMessage(String name, String idCard, String tel) {
		this.name = name;
		this.idCard = idCard;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "PersonMessage [name=" + name + ", idCard=" + idCard + ", tel=" + tel + "]";
	}
	
	
	
	

}
