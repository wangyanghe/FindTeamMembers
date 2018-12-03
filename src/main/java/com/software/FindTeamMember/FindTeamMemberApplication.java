package com.software.FindTeamMember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.software.FindTeamMember.filter"})
public class FindTeamMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindTeamMemberApplication.class, args);
	}
}
