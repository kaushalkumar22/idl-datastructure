package a_util;

public class OuterClass {
	public static void main(String[] args) {
       new OuterClass().new InnerClass().innerClassMethod();
       new StaticNestedClass().staticNestedClassMethod();
	}
	public int field1=10;
	private  static int field2 =20;
	private static int field3=30;

	class InnerClass {
		public void innerClassMethod() {
			System.out.println("Non-Static"+field2);
			System.out.println("Non-Static"+field3);
		}
	}
	static class StaticNestedClass {
		public void staticNestedClassMethod() {
			try {
				System.out.println("Non-Static"+field3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Non-Static"+field3);
		}
	}
}
