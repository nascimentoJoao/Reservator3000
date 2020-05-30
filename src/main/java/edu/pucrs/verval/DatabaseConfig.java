package edu.pucrs.verval;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

//@Configuration
public class DatabaseConfig {
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String user;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	  public DataSource dataSource() {
	      HikariConfig config = new HikariConfig();
	      config.setJdbcUrl(dbUrl);
	      config.setUsername(user);
	      config.setPassword(password);
	      return new HikariDataSource(config);
	  }
}
