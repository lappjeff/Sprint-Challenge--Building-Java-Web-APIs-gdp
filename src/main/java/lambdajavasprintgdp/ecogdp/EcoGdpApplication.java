package lambdajavasprintgdp.ecogdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class EcoGdpApplication
{
	public static GDPList ourGDPList;

	public static void main(String[] args)
	{
		ourGDPList = new GDPList();

		ApplicationContext ctx = SpringApplication.run(EcoGdpApplication.class, args);

		DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}

}
