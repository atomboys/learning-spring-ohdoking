package com.ohdoking.sample.study;

import com.ohdoking.sample.study.InjectData.Quality;

public class TestClass {
	
	@InjectData(secondText = "init2")
	String name;
	
	@InjectData(secondText = "init")
	Integer num;

	@InjectData(secondText = "test2", quality = Quality.BAD)
	Quality quality; 
	
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    	
    	// ���ؽ�Ʈ �����̳ʸ� �ʱ�ȭ �մϴ�.
        MyContextContainer demo = new MyContextContainer();

        // MyOjbect ��ü�� �ϳ� �޾ƿɴϴ�.
        TestClass obj = demo.get(TestClass.class);

        System.out.println(obj.name);
        System.out.println(obj.num); 
        System.out.println(obj.quality);
        
    }
 
/*
 * 	annotation üüũ�ϴ� �޼��� 
 */
 
//    public void checkAnnotations(Class useClass){
//        Method[] methods = useClass.getDeclaredMethods();
//        for ( Method tempMethod:methods ){
//        	InjectData annotation = tempMethod.getAnnotation(InjectData.class);
//            if ( annotation != null ){
//                int number = annotation.number();
//                String text = annotation.text();
//                System.out.println(tempMethod.getName() + "() : number=" + number + " text=" + text);
//            } else {
//                System.out.println(tempMethod.getName() + "() : annotation is null");
//            }
//        }
//    }
}