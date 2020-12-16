package bstorm.akim.correctionExo3.disabled.executions;

import bstorm.akim.correctionExo3.business.dto.SectionDTO;
import bstorm.akim.correctionExo3.business.service.SectionService;
import bstorm.akim.correctionExo3.exception.ElementNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestSectionService {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(TestSectionService.class, args);
		SectionService ss = ctx.getBean(SectionService.class);

		SectionDTO dto = new SectionDTO(
				5505,
				"fake section modified",
				1111,
				null
		);

		// test create - V

//		ss.create(dto);

		// test readOne - V

//		try{
//			System.out.println( ss.readOne(5555) );
//		}
//		catch (ElementNotFoundException e){
//			System.out.println(e.getMessage());
//		}


		// test readAll - V

//		ss.readAll().forEach(System.out::println);

		// test update - V

//		try{
//			ss.update( dto );
//		}
//		catch (ElementNotFoundException e){
//			System.out.println( e.getMessage() );
//		}

		// test delete -

		try{
			ss.delete(5555);
		}
		catch (ElementNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
