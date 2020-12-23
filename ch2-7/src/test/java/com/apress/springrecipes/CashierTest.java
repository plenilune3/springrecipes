package com.apress.springrecipes;

import com.apress.springrecipes.config.ShopConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

    @Test
    void checkout() {
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("alert.inventory.checkout",
                                                    new Object[] {"[DVD-RW 3.0]", new Date()},
                                                    Locale.US);

        System.out.println("The I18N message for alert.checkout is: " + alert);
        System.out.println("The I18N message for alert.inventory is: " + alert_inventory);
    }
}