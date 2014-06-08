import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class WordStoreButton extends JPanel implements MouseListener, MouseMotionListener{
	
	ProcessModel process=null;
	JPanel pnLog3 = null;
	CardLayout cardLog3 = null;
	JLabel lb22, lb23, lb24;
	
	JPanel pnLog4 = null;
	CardLayout cardLog4 = null;
	JLabel lb25, lb26, lb27;
	
	JPanel pnLog5 = null;
	CardLayout cardLog5 = null;
	JLabel lb28, lb29, lb30;
	WordStoreButton(ProcessModel o)
	{
		process=o;
		ImageIcon ic22 = new ImageIcon("src/image/button5.png");
		ic22.setImage(ic22.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic23 = new ImageIcon("src/image/button6.png");
		ic23.setImage(ic23.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic24 = new ImageIcon("src/image/button5.png");
		ic24.setImage(ic24.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		
		ImageIcon ic25 = new ImageIcon("src/image/button7.png");
		ic25.setImage(ic25.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic26 = new ImageIcon("src/image/button8.png");
		ic26.setImage(ic26.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic27 = new ImageIcon("src/image/button7.png");
		ic27.setImage(ic27.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		
		ImageIcon ic28 = new ImageIcon("src/image/button9.png");
		ic28.setImage(ic28.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic29 = new ImageIcon("src/image/button10.png");
		ic29.setImage(ic29.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic30 = new ImageIcon("src/image/button9.png");
		ic30.setImage(ic30.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		
		lb22 = new JLabel(ic22);
		lb23 = new JLabel(ic23);
		lb24 = new JLabel(ic24);
		
		lb26 = new JLabel(ic26);
		lb27 = new JLabel(ic27);
		lb25 = new JLabel(ic25);
		
		lb28 = new JLabel(ic28);
		lb29 = new JLabel(ic29);
		lb30 = new JLabel(ic30);
		
	
		
		cardLog3 = new CardLayout();
		pnLog3 = new JPanel(cardLog3);
		//pnLog.setSize(20, 10);
		pnLog3.addMouseListener(this);
		pnLog3.setOpaque(false);
		pnLog3.add(lb22, "22");
		pnLog3.add(lb23, "23");
		pnLog3.add(lb24, "24");
		
		cardLog4 = new CardLayout();
		pnLog4 = new JPanel(cardLog4);
		//pnLog.setSize(20, 10);
		pnLog4.addMouseListener(this);
		pnLog4.setOpaque(false);
		pnLog4.add(lb25, "25");
		pnLog4.add(lb26, "26");
		pnLog4.add(lb27, "27");
		
		cardLog5 = new CardLayout();
		pnLog5 = new JPanel(cardLog5);
		//pnLog.setSize(20, 10);
		pnLog5.addMouseListener(this);
		pnLog5.setOpaque(false);
		pnLog5.add(lb28, "28");
		pnLog5.add(lb29, "29");
		pnLog5.add(lb30, "30");
		
		this.setLayout((new FlowLayout(FlowLayout.CENTER,0,5)));
		this.add(pnLog3);
		this.add(new JLabel("       "));
		this.add(pnLog4);
		this.add(new JLabel("       "));
		this.add(pnLog5);
		this.setOpaque(false);
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Object sou = arg0.getSource();
		if (sou==pnLog3)
		{
			process.changeModel(2);
		}
		else if (sou==pnLog4)
		{
			process.changeModel(3);
		}
		else if(sou==pnLog5)
		{
			process.changeModel(0);
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		Object sou = arg0.getSource();
		if(sou == pnLog3) {
			cardLog3.show(pnLog3, "23");
		}
		else if (sou==pnLog4)
		{
			cardLog4.show(pnLog4, "26");
		}
		else if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "29");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		Object sou = arg0.getSource();
		if(sou == pnLog3) {
			cardLog3.show(pnLog3, "22");
		}
		else if (sou==pnLog4)
		{
			cardLog4.show(pnLog4, "25");
		}
		else if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "28");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		Object sou = arg0.getSource();
		if(sou == pnLog3) {
			cardLog3.show(pnLog3, "24");
		}
		else if (sou==pnLog4)
		{
			cardLog4.show(pnLog4, "27");
		}
		else if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "30");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		Object sou = arg0.getSource();
		if(sou == pnLog3) {
			cardLog3.show(pnLog3, "23");
		}
		else if (sou==pnLog4)
		{
			cardLog4.show(pnLog4, "26");
		}
		else if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "29");
		}
		// TODO Auto-generated method stub
		
	}
	

}
