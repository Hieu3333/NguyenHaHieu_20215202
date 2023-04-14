package Matrix;

public class AddMatrix {

	public static void main(String[] args) {
		int[][] mat1 = { {2,2},{3,4}};
		int[][] mat2 = {{1,3},{4,2}};
		int[][] matAns = new int[2][2];
		
		for (int i=0; i<2; i++)
		{
			for (int j=0; j<2; j++)
			{
				matAns[i][j]= mat1[i][j]+ mat2[i][j];
				System.out.print(matAns[i][j]+" ");
			}
			System.out.println();
		}
		
				

	}

}
