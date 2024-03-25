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
	
	 // �ߺ� üũ �޼ҵ�
    private static boolean isDuplicate(Join[] join, int count, String id, String email) {
        for (int i = 0; i < count; i++) {
            if (join[i].id.equalsIgnoreCase(id) || join[i].email.equalsIgnoreCase(email)) {
                return true; // �ߺ��Ǵ� ����� �̸� �Ǵ� �̸����� ����
            }
        }
        return false; // �ߺ� ����
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Join[] join = new Join[50]; //�̰� ������ �ȵǳ�?
		int count = 0; // ���� ��ϵ� ����� ��
		
		System.out.println("�г��� �Է� >>");
		String id=sc.nextLine();
		System.out.println("�н����� �Է� >>");
		String pass=sc.nextLine();
		System.out.println("�̸��� �Է� >>");
		String email=sc.nextLine();
		
		join[count++]=new Join(id, pass, email);
		
		System.out.println(id+"���� ȸ�� ������ �Ϸ�ƽ��ϴ�.");
		System.out.println("�α��� �������� ���ư� �α����� �ּ���.");

	}

}
