package com.atguigu.boot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*@SpringBootApplication：这是一个springbot应用*/
/*@SpringBootApplication(scanBasePackages = "com.atguigu")   这个scanBasePackages属性能扩大扫描组件的位置，就可扫描到这个包下的所有组件的，不单单com.atguigu.boot下*/
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
    }
}
