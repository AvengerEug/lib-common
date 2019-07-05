package com.eugene.common.annotation;

import com.eugene.common.filter.configration.RegisterFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 在需要启动所有自定义的过滤器注解
 */
@Target(value = { ElementType.TYPE }) // 表明该注解使用在什么地方, ElementType.TYPE  => 类或接口中, 具体可看枚举ElementType
@Retention(RetentionPolicy.RUNTIME) // 表示在运行时保留
/**
 * 1.SOURCE:在源文件中有效（即源文件保留）
   2.CLASS:在class文件中有效（即class保留）
   3.RUNTIME:在运行时有效（即运行时保留）
 */
@Documented //生成文档时起作用
@Import(value = { // @import 作用: 通过@import的方式将RegisterFilter类中使用IOC创建出来的对象 注入到IOC容器中
        RegisterFilter.class
})
public @interface EnableFilters {
}
