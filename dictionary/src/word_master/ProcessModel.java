<<<<<<< HEAD:dictionary/src/ProcessModel.java
import java.awt.GridLayout;
=======
package word_master;

>>>>>>> FETCH_HEAD:dictionary/src/word_master/ProcessModel.java
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
