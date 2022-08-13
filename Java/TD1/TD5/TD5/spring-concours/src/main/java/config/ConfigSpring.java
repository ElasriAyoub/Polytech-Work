package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pta.sagi.concours.dao.DaoConcoursMySQL;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.metier.IMetierConcours;
import pta.sagi.concours.metier.MetierConcours;
import pta.sagi.concours.ui.IUserInterfaceConcours;
import pta.sagi.concours.ui.UIConsole;


@Configuration			

public class ConfigSpring {
		@Bean IDaoConcours dao(){return new DaoConcoursMySQL();} 
		@Bean IMetierConcours metier(){return new MetierConcours();}
		//@Bean IUserInterfaceConcours ui(){return new UIConsole();}
		}
