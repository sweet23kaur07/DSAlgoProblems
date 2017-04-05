import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class TreeSetExample {
 public static void main(String[] args) {
//	Set<Student> set = new TreeSet<Student>();
	Set<Student> set = new HashSet<Student>();
	set.add(new Student(1));
	set.add(new Student(1));
	set.add(new Student(2));
	
	for(Student s : set){
		System.out.println(s.id);
	}
}
}

class Student implements Comparable<Student>{
	
	int id ;

	public Student(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Student o) {
		if(this.id == o.id){
			return 0;
		}
		if(this.id > o.id){
			return 1;
		}
		return -1;
	}
	
	
}
