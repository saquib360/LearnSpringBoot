package learnjava;

public class ConstructorChaining {
	
	public ConstructorChaining() {
		this(1);
		System.out.println("default constructor");
	}
	public ConstructorChaining(int i) {
		this("saq");
		System.out.println("i : "+i);
	}
	public ConstructorChaining(String abc) {
		System.out.println("abc : "+abc);
	}

	public static void main(String[] args) {
		ConstructorChaining obj=new ConstructorChaining();
	}

}
