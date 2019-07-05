package com.eugene.common.annotation;

import com.eugene.common.peroperty.JwtProperty;
import com.eugene.common.web.security.WebSecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import({
        JwtProperty.class,
        WebSecurityConfig.class
})
public @interface EnablePropertyClass {
}
