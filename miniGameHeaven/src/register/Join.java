package register;

import java.util.Scanner;

public class Join {

	String id;
	String pass;
	String email;

	public Join(String id, String pass, String email) {
		this.id = id;
		this.pass = pass;
		this.email = email;
	}
	
	 // 중복 체크 메소드
    private static boolean isDuplicate(Join[] join, int count, String id, String email) {
        for (int i = 0; i < count; i++) {
            if (join[i].id.equalsIgnoreCase(id) || join[i].email.equalsIgnoreCase(email)) {
                return true; // 중복되는 사용자 이름 또는 이메일이 있음
            }
        }
        return false; // 중복 없음
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Join[] join = new Join[50]; //이거 무제한 안되나?
		int count = 0; // 현재 등록된 사용자 수
		
		System.out.println("닉네임 입력 >>");
		String id=sc.nextLine();
		System.out.println("패스워드 입력 >>");
		String pass=sc.nextLine();
		System.out.println("이메일 입력 >>");
		String email=sc.nextLine();
		
		join[count++]=new Join(id, pass, email);
		
		System.out.println(id+"님의 회원 가입이 완료됐습니다.");
		System.out.println("로그인 페이지로 돌아가 로그인해 주세요.");

	}

}
