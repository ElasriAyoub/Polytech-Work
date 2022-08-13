package config;

import org.springframework.context.annotation.Bean;

import coucheDao.Dao4;
import coucheDao.IDao;
import coucheMetier.IMetier;
import coucheMetier.Metier1;

public class ConfigJfx {
	
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