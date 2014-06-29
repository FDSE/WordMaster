import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




public class WordRecitePanel extends JPanel implements Observer{
	JPanel chinesepanel;
	JPanel textpanel;
	JPanel otherpanel;
	JPanel judgepanel;
	JPanel countpanel;
	JLabel chinese;
	JTextField text;
	JLabel judge,count;
	ProcessModel process;
	WordRecitePanel(ProcessModel o)
	{
		process=o;
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
		text.setText("");
		text.getDocument().addDocumentListener(new TextListen());
		  
		judge=new JLabel("             ");
		count=new JLabel();
		count.setText(process.basemodel.wordcount+" words left");
		chinesepanel.add(chinese);
		chinesepanel.add(new JLabel("             "));
		textpanel.add(text);
		text.add(new JLabel("             "));
		otherpanel.add(judge);
		otherpanel.add(count);
		this.add(chinesepanel);
		this.add(textpanel);
		this.add(otherpanel);
		this.setBorder(BorderFactory.createTitledBorder("单词测试"));
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
		if ((Integer)arg1==0)
		{
			chinese.setText(process.basemodel.wordlist.get(process.basemodel.currentwordindex).getChineseMean());
			count.setText(process.basemodel.wordcount+" words left");
			judge.setText("");
			text.setText("");
			this.repaint();
		}
		if ((Integer)arg1==1||(Integer)arg1==3)
		{
			judge.setText("正确！");
		}
		if ((Integer)arg1==2||(Integer)arg1==4)
		{
			judge.setText("错误！正确单词为"+process.basemodel.wordlist.get(process.basemodel.currentwordindex).getEnglishMean());
		}
		// TODO Auto-generated method stub
		
	}
	class TextListen implements DocumentListener
	{
		public void insertUpdate(DocumentEvent e)
		{
			ReadDat.testword = text.getText();
			//System.out.println(ReadDat.wordCount+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		public void removeUpdate(DocumentEvent e)
		{
			ReadDat.testword = text.getText();
		}
		
		public void changedUpdate(DocumentEvent e)
		{
			ReadDat.testword = text.getText();
			
		}
	}

}
