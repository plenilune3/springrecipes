package com.apress.springrecipes;

import com.apress.springrecipes.sequence.SequenceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringrecipesApplicationTest {

    @Autowired
    SequenceGenerator generator;

    @Test
    void sequenceGeneratorTest() {
        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
    }
}