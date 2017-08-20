package bank_message;

import java.math.BigDecimal;

public class Money {
	
	//金融运算使用 BigDecimal
	private String money ;
	
	public Money(String money) {
		this.money = money;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Money [money=" + money + "]";
	} 
	
	

}
