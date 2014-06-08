package word_master;

import java.util.Observable;


public class ProcessModel extends Observable{
	int state=0;

	public void changeModel(int a)
	{
		this.state=a;
		setChanged();
		notifyObservers(a);
	}

}
