package bank_Card_Object;

import java.util.Arrays;

import bank_message.Loans;
import bank_message.Money;
import bank_message.PersonMessage;

public class CreditCard extends BankCard{
	
	private String backCardNum ;
	private int[] password = new int[6];
	private String credit;//���õȼ�
	/*
	 * ��¼��û�д��������˶���Ǯ�������ж����ڣ�����Ҫ������Ǯ
	 * �����빹�� �� ���  ֻ��¼��������
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
		 * �����Ǵ��ϵ���ִ�е� �� 
		 * �����õ���money����money��û��ֵ��  ��轫credit����money���� �ᱨ��ָ���쳣
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
	
	//�����Ǽ���õ���    �������ʼ��    ����ͨ��set���޸�
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	//�����빹��
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
