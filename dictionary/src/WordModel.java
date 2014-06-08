
public class WordModel {
	private String chinesemean;
	private String englishmean;
	private String ifcorrect;
	public void setChineseMean(String chinese)
	{
		chinesemean=chinese;
	}
	public void setEnglishMean(String english)
	{
		englishmean=english;
	}
	public String getChineseMean()
	{
		return chinesemean;
	}
	public String getEnglishMean()
	{
		return  englishmean;
	}
	public void setIfCorrect(String ifcorrect)
	{
		this.ifcorrect=ifcorrect;
	}
	public String getIfCorrect()
	{
		return ifcorrect;
	}

}
