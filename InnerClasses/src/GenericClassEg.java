import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GenericClassEg {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		List<B> bList = new ArrayList<B>();
		bList.add(b);
		List<A> aList = new ArrayList<A>();
		
		Iterator<A> it = aList.iterator();
		aList.add(b);
		test(aList);
//		test(bList);
	}
	
	public static void test(List<A> list){
		System.out.println("called");
	}
}

class A{
	
}
class B extends A{
	
}
