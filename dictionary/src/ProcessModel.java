import java.awt.GridLayout;
import java.util.Observable;


public class ProcessModel extends Observable{
	int state=0;
	WordBaseModel basemodel;

	public void changeModel(int a)
	{
		this.state=a;
		setChanged();
		notifyObservers(a);
	}
	public void setWordBaseModel(WordBaseModel o)
	{
		basemodel=o;
	}

}
