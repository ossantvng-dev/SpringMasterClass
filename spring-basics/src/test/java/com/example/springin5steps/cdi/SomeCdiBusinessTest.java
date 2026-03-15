package com.example.springin5steps.cdi;

import com.example.SpringCDIApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringCDIApplication.class)
public class SomeCdiBusinessTest {

    @Autowired
    SomeCdiBusiness someCdiBusiness;

    @Test
    void findGreatestTest() {
        assertEquals(100, someCdiBusiness.findGreatest());
    }
}
