package bank_Service;

import java.util.Scanner;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;

public class AlterMessageService {

	public void AlterMessage(BankCard card) {

		System.out.println("请选择要修改的信息：1.密码（password）2.预留电话（tel）");
		Scanner sc = new Scanner(System.in);
		System.out.print("请选择:");
		int temp = sc.nextInt();

		if (card instanceof DepositCard) {

			// 转型
			DepositCard depCard = (DepositCard) card;

			switch (temp) {
			case 1:
				// 输入两次密码
				Scanner sc1 = new Scanner(System.in);
				System.out.print("请输入新密码：");
				int[] i = new int[6];
				for (int j = 0; j < i.length; j++) {
					i[j] = sc1.nextInt();
				}

				Scanner sc2 = new Scanner(System.in);
				System.out.print("请再次输入新密码：");
				int[] t = new int[6];
				for (int j = 0; j < t.length; j++) {
					t[j] = sc2.nextInt();
				}

				// 验证两次密码是否相同
				boolean pswdkey = true;
				for (int x = 0, y = 0; x < i.length; x++, y++) {
					if (i[x] == t[y]) {
						pswdkey = true;
					} else
						pswdkey = false;
				}

				if (pswdkey) {
					depCard.setPassword(i);
					System.out.println("修改成功！");
				} else {
					System.out.println("您输入有误，请重新开始...TAT");
					System.out.println("");
					this.AlterMessage(card);
				}

				break;

			case 2:
				// 输入电话
				Scanner sc3 = new Scanner(System.in);
				System.out.print("请输入新新电话：");
				String newTel = sc3.next();

				// 输入验证码
				System.out.print("请输入验证码（默认123456）：");
				String captcha = new String("123456");
				Scanner sc4 = new Scanner(System.in);
				String newCaptcha = sc4.next();

				// 验证验证码
				boolean telkey = true;
				if (captcha.equals(newCaptcha)) {
					telkey = true;
				} else
					telkey = false;

				if (telkey) {
					depCard.getPersonMessage().setTel(newTel);
					System.out.println("修改成功！");
				} else {
					System.out.println("您输入的验证码有误，请重新开始...TAT");
					System.out.println("");
					this.AlterMessage(card);
				}

				break;
			}
		}

	}

}
