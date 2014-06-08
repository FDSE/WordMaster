import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WordNumPanel extends JPanel{
	JLabel label;
	JTextField wordCountText;
	JPanel textpanel;
	JPanel labelpanel;
	WordNumPanel()
	{
		this.setLayout(new GridLayout(1,2));
		label=new JLabel("请输入背单词数量：");
		textpanel=new JPanel();
		labelpanel=new JPanel();
		wordCountText=new JTextField();
		label.setOpaque(false);
		wordCountText.setOpaque(false);
		textpanel.setOpaque(false);
		labelpanel.setOpaque(false);
		labelpanel.add(label);
		textpanel.add(wordCountText);
		this.add(labelpanel);
		this.add(textpanel);
	}

}
