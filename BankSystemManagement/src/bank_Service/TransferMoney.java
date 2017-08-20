package bank_Service;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;

public class TransferMoney {
	
	public void Transfer(BankCard card1 , BankCard card2 , String money) {
		
		if(card1 instanceof DepositCard) {
			DepositCard depCard1 = (DepositCard)card1;
			if(card2 instanceof DepositCard) {
				DepositCard depcard2 = (DepositCard)card2;
				if(Double.parseDouble(depCard1.getMoney().getMoney()) >= Double.parseDouble(money)) {
				new DepositAndWithdrawMoneyService().WithdrawMoney(depCard1, money);
				new DepositAndWithdrawMoneyService().DepositMoney(depcard2, money);
				}else {
					System.out.println("没钱就不要转账了.... TAT");
				}
			}
			
		}
		
	}
	

}
