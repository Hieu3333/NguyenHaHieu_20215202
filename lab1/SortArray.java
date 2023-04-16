package Array;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		int arr[] = {1789, 2035, 1899, 1456, 2013};
		
		for (int i=0; i<arr.length-1; i++)
		{
			for (int j=i+1; j<arr.length; j++)
			{
				if (arr[i]>arr[j])
				{
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		int sum=0;
		for (int i=0; i<arr.length; i++)
		{
			sum+=arr[i];
		}
		System.out.println("Sum: "+sum);
		
		double avg=(double) sum/(double) arr.length;
		System.out.println("Average: "+avg);
	}

}
