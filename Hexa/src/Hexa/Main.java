package Hexa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) {
	
		List<Shape> shapes = new ArrayList<>();
		shapes.add( new Square("#6e45bf", 2, 10));
		shapes.add( new Rectangle("#f5f6f5", 3, 6, 12));
		shapes.add( new Circle("#f5f6f5", 2, 4));
		shapes.add( new Rectangle("#f27e7e", 3, 5, 12));

		
		for(Shape s: shapes)
		{
						
			System.out.println("Name of the shape: ");			
			System.out.println(s.getName());
			
			System.out.println("Area of the shape: ");	
			System.out.println(s.getArea());
			
			System.out.println("Border width: ");	
			System.out.println(s.getBorderWidth());
			
			System.out.println("Hex color: ");	
			System.out.println(s.getHexFillColor());
			
			System.out.println();
			s.draw();
			System.out.println();
			
		}	
		
		
		String stringArray[] = new String[shapes.size()];
		int z=0;
		for(Shape s: shapes)
		{
			stringArray[z]=s.getHexFillColor();
			z++;							
		}
		
				
	    Arrays.sort(stringArray);
		
	    int numberOfAppearance;
			  
		for(int i=0; i<stringArray.length; i++)
		{
		  		
			if(stringArray[i] == stringArray[i+1])
			{
			    i++;
			}
			
			numberOfAppearance = countOccurrences(stringArray, stringArray.length, stringArray[i]);
			
			System.out.println(stringArray[i] + " - " + numberOfAppearance );				
			
		}			
		
	}
	
	
	static int countOccurrences(String arr[], int n, String x)
	{ 
	    int res = 0; 
	    for (int i=0; i<n; i++) 
	        if (x == arr[i]) 
	          res++; 
	    return res; 
	} 

}
