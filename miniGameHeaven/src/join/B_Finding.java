package join;

import java.util.HashMap;
import java.util.Scanner;

import join.A_Join.Join;

public class B_Finding {

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

			for (A_Join.Join join : A_Join.hm.values()) {
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

			A_Join.Join join = A_Join.hm.get(id);
			if (join.email.equals(emailPw) && join.birthday.equals(birthdayPw)) {
				System.out.println("ȸ������ ��й�ȣ�� " + join.pass + "�Դϴ�.");
				return;
			}

			System.out.println("���� ������ �������� �ʽ��ϴ�.");

			break;

		}// switch

	}

}
