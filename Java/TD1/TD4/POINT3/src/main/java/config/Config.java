package config;

import coucheMetier.*;
import coucheDao.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration		//Annotation Spring
public class Config {	
	
	@Bean IDao dao()
	{
		return new Dao4();
	}
	
	@Bean IMetier metier(IDao dao)
	{
		//IMetier m=new Metier2();
		//m.setDao(dao);
		return new Metier1();
	}
}