package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.jms.sender.JMSSender;

@RestController
@RequestMapping("/sender")
public class TestController {

	@Autowired
	private JMSSender jMSSender;

	@GetMapping("/send-sample-message")
	public @ResponseBody ResponseEntity<Boolean> test() {
		jMSSender.send("Brijesh Wani");
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
}
