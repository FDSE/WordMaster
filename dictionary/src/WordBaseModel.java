import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	//²»´æÈëµÄ
	int wordcount=0;
	int rightcount=0;
	int wrongcount=0;
	
	String localletter;
	WordBaseModel(String letter) throws IOException
	{
		localletter=letter;
		if (findRecordText(letter))
		{
			inputFromRecord(letter);
		}
		else
		{
			inputFromDictionary(letter);
		}
		
	}
	public boolean setCurrentWord(String word)
	{
		for (int i=0;i<sumnum;i++)
		{
			if (wordlist.get(i).getEnglishMean().equals(word))
			{
				currentwordindex=i;
				return true;
			}
		}
		return false;
	}
	public boolean ifEnd()
	{
		return (wordcount==0);
	}
	public boolean judgeWord(String word)
	{
		WordModel wordmodel=wordlist.get(currentwordindex);
		String englishmeaning=wordmodel.getEnglishMean();
		if (word.equals(englishmeaning))
		{
			if (wordmodel.getIfCorrect().equals("0"))
			{
				recitednum++;
				unrecitednum--;
				rightnum++;
			}
			if (wordmodel.getIfCorrect().equals("1"))
			{
				
			}
			if (wordmodel.getIfCorrect().equals("2"))
			{
				rightnum++;
				wrongnum--;
			}
			rightcount++;
			return true;
		}
		else
		{
			if (wordmodel.getIfCorrect().equals("0"))
			{
				recitednum++;
				unrecitednum--;
				wrongnum++;
			}
			if (wordmodel.getIfCorrect().equals("1"))
			{
				
			}
			if (wordmodel.getIfCorrect().equals("2"))
			{
				
			}
			wrongcount++;
			return false;
		}
	}
	public void nextWord()
	{
		currentwordindex++;
		wordcount--;
	}
	public boolean setCountWord(int count)
	{
		int wordleft=sumnum-currentwordindex;
		if (count<=wordleft)
		{
			wordcount=count;
			return true;
		}
		else
		{
			wordcount=wordleft;
			return false;
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
	public void inputFromDictionary(String letter) throws IOException
	{
		String fileName;
		fileName =ReadDat.filePath + ReadDat.fileName + ".txt";
		FileReader in = new FileReader(fileName);
		BufferedReader buf = new BufferedReader(in);
		String temp;
		while((temp=buf.readLine()).charAt(0)!=letter.toLowerCase().charAt(0))
		do
		{
			readWord(temp);
			sumnum++;
		}
		while((temp=buf.readLine())!=null);
		unrecitednum=sumnum;
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
	public void outputRecord() throws IOException
	{
		FileWriter fw = new FileWriter("src/record/record-"+localletter+".txt");
		fw.write(""+sumnum+"\n");
		fw.write(""+recitednum+"\n");
		fw.write(""+unrecitednum+"\n");
		fw.write(""+wrongnum+"\n");
		fw.write(""+rightnum+"\n");
		fw.write(""+currentwordindex+"\n");
		for (int i=0;i<wordlist.size();i++)
		{
			fw.write(wordlist.get(i).getEnglishMean()+" "+wordlist.get(i).getChineseMean()+"#"+wordlist.get(i).getIfCorrect()+"\n");
		}
		fw.close();


	}

}
