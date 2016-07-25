package org.hwl.annotation;

public class Test {
	public static void main(String[] args) {
		Class<TestAnnotation> test=TestAnnotation.class;
		if(test.isAnnotationPresent(UserAnnotation.class)){
			System.out.println("xxxxxxxxxxxxxxx");
			UserAnnotation annotation=test.getAnnotation(UserAnnotation.class);
			if(annotation!=null){
				System.out.println("value:"+annotation.value());
			}else{
				System.out.println("this is not Annotions class");
			}
		}
	}
} 
