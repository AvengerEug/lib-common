package com.eugene.common.annotation;

import com.eugene.common.web.mvc.MVCConfiguration;
import com.eugene.common.web.security.CorsConfigration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {
        CorsConfigration.class,
        MVCConfiguration.class
})
public @interface EnableCors {
}
