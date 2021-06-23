package learnjava;

import java.util.Scanner;

public class ExceptionHandle {

	public static void main(String[] args) {
		
		int a =10,b=0,c;
		System.out.println("enter a");
		Scanner sc= new Scanner(System.in);
		a=sc.nextInt();
		System.out.println("enter b");
		b=sc.nextInt();
		sc.close();
		ExceptionHandle exObj=new ExceptionHandle();
		try {
			//exObj.divide(a,b);
			exObj.throwData();
			//System.out.println("result : "+a/b);
			System.out.println("END");
		}
		catch(CustomExceptionTest ex) {
			System.out.println(ex.getMessage());
		}
		catch(ArithmeticException ex) {
			System.out.println("enter value jndkjfkek");
		}
		finally {
			System.out.println("finally");
		}
	}
	private void divide(int a,int b) throws ArithmeticException{
		System.out.println("result : "+a/b);
		System.out.println("END");
	}
	private void throwData() throws CustomExceptionTest {
		throw new CustomExceptionTest("enter valid data");
	}

}
