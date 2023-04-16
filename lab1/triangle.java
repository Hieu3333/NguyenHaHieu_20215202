package triangle;

import java.util.Scanner;
public class triangle {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n= ");
		int size=keyboard.nextInt();
		for(int i = 1; i <= size; i++){
		    for(int j = 1; j <= size-i; j++){
		    System.out.print(" ");
		    }
		    for(int k = 1; k<= 2*i-1; k++){
		        System.out.print("*");
		    }
		System.out.print("\n");
		}

	}

}
