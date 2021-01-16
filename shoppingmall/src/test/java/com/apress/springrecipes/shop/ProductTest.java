package com.apress.springrecipes.shop;

import com.apress.springrecipes.shop.config.ShopConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

    @Test
    public void productTest() {
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        System.out.println(aaa);
        System.out.println(cdrw);
        System.out.println(dvdrw);
    }
}