import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WordLastPanel extends JPanel{
	JLabel a,b,c,d,e,f;
	WordLastPanel(ProcessModel o)
	{
		this.setLayout(new GridLayout(3,2));
		this.setBorder(BorderFactory.createTitledBorder("背单词总结"));
		a=new JLabel("本次总共单词数：");
		b=new JLabel(""+(o.basemodel.rightcount+o.basemodel.wrongcount)+"个");

		c=new JLabel("本次总共背对数：");
		d=new JLabel(""+o.basemodel.rightcount+"个");
		e=new JLabel("本次总共背错数：");
		f=new JLabel(""+o.basemodel.wrongcount+"个");
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(e);
		this.add(f);
		
		
	}

}
