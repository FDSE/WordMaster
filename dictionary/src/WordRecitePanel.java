import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WordRecitePanel extends JPanel implements Observer{
	JPanel chinesepanel;
	JPanel textpanel;
	JPanel otherpanel;
	JPanel judgepanel;
	JPanel countpanel;
	JLabel chinese;
	JTextField text;
	JLabel judge,count;
	WordRecitePanel(ProcessModel o)
	{
		ProcessModel process=o;
		process.basemodel.addObserver(this);
		judgepanel=new JPanel();
		countpanel=new JPanel();
		this.setLayout(new GridLayout(3,1));
		chinesepanel=new JPanel();
		chinesepanel.setLayout(new GridLayout(1,2));
		textpanel=new JPanel();
		textpanel.setLayout(new GridLayout(1,2));
		otherpanel=new JPanel();
		otherpanel.setLayout(new GridLayout(1,2));
		chinese=new JLabel();
		chinese.setText(process.basemodel.wordlist.get(process.basemodel.currentwordindex).getChineseMean());
		text=new JTextField();
		judge=new JLabel("             ");
		count=new JLabel(process.basemodel.wordcount+" words left");
		chinesepanel.add(chinese);
		chinesepanel.add(new JLabel("             "));
		textpanel.add(text);
		text.add(new JLabel("             "));
		otherpanel.add(judge);
		otherpanel.add(count);
		this.add(chinesepanel);
		this.add(textpanel);
		this.add(otherpanel);
		this.setBorder(BorderFactory.createTitledBorder("µ•¥ ≤‚ ‘"));
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
