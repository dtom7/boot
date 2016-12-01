package com.example.boot.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.boot.domain.Product;

@Component
@Aspect
public class LoggingAspect {

	private static Log logger = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.example.boot.service.*.*(..))", throwing = "exception")
	public void myAfterThrowing(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String stuff = signature.toString();
		String arguments = Arrays.toString(joinPoint.getArgs());
		Product product = null;
		for(Object o:joinPoint.getArgs()) {
			if(o instanceof Product) {
				product = (Product)o;
			}
		}
		
		logger.info("Product: " + product);
		
		logger.info("Write something in the log... We have caught exception in method: " + methodName
				+ " with arguments " + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
				+ exception.getMessage());
	}

}
