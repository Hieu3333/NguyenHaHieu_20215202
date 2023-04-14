
import java.util.Scanner;
public class NumberOfDays {

	public static void main(String[] args) {
		String month;
		int year;
		int day=0;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter month:");
		month= keyboard.nextLine();
		
		System.out.print("Enter year:");
		year = keyboard.nextInt();
		switch (month) {
		case "2":
		case "Feb":
		case "Feb.":
		case "February": {
			if (year % 4 ==0) {
				day=29;
			}
			else day=28;
			break;
		}
		
		case "1": case "Jan": case "Jan.": case "January": 
		case "3": case "Mar": case "Mar.": case "March":
		case "5": case "May": 
		case "7": case "Jul": case "July": 
		case "8": case "Aug": case "Aug.": case "August":
		case "10": case "Oct": case "Oct.": case "October":
		case "12": case "Dec": case "Dec.": case "December":
			{day=31;
			break;}
		
		case "4": case "Apr": case "Apr.": case "April":
		case "6": case "Jun": case "Jun.": case "June":
		case "9": case "Sep": case "Sep.": case "September":
		case "11": case "Nov": case "Nov.": case "November":
		{
			day=30;
			break;
		}
		default :
			System.out.println("Wrong month");

	}
	System.out.println("Number of days: "+ day);

}
}
