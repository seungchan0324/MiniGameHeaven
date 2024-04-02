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
			return "아이디: " + id + "\n이메일: " + email + "\n비밀번호: " + pass + 
					"\n생년월일" + birthday+ "\n포인트" + point;
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

		System.out.println("회원 가입을 시작합니다.");
		
		while (true) {
			System.out.print("아이디 입력: ");
			String id = sc.nextLine();
			System.out.println("비밀번호 입력: ");
			String pass = sc.nextLine();
			System.out.println("이메일 입력: ");
			String email = sc.nextLine();
			System.out.print("생년월일 입력(숫자 YYMMDD): ");
			String birthday = sc.nextLine();

			if (hm.containsKey(id)) {
				System.out.println("중복된 아이디입니다.");
				continue;
			}
			if (emailcheck(email)) {
				System.out.println("중복된 이메일입니다.");
				continue;
			}

			// Join join = new Join(id, email, pass, birthday, point);
			// hm.put(id, join);

			System.out.println(id + "님의 회원 가입이 완료되었습니다.");
			System.out.println("로그인 페이지에서 로그인해 주세요.");
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