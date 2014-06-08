import java.io.File;
import java.util.LinkedList;
import java.util.List;




public class WordBaseModel {
	LinkedList<WordModel> wordlist=new LinkedList<WordModel>();
	int sunnum;
	int recitednum;
	int unrecitednum;
	int wrongnum;
	int rightnum;
	int currentwordindex;
	WordBaseModel(String letter)
	{
		if (findRecordText(letter))
		{
			inputFromRecord();
		}
		else
		{
			inputFromDictionary();
		}
		
	}
	public boolean findRecordText(String letter)
	{
		String[] recordname;
		File f = new File(ReadDat.filePath);
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
	public void inputFromRecord()
	{
		
	}
	public void inputFromDictionary()
	{
		
	}

}
