package register;

import java.util.Scanner;

public class �Ƶ���ã�⶧��� {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("���̵� ã�� >> 1/ ��й�ȣ ã�� >> 2");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.println("���̵� ã��.");
			System.out.println("���� �� �Է��� �̸����� �Է��ϼ���.");
			String email = sc.nextLine();
			System.out.println("�������(���� YYMMDD)�� �Է��ϼ���.");
			String birthday = sc.nextLine();

			for (Register.Join join : Register.hm.values()) {
				if (join.email.equals(email) && join.birthday.equals(birthday)) {
					System.out.println("ȸ������ ���̵�� " + join.id + "�Դϴ�.");
					return;
				}
			}
			System.out.println("���� ������ �������� �ʽ��ϴ�.");
			break;

		case 2:
			System.out.println("��й�ȣ ã��.");
			System.out.println("���̵� �Է��ϼ���.");
			String id = sc.nextLine();
			System.out.println("���� �� �Է��� �̸����� �Է��ϼ���.");
			String emailPw = sc.nextLine();
			System.out.println("�������(���� YYMMDD)�� �Է��ϼ���.");
			String birthdayPw = sc.nextLine();

			Register.Join join = Register.hm.get(id);
			if (join.email.equals(emailPw) && join.birthday.equals(birthdayPw)) {
				System.out.println("ȸ������ ��й�ȣ�� " + join.pass + "�Դϴ�.");
				return;
			}

			System.out.println("���� ������ �������� �ʽ��ϴ�.");

			break;

		}// switch

	}

}
