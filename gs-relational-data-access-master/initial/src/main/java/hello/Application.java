package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    JdbcTemplate jdbc;
    
	@Override
	public void run(String... args) throws Exception {
		
		log.info("Create table");
		
		jdbc.execute("DROP table Customers if EXISTS");
		jdbc.execute("CREATE TABLE Customers(" + "id serial, first_name VARCHAR(50), last_name VARCHAR(50))");
		
		List<Object[]> name_split = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
				.stream().map(name -> name.split(" ")).collect(Collectors.toList());
		
		log.info("insert");
		name_split.forEach(name -> log.info(String.format("Insert as first name and last name %s %s", name[0], name[1])));
		
		
		jdbc.batchUpdate("INSERT INTO Customers(first_name, last_name) VALUES(?,?)",name_split);
		
		log.info("Select all");
		jdbc.query("SELECT * from Customers",
				(rs, row_num) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
				.forEach(customer -> log.info(customer.toString()));
		
		String f_name = jdbc.queryForObject("select first_name from Customers where last_name = 'Dean'", String.class);
	
		System.out.println("first name where last name = Dean: " + f_name);
	}
	
}
