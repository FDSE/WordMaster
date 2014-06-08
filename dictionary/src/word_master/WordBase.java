package word_master;

import java.io.*;

public class WordBase
{
	String[] wordBaseName;
	
	  public String[] getDatName()
	{
		
		File f = new File(ReadDat.filePath);
		wordBaseName = f.list(new DirFilter(".txt"));
		
		for(int i =0;i<wordBaseName.length;i++)
		{
		wordBaseName[i]=getName(wordBaseName[i]);
		System.out.println(wordBaseName[i]);
		}
		return wordBaseName;
	}
    
    ///////////////////////////////////////////////
    /////////
    class DirFilter implements FilenameFilter
    {
    	String s;
    	DirFilter(String ss)
    	{
    		s = ss;
    	}
    	
    	public boolean accept(File dir, String name)
    	{
    		String f = new File(name).getName();
    		return f.indexOf(s) != -1;
    	}
    }
    
    ////////////////////////////////////////////////////////////////
    //////////////////È¥µôºó×º
    public String getName(String s)
    {
    	String temp = "";
    	int i = 0;
    	char[] ch = new char[30];
    	s.getChars(0,s.length(),ch,0);
    	while(i <s.length() && ch[i]!='.')
    	{
    		temp = temp +ch[i];
			i++;
    	}
    	return temp;
    }
    
    

}