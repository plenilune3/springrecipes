package com.apress.springrecipes.sequence;

import com.apress.springrecipes.sequence.config.SequenceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class SequenceGeneratorTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(SequenceConfiguration.class);

    @Test
    void getSequence() {
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}