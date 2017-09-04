package club.lovemo.Biz.Impl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tools {
	Scanner input = new Scanner(System.in);
	
	public String InputName() {
		String pattern = "^[\u4e00-\u9fa5\\w]+$";
		String inputu;
		input.nextLine();
		while (true) {
			inputu = input.nextLine();
			if (Pattern.matches(pattern, inputu)) {
				return inputu;
			} else {
				System.out.println("ע��淶���룬���������룺");
			}
		}
	}

	public String InputPass() {
		String pattern = "^[a-zA-Z0-9]+$";
		String inputp;
//		input.nextLine();
		while (true) {
			inputp = input.nextLine();
			if (Pattern.matches(pattern, inputp)) {
				return inputp;
			} else {
				System.out.println("ע������淶�����������룺");
			}
		}
	}

	public int InputInt() {
		int number = 0;
		while (true) {
			try {
				number = input.nextInt();
				return number;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("������������������!");
				System.out.print("ѡ��");
			}
		}
	}
	public boolean InputName(String inputu) {
		String pattern = "[\u4e00-\u9fa5\\w]";
		if (inputu.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean InputPass(String inputp) {
		String pattern = "[a-zA-Z0-9]";
		if (inputp.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public int Choose(String inputkey) {
		if (inputkey.matches("[0-9]*")) {
			int m = 0;
			m = Integer.parseInt(inputkey);
			return m;
		} else {
			return 0;
		}
	}
}
