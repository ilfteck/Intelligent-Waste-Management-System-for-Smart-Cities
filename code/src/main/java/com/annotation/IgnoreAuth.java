package com.annotation;

import java.lang.annotation.*;

/**
 * Ignore Token authentication
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
