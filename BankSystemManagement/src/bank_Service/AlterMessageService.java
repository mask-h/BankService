package bank_Service;

import java.util.Scanner;

import bank_Card_Object.BankCard;
import bank_Card_Object.DepositCard;

public class AlterMessageService {

	public void AlterMessage(BankCard card) {

		System.out.println("��ѡ��Ҫ�޸ĵ���Ϣ��1.���루password��2.Ԥ���绰��tel��");
		Scanner sc = new Scanner(System.in);
		System.out.print("��ѡ��:");
		int temp = sc.nextInt();

		if (card instanceof DepositCard) {

			// ת��
			DepositCard depCard = (DepositCard) card;

			switch (temp) {
			case 1:
				// ������������
				Scanner sc1 = new Scanner(System.in);
				System.out.print("�����������룺");
				int[] i = new int[6];
				for (int j = 0; j < i.length; j++) {
					i[j] = sc1.nextInt();
				}

				Scanner sc2 = new Scanner(System.in);
				System.out.print("���ٴ����������룺");
				int[] t = new int[6];
				for (int j = 0; j < t.length; j++) {
					t[j] = sc2.nextInt();
				}

				// ��֤���������Ƿ���ͬ
				boolean pswdkey = true;
				for (int x = 0, y = 0; x < i.length; x++, y++) {
					if (i[x] == t[y]) {
						pswdkey = true;
					} else
						pswdkey = false;
				}

				if (pswdkey) {
					depCard.setPassword(i);
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("���������������¿�ʼ...TAT");
					System.out.println("");
					this.AlterMessage(card);
				}

				break;

			case 2:
				// ����绰
				Scanner sc3 = new Scanner(System.in);
				System.out.print("���������µ绰��");
				String newTel = sc3.next();

				// ������֤��
				System.out.print("��������֤�루Ĭ��123456����");
				String captcha = new String("123456");
				Scanner sc4 = new Scanner(System.in);
				String newCaptcha = sc4.next();

				// ��֤��֤��
				boolean telkey = true;
				if (captcha.equals(newCaptcha)) {
					telkey = true;
				} else
					telkey = false;

				if (telkey) {
					depCard.getPersonMessage().setTel(newTel);
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("���������֤�����������¿�ʼ...TAT");
					System.out.println("");
					this.AlterMessage(card);
				}

				break;
			}
		}

	}

}
