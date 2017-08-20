package text;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;
import bank_Service.DepositAndWithdrawMoneyService;
import bank_message.Money;
import bank_message.PersonMessage;

public class DepositAndWithdrawMoneyText {

	public static void main(String[] args) {
		Money m1 = new Money(new String("500.00"));
		PersonMessage p1 = new PersonMessage("Tom", "DEMAXIYA-01", "1234567");
		BankCard card1 = new DepositCard("BACK-1234",new int[]{1,2,3,4,5,6} , m1, p1); 
		
		System.out.println(card1.toString());
		
		new DepositAndWithdrawMoneyService().DepositMoney(card1, "500");
		System.out.println(card1.toString());
		
		new DepositAndWithdrawMoneyService().WithdrawMoney(card1, "300");
		System.out.println(card1.toString());
		
		new DepositAndWithdrawMoneyService().WithdrawMoney(card1, "5000");
		System.out.println(card1.toString());

	}

}
