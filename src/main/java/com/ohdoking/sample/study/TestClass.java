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
    	
    	// 컨텍스트 컨테이너를 초기화 합니다.
        MyContextContainer demo = new MyContextContainer();

        // MyOjbect 객체를 하나 받아옵니다.
        TestClass obj = demo.get(TestClass.class);

        System.out.println(obj.name);
        System.out.println(obj.num); 
        System.out.println(obj.quality);
        
    }
 
/*
 * 	annotation 체체크하는 메서드 
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