import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


public class PrintValue {

	public static void main(String[] args) {
		String val = lookAndPrintOne("1211",2);
		System.out.println(val);
	}

//	111221 -- 312211

	private static String lookAndPrintOne(String input, int iter) {
		
		if (iter == 0) {
			return input;
		}
		
		Queue<String> queue = new LinkedBlockingDeque<String>();
		char[] chars = input.toCharArray();
		boolean match = false;
		char prevChar = chars[0];
		int count = 1;
		for(int i =1; i< chars.length; i++){
			char curChar = chars[i];
			if(curChar == prevChar){
				count++;
			}
			else{
				queue.add(String.valueOf(count));
				queue.add(String.valueOf(prevChar));
				prevChar = curChar;
				count = 1;
			}
		}
		queue.add(String.valueOf(count));
		queue.add(String.valueOf(prevChar));
		StringBuilder builder = new StringBuilder();
		while(!queue.isEmpty()){
			builder.append(queue.poll());
		}
		
		return lookAndPrintOne(builder.toString(), --iter);
	}

}
