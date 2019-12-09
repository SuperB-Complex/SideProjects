package jjm.learn.book.sale;

import jjm.learn.book.sale.POJO.OwnerInformationPOJO;
import jjm.learn.book.sale.mapper.OwnerInformationPOJOMapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"jjm.learn.book.sale"})
@RestController
@MapperScan("jjm.learn.book.sale.mapper")
public class App {
	
	@Autowired
	private OwnerInformationPOJOMapper ownerInformationPOJOMapper;
	
	@RequestMapping("/")
	public String show() {
		OwnerInformationPOJO ownerInformationPOJO = ownerInformationPOJOMapper.selectByPrimaryKey(1);
		
		if (ownerInformationPOJO == null) {
			return "Sorry there no such one owner!";
		}
		return "SHOWING OFF!";
	}
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
