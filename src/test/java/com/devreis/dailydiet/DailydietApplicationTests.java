package com.devreis.dailydiet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.devreis.dailydiet.util.Calculator;

@SpringBootTest
class DailydietApplicationTests {
    private final Calculator calculator = new Calculator();

	@Test
	 void addition() {
        assertEquals(2, calculator.add(1, 2));
    }

}
