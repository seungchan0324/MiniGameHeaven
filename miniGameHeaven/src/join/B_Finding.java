package join;

import java.util.HashMap;
import java.util.Scanner;

import join.A_Join.Join;

public class B_Finding {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("아이디 찾기 >> 1/ 비밀번호 찾기 >> 2");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.println("아이디 찾기.");
			System.out.println("가입 시 입력한 이메일을 입력하세요.");
			String email = sc.nextLine();
			System.out.println("생년월일(숫자 YYMMDD)을 입력하세요.");
			String birthday = sc.nextLine();

			for (A_Join.Join join : A_Join.hm.values()) {
				if (join.email.equals(email) && join.birthday.equals(birthday)) {
					System.out.println("회원님의 아이디는 " + join.id + "입니다.");
					return;
				}
			}
			System.out.println("가입 정보가 존재하지 않습니다.");
			break;

		case 2:
			System.out.println("비밀번호 찾기.");
			System.out.println("아이디를 입력하세요.");
			String id = sc.nextLine();
			System.out.println("가입 시 입력한 이메일을 입력하세요.");
			String emailPw = sc.nextLine();
			System.out.println("생년월일(숫자 YYMMDD)을 입력하세요.");
			String birthdayPw = sc.nextLine();

			A_Join.Join join = A_Join.hm.get(id);
			if (join.email.equals(emailPw) && join.birthday.equals(birthdayPw)) {
				System.out.println("회원님의 비밀번호는 " + join.pass + "입니다.");
				return;
			}

			System.out.println("가입 정보가 존재하지 않습니다.");

			break;

		}// switch

	}

}
