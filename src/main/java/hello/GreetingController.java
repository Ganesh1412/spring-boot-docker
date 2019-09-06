package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class GreetingController {

    private static final String template = "Hi there! I'm being served from, %s!";
    private final AtomicLong counter = new AtomicLong();
    InetAddress ip;
    String hostname;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	try {
		ip = InetAddress.getLocalHost();
		hostname = ip.getHostName();
        	return new Greeting(counter.incrementAndGet(),
                            String.format(template,hostname));
    }
	catch(UnknownHostException e){
		e.printStackTrace();
		return new Greeting(0,String.format(template,"UnknownHost"));
	}
	
	}
}
