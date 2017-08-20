package bank_Service;

import java.math.BigDecimal;
import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;

public class DepositAndWithdrawMoneyService {
	
	//��Ǯ
	public void DepositMoney(BankCard card , String add) {
		
		if(card instanceof DepositCard) {
			DepositCard depCard = (DepositCard)card;
			
			BigDecimal big1 = new BigDecimal(depCard.getMoney()/*������һ��Money��*/.getMoney()/*������һ��String*/);
			BigDecimal big2 = new BigDecimal(add);
			
			//BigDecimal ��һ����װ�࣬��toString��������һ��String��
			depCard.getMoney().setMoney(big1.add(big2).toString());
			
			System.out.println("�Ѵ��룺"+add+"Ԫ");
			System.out.println("���Ϊ��"+depCard.getMoney().getMoney()+"Ԫ");
			
		}
		
		
		
	}
	
	//ȡǮ
	public void WithdrawMoney(BankCard card , String sub) {
		
		if(card instanceof DepositCard) {
			DepositCard depCard = (DepositCard)card;
			
			if(Double.parseDouble(depCard.getMoney().getMoney()) >= Double.parseDouble(sub)) {
				
				BigDecimal big1 = new BigDecimal(depCard.getMoney().getMoney());
				BigDecimal big2 = new BigDecimal(sub);
				
				depCard.getMoney().setMoney(big1.subtract(big2).toString());
				
				System.out.println("�ɹ�ȡ��"+sub+"Ԫ��ף����죡");
				System.out.println("���Ϊ��"+depCard.getMoney().getMoney()+"Ԫ");
				
			}else {
				System.out.println("��ֻ��"+depCard.getMoney().getMoney()+"Ԫ\n"+sub+"Ԫ�� ȡ��������ô�࣬�����Ǯȥ.....");
			}

			
		}
		
		
	}

}
