# springboot-activemq-application

Properties used for activemq configuration are,

```
spring.activemq.broker-url: tcp://localhost:61616
spring.activemq.user: admin
spring.activemq.password: secret
```

## @JmsListener
This annotation is used for listening queue,

```java
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {
	@JmsListener(destination = "test_queue")
	public void receiveTestObject(String testString) {
		System.out.println("Message received: " + testString);
	}
}
```

## JmsTemplate
The bean of JmsTemplate is already created by springboot. This bean is used for sending message to specific queue.

```java
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
```