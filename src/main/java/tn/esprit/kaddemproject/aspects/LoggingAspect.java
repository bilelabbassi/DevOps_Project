package tn.esprit.kaddemproject.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

@Before("execution( * tn.esprit.kaddemproject.generic.IGenericServiceImp.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		
		String name = joinPoint.getSignature().getName();
		
		log.info("In method :" + name );
	}
	
	
	@After("execution(* tn.esprit.kaddemproject.services.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		
		String name = joinPoint.getSignature().getName();
		
		log.info("Out of method :" + name );
	}

}	