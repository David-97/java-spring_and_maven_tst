package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class App implements	CommandLineRunner
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
    }
    	@Override
    	public void run(String... args) throws Exception {
    		
    	
        System.out.println( "Hello World!" );
        
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//handling timezone error
		dmds.setUrl("jdbc:mysql://localhost:3306/Orders?useLegacyDatetimeCode=false&serverTimezone=America/New_York");
		dmds.setUsername("root");
		dmds.setPassword("");
		JdbcTemplate jdbclocal = new JdbcTemplate(dmds);
		
		//insert
		//jdbclocal.update("insert into Orders(Id_customer, Id_item, Sum) values(?,?,?)", 15, 1, 50398);
		
		List<Map<String, Object>> allRecords = jdbclocal.queryForList("select * from Orders");
		
		String name = jdbclocal.queryForObject("select id from Orders where Id_customer = 9", String.class);
		
		
		System.out.println("select all: " + allRecords);
		
		System.out.println("\n select id of order where id_cus = 9: " + name);
		
    	}
    
}
