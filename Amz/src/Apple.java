
public class Apple {

	public static void main(String[] args) {
		int[][][] A= {
				{
					{1,2,3},{1,2,3},{1,2,3}
				},
				{
					{1,2,3},{1,2,3},{1,2,3}
				}
		};
		
		printIdArray(A);
	}
	
	
	public static void printIdArray(int[][][] A){

		  int len1 = A.length;
		    int len2 = A[0].length;
		    int len3 = A[0][0].length;
		  
		  int[] result = new int[len1*len2*len3];
		  
		  int resultCount = 0;
		  for(int i = 0 ; i < len1; i++){
		    for(int j = 0 ; j < len2 ; j++){
		      for(int k= 0 ; k < len3; k++){
		        result[resultCount] = A[i][j][k];
		        resultCount++;
		      }
		    }
		  }
		  
		  for(int i = 0; i < result.length ; i++){
			  System.out.print(result[i] + " ");
		  }
		  
		}

}
