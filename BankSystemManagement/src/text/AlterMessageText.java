package text;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;
import bank_Service.AlterMessageService;
import bank_message.Money;
import bank_message.PersonMessage;

public class AlterMessageText {

	public static void main(String[] args) {
		Money m1 = new Money(new String("0.00"));
		PersonMessage p1 = new PersonMessage("Tom", "DEMAXIYA-01", "1234567");
		BankCard card1 = new DepositCard("BACK-1234", new int[] { 1, 2, 3, 4, 5, 6 }, m1, p1);

		System.out.println(card1.toString());

		new AlterMessageService().AlterMessage(card1);
		System.out.println("");
		System.out.println(card1.toString());

	}

}
