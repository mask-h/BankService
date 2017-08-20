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
			
			System.out.println("���ɴ��"+creCard.getCredit()+"Ԫ");
			System.out.println("��Ҫ���"+loan+"Ԫ");
			
			if(Double.valueOf(loan) <= Double.valueOf(creCard.getCredit())) {
				
				System.out.println("����ɹ�������"+loan+"Ԫ��");
				System.out.println("���������뻹�����ڣ� 1. 3��  2. 6��  3. 12��");
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
					System.out.println("ÿ���軹��"+f31+"Ԫ");
					
					break;
				case 2:
					double d6 = Double.valueOf(loan) * Double.valueOf(URL_6PERIODS) * 3 + Double.valueOf(loan);
					Loans l2 = new Loans(loan, 6 , String.valueOf(d6));
					creCard.setLoans(l2);
					System.out.println(creCard.getLoans().toString());
					
					double   f6   =   d6/6;  
					BigDecimal   b6   =   new   BigDecimal(f6);  
					double   f61   =   b6.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					System.out.println("ÿ���軹��"+f61+"Ԫ");
					
					break;
				case 3:
					double d12 = Double.valueOf(loan) * Double.valueOf(URL_12PERIODS) * 3 + Double.valueOf(loan);
					Loans l3 = new Loans(loan, 12 , String.valueOf(d12));
					creCard.setLoans(l3);
					System.out.println(creCard.getLoans().toString());
					
					//�ڳ�������ʱ�򣬱�����λС��
					double   f12   =   d12/12;  
					BigDecimal   b12   =   new   BigDecimal(f12);  
					double   f121   =   b12.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					System.out.println("ÿ���軹��"+f121+"Ԫ");
					
					break;
					
				default:
					break;
				}

				
			}else {
				
				System.out.println("���ö�Ȳ���������ʧ�ܡ�");
				
			}
			
		}else {
			System.out.println("��Ŀ���֧�ִ��");
		}
		
	}
	
	
	public void Repayment(BankCard card , String Repay) {
		if(card instanceof CreditCard) {
			CreditCard creCard = (CreditCard)card;
			
			if(Double.valueOf(Repay) <= Double.valueOf(creCard.getMoney().getMoney())) {

				//�����Ǯ����
				creCard.getMoney().setMoney(String.valueOf(Double.valueOf(creCard.getMoney().getMoney()) - Double.valueOf(Repay)));
				//��Ҫ����Ǯ����Ҫ����Ǯ���ˣ�
				creCard.getLoans().setMoney(String.valueOf(Double.valueOf(creCard.getLoans().getMoney()) - Double.valueOf(Repay)));
				System.out.println("����ɹ����ѻ���"+Repay
						+"Ԫ�����軹��"+creCard.getLoans().getMoney()
						+"Ԫ��ʣ�໹��������"+(creCard.getLoans().getPeriods()-1)
						+"��");
				if(Double.valueOf(creCard.getLoans().getMoney()) > 0.0) {
				
				//��Ҫ��������-1
				creCard.getLoans().setPeriods(creCard.getLoans().getPeriods() - 1);
				if(creCard.getLoans().getPeriods() == 0 ) {
					System.out.println("��û����Ǯ�����ˣ�������ñ��۹���    -_-# ");
				}
				
				}else {
					System.out.println("������ ��ľͲ��˸�����    :) ");
				}

				
			}else {
				System.out.println("�������Ǯ");
			}
			
		}
		
	}

}
