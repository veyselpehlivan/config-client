package com.veyselpehlivan.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Autowired
	public void setEnv(Environment e)
	{
		System.out.println(e.getProperty("msg"));
	}

}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${msg:Config Server is not working. Please check...}")
	private String msg;

	@GetMapping("/msg")
	public String getMsg() {
		return this.msg;
	}
}
