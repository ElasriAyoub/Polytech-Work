package pta.sagi.concours.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import pta.sagi.concours.entites.Candidat;

public class DaoConcoursJSON implements IDaoConcours 
{

	private String fName;
	
	public DaoConcoursJSON(String fileName)
	{
		fName=fileName;
	}
	
	public Candidat[] getCandidats(int region) {		
		try{
		File file = new File(fName);				
		ObjectMapper om = new ObjectMapper();
		Candidat[] lesCandidats = om.readValue(file,Candidat[].class);					
		Stream<Candidat> sc=Stream.of(lesCandidats);
		sc=sc.filter(c->c.getRegion()==region);
		List<Candidat> lc=sc.collect(Collectors.toList());
		return lc.toArray(new Candidat[0]);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}	

	public Candidat[] getCandidatsIn(double scoreMin, double scoreMax) {
		
		try{
		File file = new File(fName);				
		ObjectMapper om = new ObjectMapper();
		Candidat[] lesCandidats = om.readValue(file,Candidat[].class);					
		Stream<Candidat> sc=Stream.of(lesCandidats);
		sc=sc.filter(c->c.getScore()>=scoreMin);
		sc=sc.filter(c->c.getScore()<=scoreMax);		
		List<Candidat> lc=sc.collect(Collectors.toList());
		return lc.toArray(new Candidat[0]);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}	
		
	}

	public void add(Candidat c) {		
		try{
		File file = new File(fName);				
		ObjectMapper om = new ObjectMapper();
		Candidat[] lesCandidats = om.readValue(file,Candidat[].class);					
		ArrayList<Candidat> alC=new ArrayList<Candidat>(Arrays.asList(lesCandidats));
		alC.add(c);
		om.writeValue(file, alC);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delCandidat(int numero) {
		try{
			File file = new File(fName);				
			ObjectMapper om = new ObjectMapper();
			Candidat[] lesCandidats = om.readValue(file,Candidat[].class);					
			ArrayList<Candidat> alC=new ArrayList<Candidat>(Arrays.asList(lesCandidats));
			alC.removeIf(c->c.getNumero()==numero);
			om.writeValue(file, alC);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
