package com.example.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ConfigurationProperties：告诉springboot将本类中所有属性和配置文件中相关的配置进行绑定；
 * prefix = "persion":告诉配置文件persion下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能用容器提供的@ConfigurationProperties功能,所以添加@Component注解
 */
@Data
@Component
@ConfigurationProperties(prefix = "persion")
public class Persion {

    private String lastName;

    private Integer age;

    private Boolean boss;

    private Date brith;
}
