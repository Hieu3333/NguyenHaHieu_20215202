package SE;

import java.util.Scanner;
import java.lang.Math;

public class SolveEquation {

	public static void main(String[] args) {
		System.out.println("1. First-degree linear equation.");
		System.out.println("2. System of first-degree linear equations.");
		System.out.println("3. Second-degree equation.");
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		switch (choice)
		{
		case 1: solveLinearEquation(); break;
		case 2: solveSystemOfLinearEquation(); break;
		case 3: solveQuadraticEquation(); break;
			
		}

	}
	
	static void solveLinearEquation() {
		double a,b;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("a= ");
		a= keyboard.nextDouble();
		System.out.print("b= ");
		b= keyboard.nextDouble();
		if (a==0)
		{
			System.out.println("Equation has no root");
		}
		else
		{
			double x=-b/a;
			System.out.println(x);
		}
	}
	
	
	static void solveSystemOfLinearEquation() {
		double a11, a12, b1, a21, a22, b2;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("a11= ");
		a11= keyboard.nextDouble();
		System.out.print("a12= ");
		a12= keyboard.nextDouble();
		System.out.print("b1= ");
		b1= keyboard.nextDouble();
		System.out.print("a21= ");
		a21= keyboard.nextDouble();
		System.out.print("a22= ");
		a22= keyboard.nextDouble();
		System.out.print("b2= ");
		b2= keyboard.nextDouble();
		
		double D= a11*a22-a21*a12;
		double D1= b1*a22-b2*a12;
		double D2= a11*b2-a21*b1;
		if (D==0)
		{
			if (D1==0 || D2==0 )
			{
				System.out.println("Equation has infinitely many solutions");
			}
			else 
			{
				System.out.println("Equation has no solution");
			}
		}
		else
		{
			System.out.println("x1 = "+(D1/D));
			System.out.println("x2 = "+(D2/D));
		}
	}
	
	
	
	
	
	
	
	
	
	static void solveQuadraticEquation() {
		double a,b,c;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("a= ");
		a= keyboard.nextDouble();
		System.out.print("b= ");
		b= keyboard.nextDouble();
		System.out.print("c= ");
		c= keyboard.nextDouble();

		double delta= b*b - 4*a*c;
		if (delta>0)
		{
			System.out.println("Equation has 2 roots: "+(-b+Math.sqrt(delta))/(2*a)+" and "+(-b-Math.sqrt(delta))/(2*a));	
		}
		if (delta==0)
		{
			System.out.println("Equation has double root: "+ (-b/(2*a)));
		}
		else 
		{
			System.out.println("Equation has no root.");
		}

	}

}
