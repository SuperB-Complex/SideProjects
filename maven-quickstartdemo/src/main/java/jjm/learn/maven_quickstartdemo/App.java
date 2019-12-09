package jjm.learn.maven_quickstartdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ) {
        System.out.println( "This is supposed to be seen if you successfully build a web application with Spring boot" );
        SpringApplication.run(App.class, args);
    }
}
