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

import org.dom4j.DocumentException;




public class WordStatisticButton extends JPanel implements MouseListener, MouseMotionListener{
	
	ProcessModel process=null;
	
	JPanel pnLog5 = null;
	CardLayout cardLog5 = null;
	JLabel lb28, lb29, lb30;
	WordStatisticButton(ProcessModel o)
	{
		process=o;
		
		ImageIcon ic28 = new ImageIcon("src/image/button9.png");
		ic28.setImage(ic28.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic29 = new ImageIcon("src/image/button10.png");
		ic29.setImage(ic29.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		ImageIcon ic30 = new ImageIcon("src/image/button9.png");
		ic30.setImage(ic30.getImage().getScaledInstance(80, 20, Image.SCALE_DEFAULT));
		
		
		lb28 = new JLabel(ic28);
		lb29 = new JLabel(ic29);
		lb30 = new JLabel(ic30);
		
	
		
		
		cardLog5 = new CardLayout();
		pnLog5 = new JPanel(cardLog5);
		//pnLog.setSize(20, 10);
		pnLog5.addMouseListener(this);
		pnLog5.setOpaque(false);
		pnLog5.add(lb28, "28");
		pnLog5.add(lb29, "29");
		pnLog5.add(lb30, "30");
		
		this.setLayout((new FlowLayout(FlowLayout.CENTER,0,5)));
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
        if(sou==pnLog5)
		{
			try {
				process.changeModel(1);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		Object sou = arg0.getSource();
        if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "29");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		Object sou = arg0.getSource();
        if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "28");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		Object sou = arg0.getSource();
	    if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "30");
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		Object sou = arg0.getSource();
		  if (sou==pnLog5)
		{
			cardLog5.show(pnLog5, "29");
		}
		// TODO Auto-generated method stub
		
	}
	

}
