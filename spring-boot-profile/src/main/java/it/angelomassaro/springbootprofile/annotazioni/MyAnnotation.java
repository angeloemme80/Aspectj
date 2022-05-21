package it.angelomassaro.springbootprofile.annotazioni;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "VALORE DI DEFAULT";
    String operazione();
}
