package bank_Card_Object;

import java.util.Arrays;

import bank_message.Money;
import bank_message.PersonMessage;

public class DepositCard extends BankCard{
	
	private String backCardNum ;
	private int[] password = new int[6];
	
	private Money money;
	private PersonMessage personMessage;
	
	public DepositCard(String backCardNum, int[] password, Money money, PersonMessage personMessage) {
		this.backCardNum = backCardNum;
		this.password = password;
		this.money = money;
		this.personMessage = personMessage;
	}

	public String getBackCardNum() {
		return backCardNum;
	}

	public void setBackCardNum(String backCardNum) {
		this.backCardNum = backCardNum;
	}

	public int[] getPassword() {
		return password;
	}

	public void setPassword(int[] password) {
		this.password = password;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public PersonMessage getPersonMessage() {
		return personMessage;
	}

	public void setPersonMessage(PersonMessage personMessage) {
		this.personMessage = personMessage;
	}

	@Override
	public String toString() {
		return "DepositCard [backCardNum=" + backCardNum + ", password=" + Arrays.toString(password) + ", money="
				+ money + ", personMessage=" + personMessage + "]";
	}
	
	
	
	

}
