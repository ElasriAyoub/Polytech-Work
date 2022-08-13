package exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class CExec {

	static void fonction1()
	{		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(input);
		String line;
		String stroui="oui";
		try 
		{
			do
			{
			System.out.println("Voulez-vous quitter cette boucle ? (Oui/Non)");
		    line = br.readLine();		  		
			}while(line!=stroui);		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	static void fonction2()
	{
		Integer[] tab = new Integer[5];
		Random r = new Random();		
		for(int i=0;i<10;i++)
		{
			int idx=r.nextInt(5);
			tab[idx]=r.nextInt(20);
		}
		int somme=0;
		for(Integer val:tab)
		{
			somme+=val;
		}
		System.out.printf("somme=%d \n",somme);		
	}
	static void fonction3()
	{
		int[][]tab= {{4,6,4,5,8,47,82},{4,7,12,8,51,11},{7,12,8,9,5,24,73}};
		
		for(int i=0;i++<3;)
		{
			for(int j=0;j++<6;)
			{
				tab[i-1][j]=tab[i-1][j]%3;
			}
		}
		System.out.println(Arrays.deepToString(tab));
	}
	
	public static void main(String[] args) 
	{
		
		fonction1();
		System.out.println("bye!");		
	}

}
