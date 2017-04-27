package br.unifor.arquitetura.cdi.util;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@InterceptorBinding
public @interface Transactional {

}
