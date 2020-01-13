package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
		System.out.println("start :\n\r"+System.getProperties());
		System.out.println("args:\n\r"+ Arrays.toString(args));
        SpringApplication.run(XxlJobExecutorApplication.class, args);
	}

}