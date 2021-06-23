package oops;

public class OopsBasic extends InheritanceExample implements TestInterface {

	public static void main(String[] args) {
		int a=10, b=10;
	}

	@Override
	public int parameter(int a, int b) {
		return 2*(a+b);
	}
}
