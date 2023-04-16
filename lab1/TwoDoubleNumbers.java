
// Exercise 2.2.5
import javax.swing.JOptionPane;

public class TwoDoubleNumbers {

	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1= JOptionPane.showInputDialog("Enter num1:");
		strNum2= JOptionPane.showInputDialog("Enter num2:");
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		double sum, diff, product, quotient;
		sum= num1+num2;
		diff=num1-num2;
		product=num1*num2;
		System.out.println("Sum: "+sum);
		System.out.println("Difference: "+diff);
		System.out.println("Product: "+product);
		if (num2 == 0) {
			JOptionPane.showMessageDialog(null,"Can't perform quotient if num2 equals 0");
		}
		else {
		quotient=num1/num2;
		System.out.println("Quotient: "+quotient);
		}
		
	}

}
