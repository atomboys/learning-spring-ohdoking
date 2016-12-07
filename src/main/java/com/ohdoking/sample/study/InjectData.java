package com.ohdoking.sample.study;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectData {
	
	public enum Quality {BAD, GOOD, VERYGOOD}

	int number() default 3;
    String text() default "This is first annotation";
    String secondText();
    
    Quality quality() default Quality.GOOD; 
    
}