import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PadPanel extends JPanel{
	JLabel pad1,pad2,pad3,pad4,pad5,pad6,pad7,pad8,pad9,pad10,pad11,pad12;
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10,panel11,panel12;
	PadPanel()
	{
		this.setLayout(new GridLayout(1,12));
		pad1=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad2=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad3=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad4=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");
		pad5=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad6=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");
		pad7=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad8=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad9=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad10=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");
		pad11=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  ");
		pad12=new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		panel8=new JPanel();
		panel9=new JPanel();
		panel10=new JPanel();
		panel11=new JPanel();
		panel12=new JPanel();
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		pad1.setOpaque(false);
		pad2.setOpaque(false);
		pad3.setOpaque(false);
		pad4.setOpaque(false);
		pad5.setOpaque(false);
		pad6.setOpaque(false);
		this.add(pad1);
		this.add(pad2);
		this.add(pad3);
		this.add(pad4);
		this.add(pad5);
		this.add(pad6);
		this.add(pad7);
		this.add(pad8);
		this.add(pad9);
		this.add(pad10);
		this.add(pad11);
		this.add(pad12);
		this.setOpaque(false);
	}
	

}
