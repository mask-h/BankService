package text;

import bank_Card_Object.BankCard;
import bank_Card_Object.CreditCard;
import bank_Service.LoansService;
import bank_message.Money;
import bank_message.PersonMessage;

public class CreditCardText {
	public static void main(String[] args) {
		
			Money m1 = new Money(new String("100000.00"));
			PersonMessage p1 = new PersonMessage("Tom", "DEMAXIYA-01", "1234567");
			BankCard card1 = new CreditCard("BACK-123456",new int[]{1,2,3,4,5,6} , m1, p1);
			
			System.out.println(card1.toString());
			
			new LoansService().Loan(card1, "40000.0");
			
			new LoansService().Repayment(card1, "2000");
			new LoansService().Repayment(card1, "2000");
			new LoansService().Repayment(card1, "37100");
			

		
	}

}
