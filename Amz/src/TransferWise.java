import java.util.Scanner;
import java.util.Stack;


public class TransferWise {

	public static void main(String[] args) {
		getIntegerComplement(10000);
//		Scanner scan = new Scanner(System.in);
		
	}

	/*
	 * Complete the function below.
	 */

	    static int getIntegerComplement(int n) {
	        //convert to binary
	        Long bin = getConvertedInteger(n, 2);
	        System.out.println("bin : " + bin);
	        //invert no
	        Long inv = getInvertInteger(bin);
	        System.out.println("inv : " + inv);
	       // System.out.println("Inverted no : " + inv);
	        //convert to decimal
	        int dec = getDecimalFromBinary(inv);
	        System.out.println(dec);
	        return dec;
	          

	    }

	    private static int getDecimalFromBinary(Long n){
	        int dec = 0;
	        int pow = 0;
	        while(true){
	            if(n == 0){
	                break;
	            }else{
	                Long tmp = n % 10;
	                dec += tmp*Math.pow(2, pow);
	                pow++;
	                n=n/10;
	            }
	        }
	        return dec;
	    }

	    private static Long getConvertedInteger(int n, int b){
	        //b = base
	    	Integer in = Integer.parseInt(String.valueOf(n), 10);
	    	System.out.println("without convert : " + in.toString());
	    	String binStr = Integer.toBinaryString(n);
	    	System.out.println("After conversion : " + binStr);
	    	Long binIn = Long.parseLong(binStr,10);
//	    	System.out.println("Int value : " + binIn);
	        Stack<Integer> stack = new Stack();
	        int r;
	        int q;
	        while(n != 0){
	            q = n/b;
	            r = n % b;
	            stack.push(r);
	            n = q;
	        }
	        int no ;
	        Long retNo =1L;
	        int po = 0;
	        StringBuilder builder = new StringBuilder();
	        while(!stack.isEmpty()){
	            
	            no = stack.pop();
	            builder.append(no);
//	            System.out.println(no);
	            retNo = retNo * 10 + no;
//	            retNo += no * Math.pow(10, po);
//	            retNo += (int) (retNo * Math.pow(10, po) + no);
	            po++;
	        }
	        System.out.println(builder.toString());
	       // System.out.println("Binary :" + retNo);
	         return retNo;  
//	         return Integer.parseInt(builder.toString(), 2);
//	    	return binIn;
	        
	    }

	    private static Long getInvertInteger(Long n){
	        //int no = ~n;
	        //return no;
//	    	System.out.println(n);
	        String strNo = String.valueOf(n);
	        strNo = strNo.replaceAll("0", "x");
	        strNo = strNo.replaceAll("1", "0");
	        strNo = strNo.replaceAll("x", "1");
//	        System.out.println(Integer.parseInt(strNo));
	        return Long.parseLong(strNo);
	    }

}
