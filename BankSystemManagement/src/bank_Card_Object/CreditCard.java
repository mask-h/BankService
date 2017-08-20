package bank_Card_Object;

import java.util.Arrays;

import bank_message.Loans;
import bank_message.Money;
import bank_message.PersonMessage;

public class CreditCard extends BankCard{
	
	private String backCardNum ;
	private int[] password = new int[6];
	private String credit;//信用等级
	/*
	 * 记录有没有贷款，贷款贷了多少钱，还有有多少期，还需要还多少钱
	 * 不参与构造 和 输出  只记录贷款数额
	 * */
	private Loans loans;
	
	private Money money;
	private PersonMessage personMessage;
	
	
	
	public CreditCard(String backCardNum, int[] password, Money money, PersonMessage personMessage) {
		this.backCardNum = backCardNum;
		this.password = password;
		this.money = money;
		this.personMessage = personMessage;
		/*
		 * 程序是从上到下执行的 ， 
		 * 这里用到了money，但money是没有值的  如歌将credit放在money上面 会报空指针异常
		 * */
		this.credit = String.valueOf(Double.parseDouble(this.money.getMoney()) * 5);
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
	
	//信用是计算得到的    不参与初始化    但能通过set来修改
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	//不参与构造
	public Loans getLoans() {
		return loans;
	}

	public void setLoans(Loans loans) {
		this.loans = loans;
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
		return "CreditCard [backCardNum=" + backCardNum + ", password=" + Arrays.toString(password) + ", credit="
				+ credit + ", money=" + money + ", personMessage=" + personMessage + "]";
	}
	
	
	

}
