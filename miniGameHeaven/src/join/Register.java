package join;

import java.util.HashMap;
import java.util.Scanner;

public class A_Join {

	public static HashMap<String, Join> hm = new HashMap<>();

	public static class Join {
		String id;
		String email;
		String pass;
		String birthday;
		int point;

		public Join(String id, String email, String pass, String birthday,int point) {
			this.id = id;
			this.email = email;
			this.pass = pass;
			this.birthday = birthday;
			this.point=point;

		
		}

		@Override
		public String toString() {
			return "���̵�: " + id + "\n�̸���: " + email + "\n��й�ȣ: " + pass + 
					"\n�������" + birthday+ "\n����Ʈ" + point;
		}

		public String getEmail() {
			return email;
		}

		public String getPass() {
			return pass;
		}

		public String getBirthday() {
			return birthday;
		}
		public Object getPoint() {
			return point;
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

			// Join join = new Join(id, email, pass, birthday, point);
			// hm.put(id, join);

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