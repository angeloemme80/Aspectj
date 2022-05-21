package it.angelomassaro.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import it.angelomassaro.springbootprofile.annotazioni.MyAnnotation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class MioAspetto {

	/*
	 * Applicato a tutti i metodi pubblici
	 * delle classi contenute nei package della gerarchia it
	 */	
	@Around("execution(public * it..*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		
		//LEGGO LE ANNOTAZIONI
		MethodSignature signature = (MethodSignature) pjp.getSignature();
	    Method method = signature.getMethod();
		MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
		System.out.println("ANNOTAZIONE LETTA: myAnnotation.value(): " + myAnnotation.value() + " - myAnnotation.operazione(): " + myAnnotation.operazione());
		
		// Log prima dell'invocazione del metodo
		System.out.println("[" + new Date() + "]nt"
				+  pjp.getTarget().getClass() + "."  +  pjp.getSignature().getName()
				+  " ntArgomenti: "+ Arrays.toString(pjp.getArgs()));
		Object result = null;
		try
		{
			// Invocazione metodo
			result = pjp.proceed();
		}
		catch (Exception ex)
		{
			System.err.println("tErrore: " + pjp.getSignature().getName());
		}
		//Operazioni dopo l'esecuzione
		System.out.println("tRisultato: "+ result);
		return result;
	}
	
	
	
}
