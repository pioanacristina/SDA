package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Shape> shapes = new ArrayList<>();

		shapes.add( new Square("#6e45bf", 2, 10));

		shapes.add( new Rectangle("#f27e7e", 3, 5, 12));

		shapes.add( new Circle("#f5f6f5", 2, 4));	

		for(Shape s: shapes)

		{

			System.out.print("Forma geometrica este: ");			

			System.out.println(s.getName());

			System.out.print("Aria este: ");	

			System.out.println(s.getArea());

			System.out.print("Border width: ");	

			System.out.println(s.getBorderWidth());

			System.out.print("Hex color: ");	

			System.out.println(s.getHexFillColor());

			System.out.println();

			s.Draw();

			System.out.println();

		}

	}

}