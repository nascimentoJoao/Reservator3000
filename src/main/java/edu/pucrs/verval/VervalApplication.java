package edu.pucrs.verval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pucrs.verval.data.CollaboratorGen;
import edu.pucrs.verval.data.ResourceGen;

@SpringBootApplication
public class VervalApplication {
	
	public static void main(String[] args) {		
		SpringApplication.run(VervalApplication.class, args);
	}

}
