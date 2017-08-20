package bank_Service;

import java.util.Scanner;

import bank_Card_Object.BankCard;
import bank_Card_Object.CreditCard;
import bank_Card_Object.DepositCard;
import bank_Exception.LogInException;

public class LogInService {

	// log in ....
	int count = 0;

	public void logIn(BankCard card) {

		if (card instanceof DepositCard) {

			// ת��
			DepositCard depCard = (DepositCard) card;

			// ��������
			Scanner sc = new Scanner(System.in);
			System.out.print("���������룺");
			int[] i = new int[6];
			for (int j = 0; j < i.length; j++) {
				i[j] = sc.nextInt();
			}

			// check����
			boolean temp = true;
			for (int x = 0, y = 0; x < i.length; x++, y++) {
				if (i[x] == depCard.getPassword()[y]) {
					temp = true;
				} else
					temp = false;
			}

			// try---catch
			try {
				if (temp) {
					System.out.println("��½�ɹ�");
				} else
					throw new LogInException();
			} catch (LogInException e) {

				// ��ӡ����
				System.out.println(e.getMessage());

				// The Count ȷ����ʱ����
				count++;
				if (count == 3) {
					System.out.println("���ԵĴ������࣬��ֹͣ����.... TAT ");
					System.exit(0);// ��������
				}

				this.logIn(card);
			}
		} else if (card instanceof CreditCard) {

//			// ת��
//			CreditCard creCard = (CreditCard) card;
//
//			// ��������
//			Scanner sc = new Scanner(System.in);
//			System.out.print("���������룺");
//			int[] i = new int[6];
//			for (int j = 0; j < i.length; j++) {
//				i[j] = sc.nextInt();
//			}
//
//			// check����
//			boolean temp = true;
//			for (int x = 0, y = 0; x < i.length; x++, y++) {
//				if (i[x] == depCard.getPassword()[y]) {
//					temp = true;
//				} else
//					temp = false;
//			}
//
//			// try---catch
//			try {
//				if (temp) {
//					System.out.println("��½�ɹ�");
//				} else
//					throw new LogInException();
//			} catch (LogInException e) {
//
//				// ��ӡ����
//				System.out.println(e.getMessage());
//
//				// The Count ȷ����ʱ����
//				count++;
//				if (count == 3) {
//					System.out.println("���ԵĴ������࣬��ֹͣ����.... TAT ");
//					System.exit(0);// ��������
//				}
//
//				this.logIn(card);
//			}
		}

	}

}
