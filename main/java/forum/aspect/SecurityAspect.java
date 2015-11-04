/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.aspect;

import forum.service.SecurityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ETY
 */

@Aspect
@Component
public class SecurityAspect{
    
    @Autowired
    SecurityService serviceSecurite;
    
    @Before("execution(* forum.service.*.*(..)) && !execution(* forum.service.SecurityService.*(..))")
    public void avant(JoinPoint jp){
  
        //Exception si la methode commance par "admin"
        if (!serviceSecurite.verifierAcces("admin",(jp.toShortString()).substring(jp.toShortString().indexOf(".")+1))){
            System.out.println((jp.toShortString()).substring(jp.toShortString().indexOf(".")+1));
            throw new SecurityException("Throw exception by SecurityAccess"); 
        }
    }
}

