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

			// 转型
			DepositCard depCard = (DepositCard) card;

			// 输入密码
			Scanner sc = new Scanner(System.in);
			System.out.print("请输入密码：");
			int[] i = new int[6];
			for (int j = 0; j < i.length; j++) {
				i[j] = sc.nextInt();
			}

			// check密码
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
					System.out.println("登陆成功");
				} else
					throw new LogInException();
			} catch (LogInException e) {

				// 打印错误
				System.out.println(e.getMessage());

				// The Count 确定何时结束
				count++;
				if (count == 3) {
					System.out.println("尝试的次数过多，已停止运行.... TAT ");
					System.exit(0);// 结束程序
				}

				this.logIn(card);
			}
		} else if (card instanceof CreditCard) {

//			// 转型
//			CreditCard creCard = (CreditCard) card;
//
//			// 输入密码
//			Scanner sc = new Scanner(System.in);
//			System.out.print("请输入密码：");
//			int[] i = new int[6];
//			for (int j = 0; j < i.length; j++) {
//				i[j] = sc.nextInt();
//			}
//
//			// check密码
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
//					System.out.println("登陆成功");
//				} else
//					throw new LogInException();
//			} catch (LogInException e) {
//
//				// 打印错误
//				System.out.println(e.getMessage());
//
//				// The Count 确定何时结束
//				count++;
//				if (count == 3) {
//					System.out.println("尝试的次数过多，已停止运行.... TAT ");
//					System.exit(0);// 结束程序
//				}
//
//				this.logIn(card);
//			}
		}

	}

}
