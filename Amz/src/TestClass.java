import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        while(N > 0){
            int no = s.nextInt();
            int count = 0;
            for (int i = 1; i < no; i++) {
           for(int j= i+1; j < no; j++){
        	   int val = i ^ j;
//        	   System.out.println("value is :  "  + val);
               if (val <= no){
            	   count++;
               }
           }
        }
         System.out.println(count);
            N--;
        }
    }
}
