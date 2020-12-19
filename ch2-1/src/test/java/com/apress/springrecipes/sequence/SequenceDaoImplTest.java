package com.apress.springrecipes.sequence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { SequenceDaoImpl.class })
class SequenceDaoImplTest {

    @Autowired
    SequenceDao sequenceDao;

    @Test
    void sequenceDaoTest() {
        assertThat(sequenceDao.getNextValue("IT"), is(10000));
        assertThat(sequenceDao.getNextValue("IT"), is(10001));
    }
}