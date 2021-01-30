 package alist;

public class ATest {
	public static void main(String[] args) {
		ArrayList l = new ArrayList(10);
		l.insert(0, 4);
		l.insert(1, "b");
		l.insert(2,"c");
		l.insert(4, 6);
		l.insert(3, 9);
		
		l.getSize();
		l.display();
		l.remove(2);
		l.display();
		System.out.println(l.get(3));
		System.out.println(l.find("b"));
	}
}
