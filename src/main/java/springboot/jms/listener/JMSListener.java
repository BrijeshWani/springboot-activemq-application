package springboot.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {
	@JmsListener(destination = "test_queue")
	public void receiveTestObject(String testString) {
		System.out.println("Message received: " + testString);
	}
}
