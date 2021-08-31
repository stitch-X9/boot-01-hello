package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/*
* 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
* 2、配置类本身也是组件
* 3、proxyBeanMethods:代理bean的方法(proxyBeanMethods = true默认为true，和springboot1的区别)
* 4、@Import({User.class,DBHelper.class})
*   给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
* */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类 == 配置文件
@ConditionalOnBean(name = "tom")  //这个类下，要有tom组件才会成功生成组件，不然都不成功，放在方法上则是某个方法需要有tom组件才会本组件生成成功
//@ImportResource("clsspath:beans.xml") 这个是表明如果不配置这个注解，那么原本那些xml配置文件是不认得的，只有注解了这个，才会认得
//@EnableConfigurationProperties(Car.class)使用了这个注解后，就是把Car类加入到配置类来自动注册到容器中，就不用在那个类头上声明Component组件了
public class MyConfig {

    @Bean   //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        return new User("张三",18);
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
