package bank_Service;

import java.math.BigDecimal;
import java.util.Scanner;

import bank_Card_Object.BankCard;
import bank_Card_Object.CreditCard;
import bank_message.Interest;
import bank_message.Loans;

public class LoansService implements Interest{
	
	public void Loan(BankCard card , String loan) {
		
		if(card instanceof CreditCard) {
			CreditCard creCard = (CreditCard)card;
			
			System.out.println("您可贷款："+creCard.getCredit()+"元");
			System.out.println("你要贷款："+loan+"元");
			
			if(Double.valueOf(loan) <= Double.valueOf(creCard.getCredit())) {
				
				System.out.println("贷款成功，贷款"+loan+"元。");
				System.out.println("请输入您想还多少期？ 1. 3期  2. 6期  3. 12期");
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
				
				switch (i) {
				case 1:
					double d3 = Double.valueOf(loan) * Double.valueOf(URL_3PERIODS) * 3 + Double.valueOf(loan);
					Loans l1 = new Loans(loan, 3 , String.valueOf(d3));
					creCard.setLoans(l1);
					System.out.println(creCard.getLoans().toString());
					
					double   f3   =   d3/3;  
					BigDecimal   b3   =   new   BigDecimal(f3);  
					double   f31   =   b3.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					System.out.println("每期需还款"+f31+"元");
					
					break;
				case 2:
					double d6 = Double.valueOf(loan) * Double.valueOf(URL_6PERIODS) * 3 + Double.valueOf(loan);
					Loans l2 = new Loans(loan, 6 , String.valueOf(d6));
					creCard.setLoans(l2);
					System.out.println(creCard.getLoans().toString());
					
					double   f6   =   d6/6;  
					BigDecimal   b6   =   new   BigDecimal(f6);  
					double   f61   =   b6.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					System.out.println("每期需还款"+f61+"元");
					
					break;
				case 3:
					double d12 = Double.valueOf(loan) * Double.valueOf(URL_12PERIODS) * 3 + Double.valueOf(loan);
					Loans l3 = new Loans(loan, 12 , String.valueOf(d12));
					creCard.setLoans(l3);
					System.out.println(creCard.getLoans().toString());
					
					//在除不尽的时候，保留两位小数
					double   f12   =   d12/12;  
					BigDecimal   b12   =   new   BigDecimal(f12);  
					double   f121   =   b12.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					System.out.println("每期需还款"+f121+"元");
					
					break;
					
				default:
					break;
				}

				
			}else {
				
				System.out.println("信用额度不够，贷款失败。");
				
			}
			
		}else {
			System.out.println("你的卡不支持贷款。");
		}
		
	}
	
	
	public void Repayment(BankCard card , String Repay) {
		if(card instanceof CreditCard) {
			CreditCard creCard = (CreditCard)card;
			
			if(Double.valueOf(Repay) <= Double.valueOf(creCard.getMoney().getMoney())) {

				//卡里的钱扣了
				creCard.getMoney().setMoney(String.valueOf(Double.valueOf(creCard.getMoney().getMoney()) - Double.valueOf(Repay)));
				//还要换的钱（需要还的钱扣了）
				creCard.getLoans().setMoney(String.valueOf(Double.valueOf(creCard.getLoans().getMoney()) - Double.valueOf(Repay)));
				System.out.println("还款成功，已还款"+Repay
						+"元，还需还款"+creCard.getLoans().getMoney()
						+"元，剩余还款期数："+(creCard.getLoans().getPeriods()-1)
						+"期");
				if(Double.valueOf(creCard.getLoans().getMoney()) > 0.0) {
				
				//还要还的期数-1
				creCard.getLoans().setPeriods(creCard.getLoans().getPeriods() - 1);
				if(creCard.getLoans().getPeriods() == 0 ) {
					System.out.println("还没还完钱就跑了，你的信用被扣光了    -_-# ");
				}
				
				}else {
					System.out.println("还完了 多的就不退给你了    :) ");
				}

				
			}else {
				System.out.println("余额不足请存钱");
			}
			
		}
		
	}

}
