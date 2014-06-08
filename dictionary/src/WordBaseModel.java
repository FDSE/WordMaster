import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;




public class WordBaseModel {
	LinkedList<WordModel> wordlist=new LinkedList<WordModel>();
	int sumnum=0;
	int recitednum=0;
	int unrecitednum=0;
	int wrongnum=0;
	int rightnum=0;
	int currentwordindex=0;
	WordBaseModel(String letter) throws IOException
	{
		if (findRecordText(letter))
		{
			inputFromRecord(letter);
		}
		else
		{
			inputFromDictionary();
		}
		
	}
	public boolean findRecordText(String letter)
	{
		String[] recordname;
		File f = new File("src/record/");
		recordname = f.list();
		int i;
		for (i=0;i<recordname.length;i++)
		{
			if (recordname[i].equals("record-"+letter+".txt"))
			{
				return true;
			}
		}
		return false;
	}
	public void inputFromRecord(String letter) throws IOException
	{
		String fileName;
		fileName ="src/record/record-"+letter+ ".txt";
		FileReader in = new FileReader(fileName);
		BufferedReader buf = new BufferedReader(in);
		String temp;
		temp=buf.readLine();
		sumnum=Integer.parseInt(temp);
		temp=buf.readLine();
		recitednum=Integer.parseInt(temp);
		temp=buf.readLine();
		unrecitednum=Integer.parseInt(temp);
		temp=buf.readLine();
		wrongnum=Integer.parseInt(temp);
		temp=buf.readLine();
		rightnum=Integer.parseInt(temp);
		temp=buf.readLine();
		currentwordindex=Integer.parseInt(temp);
		while((temp=buf.readLine())!=null)
		{
			readWord(temp);
		}
		in.close();
	}
	public void inputFromDictionary() throws IOException
	{
		String fileName;
		fileName =ReadDat.filePath + ReadDat.fileName + ".txt";
		FileReader in = new FileReader(fileName);
		BufferedReader buf = new BufferedReader(in);
		String temp;
		while((temp=buf.readLine())!=null)
		{
			readWord(temp);
			sumnum++;
		}
		in.close();
	}
	public void readWord(String temp)
	{
		char []c = new char[100] ;
		   
		   int len = temp.length();
		   temp.getChars(0,len,c,0);
		   String english ="";
		   String chinese ="";
		   String ifcorrect="0";

	        int flag =0;
	        
		    for(int i = 0;i < len;i++)
		    {
		    	
		    	    
		    	if(c[i] ==' ')
		    	{
		    		flag=1;
		    	}
		    	if( c[i]!='#'&&c[i] != ' '&&flag == 0)
		    		
		              
		             {
		                 
		                   english = english + c[i];
		             }
		             if( c[i] != ' '&&flag == 1)
		             {
		             	chinese = chinese +c[i];
		             	
		             	
		             }
		        if((c[i]=='#')&&(flag==1))
		        {
		        	flag=2;
		        }
		        if (c[i]!='#'&&c[i] != ' '&&flag == 2)
		        {
		        	ifcorrect=""+c[i];
		        }
		      }	
			WordModel model=new WordModel();
			model.setChineseMean(chinese);
			model.setChineseMean(english);
			model.setIfCorrect(ifcorrect);
			wordlist.add(sumnum, model);
		
		
	}

}
