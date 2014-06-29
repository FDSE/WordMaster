

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainView;

import org.dom4j.DocumentException;






import com.sun.awt.AWTUtilities.*;

public class Helloframe extends JFrame implements Observer,MouseListener, MouseMotionListener{

	WordStoreButton wordstorebutton;
	WordStorePanel wordstorepanel;
	JPanel pnMidR=null;
	private Point loc = null;    
	private Point tmp = null;    
	private boolean isDragged = false;
	ImagePanel impn = null;
	ProcessModel process=null;
	JPanel pnTop = null;
	
	JPanel pnClose = null;
	CardLayout cardClose = null;
	JLabel lb1, lb2, lb3;
	
	JPanel pnMin = null;
	CardLayout cardMin = null;
	JLabel lb4, lb5, lb6;
	
	JPanel pnSet = null;
	CardLayout cardSet = null;
	JLabel lb7, lb8, lb9;
	
	
	
	JPanel pnSouth = null;
	
	JPanel pnMid = null;
	JLabel lbAccount = null;
	
	ImagePanel pnBelow = null;
	
	JPanel pnLog = null;
	CardLayout cardLog = null;
	JLabel lb10, lb11, lb12;
	
	JPanel pnLog2 = null;
	CardLayout cardLog2 = null;
	JLabel lb19, lb20, lb21;

		
	JPanel pnLeft = null;
	JPanel pnMul = null;
	CardLayout cardMul = null;
	JLabel lb13, lb14, lb15;
	
	JPanel pnRight = null;
	JPanel pnShan = null;
	CardLayout cardShan = null;
	JLabel lb16, lb17, lb18;
	
	
	ImagePanel pnLin = null;
	JPanel iptx = null;
	JTextField jtf = null;
	
	ImagePanel pnLin2 = null;
	JPasswordField jpsw = null;
	
	JLabel lbdown = null;
	JWindow jwinAcc = null;
	JPanel P=null;
	public static void main(String[] args) {
		new Helloframe();
	}
	
