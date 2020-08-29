package CautareBinara;


import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		int[] sir = new int[10];
		sir[0] = 6;
		sir[1] = 1;
		sir[2] = 19;
		sir[3] = 98;
		sir[4] = 12;
		sir[5] = 77;
		sir[6] = 45;
		sir[7] = 2;
		sir[8] = 3;
		sir[9] =9;
		Arrays.sort(sir);
		boolean a = false;
		int b = 0;
		System.out.println(java.util.Arrays.toString(sir));
		System.out.println("Introduceti numarul cautat :");
		int p = scanner.nextInt();
		CautareBinara(sir, p);

	}


	static boolean CautareBinara(int[] sir, int p) {
		boolean a = false;
		int sol = -1;
		int Left = 0, Right = sir.length - 1;
		while (Left <= Right) {
			int Mid = (Left + Right) / 2;
			if (sir[Mid] == p) {
				a = true;
				sol = Mid;
				break;
			}
			if (sir[Mid] > p)
				Right = Mid - 1;
			if (sir[Mid] < p)
				Left = Mid + 1;
		}
		System.out.println(a);
		if (a == true)
			System.out.printf("Pozitia pe care se afla :%d", sol);
		return a;

	}

}