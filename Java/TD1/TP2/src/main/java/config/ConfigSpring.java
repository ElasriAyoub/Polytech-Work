package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pta.sagi.sport.dao.DaoSportMySQL;
import pta.sagi.sport.dao.IDaoSport;
import sport.metier.IMetierSport;
import sport.metier.MetierNomPrenom;
import sport.ui.IUISport;
import sport.ui.UISport;


@Configuration
public class ConfigSpring {

	@Bean IDaoSport dao()
	{
		return new DaoSportMySQL();
	}
	
	@Bean IMetierSport metier()
	{
		return new MetierNomPrenom();
	}
	/*
	@Bean IUISport uisport()
	{
		return new UISport();
	}*/
}
