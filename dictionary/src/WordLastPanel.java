import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WordLastPanel extends JPanel{
	JLabel a,b,c,d,e,f;
	WordLastPanel(ProcessModel o)
	{
		this.setLayout(new GridLayout(3,2));
		this.setBorder(BorderFactory.createTitledBorder("�������ܽ�"));
		a=new JLabel("�����ܹ���������");
		b=new JLabel(""+(o.basemodel.rightcount+o.basemodel.wrongcount)+"��");

		c=new JLabel("�����ܹ���������");
		d=new JLabel(""+o.basemodel.rightcount+"��");
		e=new JLabel("�����ܹ���������");
		f=new JLabel(""+o.basemodel.wrongcount+"��");
		this.add(a);
		this.add(b);
		this.add(c);
		this.add(d);
		this.add(e);
		this.add(f);
		
		
	}

}
