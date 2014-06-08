import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WordRecitePanel extends JPanel{
	JPanel chinesepanel;
	JPanel textpanel;
	JPanel otherpanel;
	JPanel judgepanel;
	JPanel countpanel;
	JLabel chinese;
	JTextField text;
	JLabel judge,count;
	WordRecitePanel()
	{
		this.setLayout(new GridLayout(3,1));
		chinesepanel.setLayout(new GridLayout(1,2));
		textpanel.setLayout(new GridLayout(1,2));
		otherpanel.setLayout(new GridLayout(1,2));
		chinese.setText("中文意译");
		text=new JTextField();
		judge=new JLabel("Correct!");
		count=new JLabel("50 words left");
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

}
