package join;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;

import Main_Interface.Main_Interface;

public class A_Join {

	public static HashMap<String, Join> hm = new HashMap<>();

	static class Join {
		String id;
		String email;
		String pass;
		String birthday;

		public Join(String id, String email, String pass, String birthday) {
			this.id = id;
			this.email = email;
			this.pass = pass;
			this.birthday = birthday;

		}

		@Override
		public String toString() {
			return "���̵�: " + id + "\n�̸���: " + email + "\n��й�ȣ: " + pass + "\n�������" + birthday;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("ȸ�� ������ �����մϴ�.");
		while (true) {
			System.out.print("���̵� �Է�: ");
			String id = sc.nextLine();
			System.out.println("��й�ȣ �Է�: ");
			String pass = sc.nextLine();
			System.out.println("�̸��� �Է�: ");
			String email = sc.nextLine();
			System.out.print("������� �Է�(���� YYMMDD): ");
			String birthday = sc.nextLine();

			if (hm.containsKey(id)) {
				System.out.println("�ߺ��� ���̵��Դϴ�.");
				continue;
			}
			if (emailcheck(email)) {
				System.out.println("�ߺ��� �̸����Դϴ�.");
				continue;
			}

			Join join = new Join(id, email, pass, birthday);
			hm.put(id, join);

			System.out.println(id + "���� ȸ�� ������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("�α��� ���������� �α����� �ּ���.");
			break;

		}

	}

	 static boolean emailcheck(String email) {
		for (Join join : hm.values()) {
			if (join.email.equals(email)) {
				return true;
			}
		}
		return false;
	}

}