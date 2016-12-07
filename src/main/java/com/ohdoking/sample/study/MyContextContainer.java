package com.ohdoking.sample.study;

import java.lang.reflect.Field;

import com.ohdoking.sample.study.InjectData.Quality;

/*
 * ���� 
 */
public class MyContextContainer {
	

    public MyContextContainer(){
    }
    
    /**
     * �Ű������� ���� Ŭ������ ��ü�� ��ȯ�մϴ�.
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
     * ��ü�� ��ȯ�ϱ� �� ������̼��� �����մϴ�.
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