import java.util.HashMap;

// May 4, 2015
// Page 72

public class BuildHashMap {
	public HashMap<Integer, Student> buildMap(Student[] students) {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		for (Student s: students) map.put(s.getId(),s);
		return map;
	}
}

class Student {
	int id;
	String name;
	public Student(int i, String s) {
		this.id = i;
		this.name = s;
	}
	public void setId(int i){
		id = i;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String s) {
		name = s;
	}
	public String getName() {
		return name;
	}
	
}
