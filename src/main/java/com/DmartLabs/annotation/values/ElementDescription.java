package com.DmartLabs.annotation.values;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Qualitrix on DD/MM/YYY.
 * @author Sandhya
 */

@Target(ElementType.FIELD) @Retention(RetentionPolicy.RUNTIME)
public @interface ElementDescription {
    String value() default "";
}
