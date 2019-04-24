package com;

import com.test.model.user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.test.dao")
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}

	@ResponseBody
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public void test(){
		System.out.println("dddddddddd=================");
	}
}
