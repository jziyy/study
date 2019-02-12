package com.example.demo;

import com.example.demo.annotation.bean.UserBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class DemoApplicationTests {

    @Autowired
    @Qualifier("userbean1")
    UserBean bean;

    @Autowired
    @Qualifier("userbean2")
    UserBean bean2;

    @Autowired
    @Qualifier("userbean1")
    UserBean bean1;

    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void test(){
        System.out.println("aaaa");
        //lambok @Bean注解提供了重写equals功能
        System.out.println("--------equals");
        System.out.println(bean);
        System.out.println(bean1.equals(bean));
        //hashcode
        System.out.println("--------hashcode");
        System.out.println(bean1.hashCode());
        System.out.println(bean);
        System.out.println(bean.hashCode());
        System.out.println(bean2);
        System.out.println(bean2.hashCode());


    }

}

