package bank_Service;

import java.math.BigDecimal;
import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;

public class DepositAndWithdrawMoneyService {
	
	//存钱
	public void DepositMoney(BankCard card , String add) {
		
		if(card instanceof DepositCard) {
			DepositCard depCard = (DepositCard)card;
			
			BigDecimal big1 = new BigDecimal(depCard.getMoney()/*返回了一个Money类*/.getMoney()/*返回了一个String*/);
			BigDecimal big2 = new BigDecimal(add);
			
			//BigDecimal 是一个包装类，用toString方法返回一个String类
			depCard.getMoney().setMoney(big1.add(big2).toString());
			
			System.out.println("已存入："+add+"元");
			System.out.println("余额为："+depCard.getMoney().getMoney()+"元");
			
		}
		
		
		
	}
	
	//取钱
	public void WithdrawMoney(BankCard card , String sub) {
		
		if(card instanceof DepositCard) {
			DepositCard depCard = (DepositCard)card;
			
			if(Double.parseDouble(depCard.getMoney().getMoney()) >= Double.parseDouble(sub)) {
				
				BigDecimal big1 = new BigDecimal(depCard.getMoney().getMoney());
				BigDecimal big2 = new BigDecimal(sub);
				
				depCard.getMoney().setMoney(big1.subtract(big2).toString());
				
				System.out.println("成功取款"+sub+"元，祝你愉快！");
				System.out.println("余额为："+depCard.getMoney().getMoney()+"元");
				
			}else {
				System.out.println("你只有"+depCard.getMoney().getMoney()+"元\n"+sub+"元？ 取不出来那么多，麻溜存钱去.....");
			}

			
		}
		
		
	}

}