	public Helloframe() {
		process=new ProcessModel();
		process.addObserver(this);
		Image im1 = new ImageIcon("src/image/morning.jpg").getImage();
		Image im2 = new ImageIcon("src/image/noon.jpg").getImage();
		Image im3 = new ImageIcon("src/image/1.jpg").getImage();
		Image im4 = new ImageIcon("src/image/3.jpg").getImage();
		impn = new ImagePanel(im3);
		impn.setLayout(new BorderLayout());
		
		this.add(impn);
		
		pnTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		pnTop.setOpaque(false);
		
		ImageIcon ic1 = new ImageIcon("src/image/clouse.png");
		ImageIcon ic2 = new ImageIcon("src/image/clouse_hover.png");
		ImageIcon ic3 = new ImageIcon("src/image/clouse_press.png");
		ImageIcon ic4 = new ImageIcon("src/image/minimize.png");
		ImageIcon ic5 = new ImageIcon("src/image/minimize_hover.png");
		ImageIcon ic6 = new ImageIcon("src/image/minimize_press.png");
		ImageIcon ic7 = new ImageIcon("src/image/btn_set_normal.png");
		ImageIcon ic8 = new ImageIcon("src/image/btn_set_hover.png");
		ImageIcon ic9 = new ImageIcon("src/image/btn_set_press.png");
		ImageIcon ic10 = new ImageIcon("src/image/button1.png");
		ic10.setImage(ic10.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		ImageIcon ic11 = new ImageIcon("src/image/button3.png");
		ic11.setImage(ic11.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		
		ImageIcon ic12 = new ImageIcon("src/image/button1.png");
		ic12.setImage(ic12.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		ImageIcon ic13 = new ImageIcon("src/image/corner_back.png");
		ImageIcon ic14 = new ImageIcon("src/image/corner_back_hover.png");
		ImageIcon ic15 = new ImageIcon("src/image/corner_back_press.png");
		ImageIcon ic16 = new ImageIcon("src/image/corner_right.png");
		ImageIcon ic17 = new ImageIcon("src/image/corner_right_hover.png");
		ImageIcon ic18 = new ImageIcon("src/image/corner_right_press.png");
		ImageIcon ic19 = new ImageIcon("src/image/button4.png");
		ic19.setImage(ic19.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		ImageIcon ic20 = new ImageIcon("src/image/button2.png");
		ic20.setImage(ic20.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		ImageIcon ic21 = new ImageIcon("src/image/button4.png");
		ic21.setImage(ic21.getImage().getScaledInstance(100, 20, Image.SCALE_DEFAULT));
		
		lb1 = new JLabel(ic1);
		lb2 = new JLabel(ic2);
		lb3 = new JLabel(ic3);
		lb4 = new JLabel(ic4);
		lb5 = new JLabel(ic5);
		lb6 = new JLabel(ic6);
		lb7 = new JLabel(ic7);
		lb8 = new JLabel(ic8);
		lb9 = new JLabel(ic9);
		lb10 = new JLabel(ic10);
		//lb10.setSize(20, 10);
		lb11 = new JLabel(ic11);
		//lb11.setSize(20, 10);
		lb12 = new JLabel(ic12);
		//lb12.setSize(20, 10);
		lb13 = new JLabel(ic13);
		lb14 = new JLabel(ic14);
		lb15 = new JLabel(ic15);
		lb16 = new JLabel(ic16);
		lb17 = new JLabel(ic17);
		lb18 = new JLabel(ic18);
		lb19 = new JLabel(ic19);
		//lb19.setSize(20, 10);
		lb20 = new JLabel(ic20);
		//lb20.setSize(20, 10);
		lb21 = new JLabel(ic21);
		//lb21.setSize(20, 10);
		
		cardClose = new CardLayout();
		pnClose = new JPanel(cardClose);
		pnClose.addMouseListener(this);
		pnClose.setOpaque(false);
		pnClose.add(lb1, "1");
		pnClose.add(lb2, "2");
		pnClose.add(lb3, "3");
		
		cardMin = new CardLayout();
		pnMin = new JPanel(cardMin);
		pnMin.addMouseListener(this);
		pnMin.setOpaque(false);
		pnMin.add(lb4, "4");
		pnMin.add(lb5, "5");
		pnMin.add(lb6, "6");
		
		cardSet = new CardLayout();
		pnSet = new JPanel(cardSet);
		pnSet.addMouseListener(this);
		pnSet.setOpaque(false);
		pnSet.add(lb7, "7");
		pnSet.add(lb8, "8");
		pnSet.add(lb9, "9");
		
		cardLog = new CardLayout();
		pnLog = new JPanel(cardLog);
		//pnLog.setSize(20, 10);
		pnLog.addMouseListener(this);
		pnLog.setOpaque(false);
		pnLog.add(lb10, "10");
		pnLog.add(lb11, "11");
		pnLog.add(lb12, "12");
		
		cardLog2 = new CardLayout();
		pnLog2 = new JPanel(cardLog2);
		//pnLog2.setSize(20, 10);
		pnLog2.addMouseListener(this);
		pnLog2.setOpaque(false);
		pnLog2.add(lb19, "19");
		pnLog2.add(lb20, "20");
		pnLog2.add(lb21, "21");
		
		
		cardMul = new CardLayout();
		pnMul = new JPanel(cardMul);
		pnMul.addMouseListener(this);
		pnMul.setOpaque(false);
		pnMul.add(lb13, "13");
		pnMul.add(lb14, "14");
		pnMul.add(lb15, "15");
		pnLeft = new JPanel(new BorderLayout());
		pnLeft.setOpaque(false);
		pnLeft.add(pnMul, "South");
		
		cardShan = new CardLayout();
		pnShan = new JPanel(cardShan);
		pnShan.addMouseListener(this);
		pnShan.setOpaque(false);
		pnShan.add(lb16, "16");
		pnShan.add(lb17, "17");
		pnShan.add(lb18, "18");
		pnRight = new JPanel(new BorderLayout());
		pnRight.setOpaque(false);
		pnRight.add(pnShan, "South");
		
		pnTop.add(pnSet);
		pnTop.add(pnMin);
		pnTop.add(pnClose);
		
		impn.add(pnTop, "North");
		
		
		
		pnSouth = new JPanel(new BorderLayout());
		pnSouth.setOpaque(false);
		
		pnMid = new JPanel();
		pnMid.setOpaque(false);

		
		pnSouth.add(pnMid, "Center");
		
		pnMidR = new JPanel(new BorderLayout());
		pnMidR.setOpaque(false);
		pnMidR.setBackground(Color.cyan);
		pnMid.add(pnMidR/*, "Center"*/);
		
		
		
		JPanel pnU = new JPanel(new GridLayout(2, 1, 0, 0));
		pnU.setOpaque(false);
		pnU.setBackground(Color.red);
		pnMidR.add(pnU, "Center");
		
		JPanel pntx = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
		pntx.setOpaque(false);
		pntx.setBackground(Color.pink);
		pnU.add(pntx);
		
		
		pnLin = new ImagePanel(new ImageIcon("src/image/inputbox.png").getImage());
		pnLin.addMouseListener(this);
		pnLin.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		
		iptx = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		iptx.setLayout(fl);
		iptx.setLayout(new BorderLayout());
		
		jtf = new JTextField(16);
		jtf.setText("");
		jtf.setFont(new Font(null, Font.PLAIN, 14));
		jtf.addMouseListener(this);
		jtf.setSize(200, 20);
		jtf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		iptx.add(jtf);
		pnLin.add(iptx);
		
		
		lbdown = new JLabel(new ImageIcon("src/image/direct_down.png"));
		lbdown.addMouseListener(this);
		iptx.add(lbdown, "East");
		
		JLabel lbZhuCe = new JLabel(new ImageIcon("src/image/zhuce.png"));
		pntx.add(lbZhuCe, "East");
		pntx.add(pnLin);
		
		JPanel pnps = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
		pnps.setOpaque(false);
		pnps.setBackground(Color.yellow);
		pnU.add(pnps);
		
		pnLin2 = new ImagePanel(new ImageIcon("src/image/inputbox.png").getImage());
		pnLin2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		
		JPanel ipps = new JPanel();
		ipps.setLayout(new BorderLayout());
		
		jpsw = new JPasswordField(16);
		jpsw.setText("");
		jpsw.setFont(new Font(null, Font.PLAIN, 14));
		jpsw.addMouseListener(this);
		jpsw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ipps.add(jpsw);
		pnLin2.add(ipps);
		
		JLabel lbKeyB = new JLabel(new ImageIcon("src/image/keyboard.png"));
		ipps.add(lbKeyB, "East");
		
		JLabel lbMima = new JLabel(new ImageIcon("src/image/mima_press.png"));
		pnps.add(lbMima, "East");
		
		pnps.add(pnLin2);
		JPanel pnD = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		pnD.setOpaque(false);
		pnMidR.add(pnD, "South");
		
		
		
		
		Image imBelow = new ImageIcon("//src/image/below.png").getImage();
		pnBelow = new ImagePanel(imBelow);
		pnBelow.setLayout(new BorderLayout(0, 20));
		
		P=new JPanel(new FlowLayout(FlowLayout.CENTER,0,5));
		P.add(pnLog);
		P.add(new JLabel("               "));
		P.add(pnLog2);
		P.setOpaque(false);
		
		pnBelow.add(pnLeft, "West");
		pnBelow.add(P, "Center");
		pnBelow.add(pnRight, "East");
		pnSouth.add(pnBelow, "South");
		
		impn.add(pnSouth, "South");
		
		this.setAlwaysOnTop(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
        //com.sun.awt.AWTUtilities.setWindowShape(this, new RoundRectangle2D.Double(0.0D, 0.0D, this.getWidth(), this.getHeight(), 12.0D, 12.0D));  
        this.setVisible(true); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object sou = e.getSource();
		if(jwinAcc != null) {
			jwinAcc.dispose();
		}
		if(sou == pnClose) {
			System.exit(0);
		} else if(sou == pnMin) {
			this.setState(ICONIFIED);
		} else if(sou == pnSet) {
			impn.setIm(new ImageIcon("src/image/night.jpg").getImage());
			this.repaint();
		} else if(sou == lbdown) {
			System.out.println("lbdown");
			jwinAcc= new JWindow();
			jwinAcc.setAlwaysOnTop(true);
			jwinAcc.setSize(iptx.getWidth(), 200);
			jwinAcc.setLocation(iptx.getLocationOnScreen().x, iptx.getLocationOnScreen().y+iptx.getHeight()+2);
			jwinAcc.setVisible(true);
		} else if(sou == pnLog) {
			try {
				process.changeModel(1);
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(sou==pnLog2)
		{
			System.exit(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object sou = e.getSource();
		if(sou == pnClose) {
			cardClose.show(pnClose, "2");
		} else if(sou == pnMin) {
			cardMin.show(pnMin, "5");
		} else if(sou == pnSet) {
			cardSet.show(pnSet, "8");
		} else if(sou == pnLog) {
			cardLog.show(pnLog, "11");
		} else if(sou == pnLog2) {
			cardLog2.show(pnLog2, "20");
		} else if(sou == pnMul) {
			cardMul.show(pnMul, "14");
		} else if(sou == pnShan) {
			cardShan.show(pnShan, "17");
		} else if(sou == jtf) {
			pnLin.setIm(new ImageIcon("src/image/inputbox_hover.png").getImage());
			this.repaint();
		} else if(sou == jpsw) {
			pnLin2.setIm(new ImageIcon("src/image/inputbox_hover.png").getImage());
			this.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object sou = e.getSource();
		if(sou == pnClose) {
			cardClose.show(pnClose, "1");
		} else if(sou == pnMin) {
			cardMin.show(pnMin, "4");
		} else if(sou == pnSet) {
			cardSet.show(pnSet, "7");
		} else if(sou == pnLog) {
			cardLog.show(pnLog, "10");
		} else if(sou == pnLog2) {
			cardLog2.show(pnLog2, "19");
		} else if(sou == pnMul) {
			cardMul.show(pnMul, "13");
		} else if(sou == pnShan) {
			cardShan.show(pnShan, "16");
		} else if(sou == jtf) {
			pnLin.setIm(new ImageIcon("src/image/inputbox.png").getImage());
			this.repaint();
		} else if(sou == jpsw) {
			pnLin2.setIm(new ImageIcon("src/image/inputbox.png").getImage());
			this.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(jwinAcc != null) {
			jwinAcc.dispose();
		}
		tmp = new Point(e.getX(), e.getY());
		isDragged = true; 
		Object sou = e.getSource();
		if(sou == pnClose) {
			cardClose.show(pnClose, "3");
		} else if(sou == pnMin) {
			cardMin.show(pnMin, "6");
		} else if(sou == pnSet) {
			cardSet.show(pnSet, "9");
		} else if(sou == pnLog) {
			cardLog.show(pnLog, "12");
		} 
		else if(sou == pnLog2) {
			cardLog2.show(pnLog2, "21");
		} else if(sou == pnMul) {
			cardMul.show(pnMul, "15");
		} else if(sou == pnShan) {
			cardShan.show(pnShan, "18");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isDragged = false; 	
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
		Object sou = e.getSource();
		if(sou == pnClose) {
			cardClose.show(pnClose, "2");
		} else if(sou == pnMin) {
			cardMin.show(pnMin, "5");
		} else if(sou == pnSet) {
			cardSet.show(pnSet, "8");
		} else if(sou == pnLog) {
			cardLog.show(pnLog, "11");
		}  else if(sou == pnLog2) {
			cardLog2.show(pnLog2, "20");
		} else if(sou == pnMul) {
			cardMul.show(pnMul, "14");
		} else if(sou == pnShan) {
			cardShan.show(pnShan, "17");
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(jwinAcc != null) {
			jwinAcc.dispose();
		}
		if(isDragged)
		{
			loc = new Point(getLocation().x + e.getX() - tmp.x,getLocation().y + e.getY() - tmp.y);
			setLocation(loc);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if ((Integer)arg1==1)
		{
			this.setSize(500, 450);
			impn.setIm(new ImageIcon("src/image/7.jpg").getImage());
			wordstorepanel=new WordStorePanel();
			wordstorepanel.setOpaque(false);
			wordstorebutton=new WordStoreButton(process);
			wordstorebutton.setOpaque(false);
			P.removeAll();
			pnMid.removeAll();
			pnMid.add(wordstorepanel);
			pnMid.validate();
			P.add(wordstorebutton,"Center");
			P.validate();		
			this.repaint();
		}
		if ((Integer)arg1==0)
		{
			this.setSize(500, 300);
			impn.setIm(new ImageIcon("src/image/1.jpg").getImage());
			P.removeAll();
			pnMid.removeAll();
			P.add(pnLog);
			P.add(new JLabel("               "));
			P.add(pnLog2);
			pnMid.add(pnMidR);
			P.validate();
			pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==2)
		{
			
		   impn.setIm(new ImageIcon("src/image/8.jpg").getImage());
		   P.removeAll();
		   pnMid.removeAll();
		   try {
		    
			pnMid.add(new WordStatisticPanel(ReadDat.letter));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   P.add(new WordStatisticButton(process));
		   pnMid.validate();
		   P.validate();
		   this.repaint();
		}
		if ((Integer)arg1==3)
		{
			try {
				WordBaseModel a=new WordBaseModel(ReadDat.letter);
				process.basemodel=a;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			impn.setIm(new ImageIcon("src/image/9.jpg").getImage());
			P.removeAll();
			pnMid.removeAll();
			pnMid.add(new WordSetPanel());
			P.add(new WordSetButton(process));
			P.validate();
			pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==4)
		{
			
			impn.setIm(new ImageIcon("src/image/11.jpg").getImage());
			P.removeAll();
			pnMid.removeAll();
			pnMid.add(new WordProcessPanel(process));
			P.validate();
			pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==5)
		{
			impn.setIm(new ImageIcon("src/image/10.jpg").getImage());
			P.removeAll();
			pnMid.removeAll();
			pnMid.add(new WordNumPanel(process));
			P.add(new WordNumButton(process));
			P.validate();
			pnMid.validate();
			this.repaint();
		}
		
		if ((Integer)arg1==6)
		{
			impn.setIm(new ImageIcon("src/image/12.jpg").getImage());
			P.removeAll();
			pnMid.removeAll();
			process.basemodel.setWordNum();
			pnMid.add(new WordRecitePanel(process));
			P.add(new WordReciteButton(process));
			P.validate();
			pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==7)
		{
			
			//impn.setIm(new ImageIcon("src/image/12.jpg").getImage());
			P.removeAll();
			//pnMid.removeAll();
			//process.basemodel.setWordNum();
			//pnMid.add(new WordRecitePanel(process));
			P.add(new WordReciteButton2(process));
			P.validate();
			//pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==8)
		{
			//impn.setIm(new ImageIcon("src/image/12.jpg").getImage());
			P.removeAll();
			//pnMid.removeAll();
			//process.basemodel.setWordNum();
			//pnMid.add(new WordRecitePanel(process));
			P.add(new WordReciteButton(process));
			P.validate();
			//pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==9)
		{
			//impn.setIm(new ImageIcon("src/image/12.jpg").getImage());
			P.removeAll();
			//pnMid.removeAll();
			//process.basemodel.setWordNum();
			//pnMid.add(new WordRecitePanel(process));
			P.add(new WordReciteButton3(process));
			P.validate();
			//pnMid.validate();
			this.repaint();
		}
		if ((Integer)arg1==10)
		{
			//impn.setIm(new ImageIcon("src/image/12.jpg").getImage());
			P.removeAll();
			//pnMid.removeAll();
			//process.basemodel.setWordNum();
			//pnMid.add(new WordRecitePanel(process));
			P.add(new WordStatisticButton(process));
			pnMid.removeAll();
			pnMid.add(new WordLastPanel(process));
			P.validate();
			pnMid.validate();
			//pnMid.validate();
			this.repaint();
		}
	}

}
