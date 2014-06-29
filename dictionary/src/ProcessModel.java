import java.awt.GridLayout;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ProcessModel extends Observable{
	int state=0;
	WordBaseModel basemodel;

	public void changeModel(int a) throws DocumentException
	{
		this.state=a;
		setChanged();
		if (a==1)
		{
			initWordBase();
		}
		notifyObservers(a);
	}
	public void setWordBaseModel(WordBaseModel o)
	{
		basemodel=o;
	}
	//TODO
	public void initWordBase() throws DocumentException
	{
		String fileName;
		fileName =ReadDat.filePath + ReadDat.fileName + ".xml";
	
		File inputXml=new File(fileName);   
		SAXReader saxReader = new SAXReader();  
		Document document = saxReader.read(inputXml);
		Element words=document.getRootElement(); 
		for(Iterator i = words.elementIterator(); i.hasNext();){   
			Element wordcell = (Element) i.next();
			int k=0;
			  String english="";
			for(Iterator j = wordcell.elementIterator(); j.hasNext();){
				  Element EnglishMean;
				if (k==0)
				  {
					EnglishMean=(Element) j.next();
					english=EnglishMean.getText();
				  }
				if (k==1)
				{
					Element ChineseMean=(Element) j.next();
					addToType(ChineseMean.getText(),english);
				}
				k++;
			}
		}
	}
	//TODO
	public void addToType(String chinMeaning,String english)
	{
		//System.out.println(chinMeaning);
		if (chinMeaning.lastIndexOf('.')<0)
				{
			return;
				}
				
		String types=chinMeaning.substring(0, chinMeaning.lastIndexOf('.'));
		int q;
		for (q=0;q<types.length();q++)
		{
			
			if ((types.charAt(q)=='.')&&((q==types.length()-1)||(types.charAt(q+1)!=',')))
					break;
		}
		if (q<types.length())
			types=types.substring(0, q);
		//System.out.println(types);
		int temp=0;
		String singleMean;
		int i;
		for (i=0;i<types.length();i++)
		{
			if (types.charAt(i)=='.')
			{
				singleMean=types.substring(temp,i);
				int j;
				for (j=0;j<ReadDat.wordtype.size();j++)
				{
					if (ReadDat.wordtype.get(j).equals(singleMean))
					{
						break;
					}
				}
				if (j==ReadDat.wordtype.size())
				{
					ReadDat.wordtype.add(singleMean);
					System.out.println(singleMean);
					System.out.println(english);
					System.out.println(chinMeaning);
				}
				temp=i+2;
				i=i+2;
			}
		}
	
		singleMean=types.substring(temp);
		//System.out.println(singleMean);
		int j;
		for (j=0;j<ReadDat.wordtype.size();j++)
		{
			if (ReadDat.wordtype.get(j).equals(singleMean))
			{
				break;
			}
		}
		if (j==ReadDat.wordtype.size())
		{
			ReadDat.wordtype.add(singleMean);
			System.out.println(singleMean);
			System.out.println(english);
			System.out.println(chinMeaning);
		}
	}

}
