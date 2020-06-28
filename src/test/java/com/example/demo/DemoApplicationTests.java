package com.example.demo;

import com.example.demo.entity.Persion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	Persion persion;

	@Test
	void contextLoads() {
		System.out.println(persion);
	}

}
