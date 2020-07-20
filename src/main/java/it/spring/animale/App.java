package it.spring.animale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.spring.animale.model.Automobile;
import it.spring.animale.model.Automobilista;
import it.spring.animale.service.animaleService;
import it.spring.animale.service.AutomobileService;
/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableJpaRepositories
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan
public class App extends SpringBootServletInitializer
{
	private static animaleService serviceAnimale;
	
	 @Autowired
	    public void setMapper(animaleService serviceA)
	 {
	    App.serviceAnimale = serviceA;
	 }
	
//	private static AutomobileService service;
//	
//	 @Autowired
//	    public void setMapper(AutomobileService automobileService)
//	 {
//	    App.service = automobileService;
//	 }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
	
    public static void main( String[] args ) throws Exception
    {
    	SpringApplication.run(App.class, args);

//    	Automobilista automobilista = service.findAutomobilistaById(new Long (5));
//    	System.out.println(automobilista);
    	
//    	Automobile automobile = new Automobile("FJ012SA", "Topolino", "Fiat", 1960);
//		service.aggiungiAutomobile(automobile);
    	
//		Automobile auto = service.findAutomobileById("FJ012SA");
//		System.out.println(auto);
    	
//    	service.cercaPerMarca("Mazda");
    	
//    	service.listaAutoAutomobilista(new Long(503));
    	
//    	service.rimuoviDatiAutomobilista(new Long(5));
    	
//   	service.cambioProprieta("FJ012SA", new Long(100));
    	
//    	service.targheAutomobilista(new Long(100));
    	
//    	service.autoAnno("Mazda", 1995);
    	
    	System.out.println("Fine esecuzione");
    }
}