package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@Configuration 
@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class Application {
	
    public AtomicLong counter = new AtomicLong();
    private static final String template = "No. of Ducks:- ";

    @RequestMapping("/DELETE/duck")
    public String home1() {
	if (counter.get()!=0){
		return template + counter.decrementAndGet(); 
	}
	else{
		return template + counter.get();
	}
    }

    @RequestMapping("/GET/duck")
    public String home2() {
	return template + counter.get();
    }

    @RequestMapping("/PUT/duck")
    public String home3() {
	return template + counter.incrementAndGet();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
