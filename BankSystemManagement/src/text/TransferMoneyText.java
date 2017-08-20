package text;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;
import bank_Service.TransferMoney;
import bank_message.Money;
import bank_message.PersonMessage;

public class TransferMoneyText {
	
	public static void main(String[] args) {
		Money m1 = new Money(new String("500.00"));
		PersonMessage p1 = new PersonMessage("Tom", "DEMAXIYA-01", "1234567");
		BankCard card1 = new DepositCard("BACK-1234",new int[]{1,2,3,4,5,6} , m1, p1); 
		
		Money m2 = new Money(new String("500.00"));
		PersonMessage p2 = new PersonMessage("Jack", "NUOKESASI-01", "7654321");
		BankCard card2 = new DepositCard("BACK-1234",new int[]{1,2,3,4,5,6} , m2, p2);
		
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		
		new TransferMoney().Transfer(card1, card2, "500");
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		
		new TransferMoney().Transfer(card1, card2, "1000");
		System.out.println(card1.toString());
		System.out.println(card2.toString());
	}

}
