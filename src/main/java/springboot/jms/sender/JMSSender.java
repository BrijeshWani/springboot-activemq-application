package springboot.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String testString) {
		jmsTemplate.convertAndSend("test_queue", testString);
	}
}
