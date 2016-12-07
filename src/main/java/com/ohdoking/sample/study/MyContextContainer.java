package com.ohdoking.sample.study;

import java.lang.reflect.Field;

import com.ohdoking.sample.study.InjectData.Quality;

/*
 * 도움 
 */
public class MyContextContainer {
	

    public MyContextContainer(){
    }
    
    /**
     * 매개변수로 받은 클래스의 객체를 반환합니다.
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <A> A get(Class<A> clazz) throws IllegalAccessException, InstantiationException {
        A instance = clazz.newInstance();
        System.out.println(instance.getClass().getName());
        instance = invokeAnnonations(instance);
        return instance;
    }

    /**
     * 객체를 반환하기 전 어노테이션을 적용합니다.
     * @param instance
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    private <T> T invokeAnnonations(T instance) throws IllegalAccessException {
        Field [] fields = instance.getClass().getDeclaredFields();
        for( Field field : fields ){
        	InjectData annotation = field.getAnnotation(InjectData.class);
            if( annotation != null){
            	if(field.getType() == String.class){
            		field.setAccessible(true);
            		field.set(instance, annotation.secondText());
            	}
            	else if(field.getType() == Integer.class){
            		field.setAccessible(true);
            		field.set(instance, annotation.number());
            	}
            	else if(field.getType() == Quality.class){
            		field.setAccessible(true);
            		field.set(instance, annotation.quality());
            	}
            }
        }
        return instance;
    }

    
}