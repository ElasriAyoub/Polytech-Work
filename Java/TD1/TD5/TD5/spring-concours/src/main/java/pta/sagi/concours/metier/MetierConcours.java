package pta.sagi.concours.metier;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import pta.sagi.concours.dao.DaoConcoursMySQL;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;

public class MetierConcours implements IMetierConcours {
	
	@Autowired
	private IDaoConcours dao;
	private int topSize;
	public MetierConcours()
	{
		setTopSize(5);
	}

	public Candidat[] getCandidats(int ... regions)
	{
		ArrayList<Candidat> alc = new ArrayList<Candidat>();
		for(int r:regions)
		{
			for(Candidat c:dao.getCandidats((r))) alc.add(c);
		}
		alc.sort((c1,c2)->Double.compare(c2.getScore(), c1.getScore()));
		return alc.toArray(new Candidat[alc.size()]);
	}
	
	public Candidat[] getTop(int region)
	{
		Candidat[] cands=getCandidats(region);
		int s=Math.min(topSize,cands.length);
		Candidat[] top=new Candidat[s];
		for(int i=0;i<s;i++){ top[i]=cands[i];}
		return top;
	}
	
	public void add(Candidat c)
	{
		dao.add(c);
	}
	public void setTopSize(int size)
	{
		topSize=size;
	}
	public int getTopSize()
	{
		return topSize;
	}
}
