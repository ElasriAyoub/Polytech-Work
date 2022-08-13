package sport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sport.dao.DaoSportMySQL;
import sport.dao.IDaoSport;
import sport.metier.IMetierSport;
import sport.metier.MetierMunozTeresa;

@Configuration
public class ConfigSport
{	
	
	@Bean
	public IDaoSport dao(){ return new DaoSportMySQL();}
	
	@Bean
	public IMetierSport metier(){return new MetierMunozTeresa();}
	
	
}
