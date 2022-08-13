package pta.sagi.concours.entites;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserCandidat 
{
	public static Candidat parse(String str)
	{
		Pattern pattG;
		pattG = Pattern.compile("^\\[([A-Z][a-z]+ [A-Z][a-z]+);(\\d{6});(\\d*\\.{0,1}\\d+);(\\d{1})\\]$");
		// pattern ^\[([A-Z][a-z]+ [A-Z][a-z]+);(\d{6});(\d*\.{0,1}\d+);(\d{1})\]$
		Matcher matcher;
		
		try{
			matcher = pattG.matcher(str);
			if(matcher.matches())
			{
				String nom = matcher.group(1);
				int numero = Integer.parseInt(matcher.group(2));
				double score = Double.parseDouble(matcher.group(3));
				int region = Integer.parseInt(matcher.group(4));
				return new Candidat(nom,numero,score,region);
			}	
			else
			{
				System.out.println("Problème de syntaxe : [Prenom Nom;num(6);score;region(1)]");
				return null;
			}
		}					
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
