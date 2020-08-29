package StergereSir;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		int i;
		int[] sir = { 6, 1, 2, 12, 77, 45, 3, 9, 8, 19, 98, 11};
		System.out.println(Arrays.toString(sir));
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Introduceti pozitia:");
		int p= scanner.nextInt();
		while (p<0 || p>sir.length)
		{
			System.out.println("Pozitia nu este corecta, introdu alta pozitie:");
			p= scanner.nextInt();
		}
		System.out.println("Pozitia este corecta.");
		
		ArrayList<String> nou=new ArrayList<String>();
		String nul= "null";
		
		for (i=0; i<sir.length; i++)
		{		
				if (i<p)
					nou.add(sir[i]+"");
				
				if (i>=p && i<sir.length-1)
				{	
					sir[i]=sir[i+1];
					nou.add(sir[i]+"");
				}
				if (i==sir.length-1)
					nou.add(nul);
		}
		
		System.out.println(nou);
		
		
	}
}