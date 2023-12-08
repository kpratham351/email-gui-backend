package com.pratham.email.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.email.model.EmailRequest;
import com.pratham.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	@Autowired
    EmailService emailService;
@RequestMapping("/welcome")
	public String welcome() {
		return "hello this is my email api";
	}

@PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
    	boolean result=this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getto());
    	if(result) {
    		return ResponseEntity.ok("Done");
    	}else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
    	}
	
    }
}


