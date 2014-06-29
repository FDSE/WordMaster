import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

public class WordSetPanel extends JPanel
{
	
	JSlider sb ;
	//static JCheckBox checkBox1 = new JCheckBox("不显示中文");
	//static JCheckBox checkBox2 = new JCheckBox("不显示英文");
	ButtonGroup g = new ButtonGroup();
	static JRadioButton jrb1 = new JRadioButton("继  续 测  试",true);
	static JRadioButton jrb2 = new JRadioButton("从  头 开  始",false);
	static JRadioButton jrb3 = new JRadioButton("自定义起始词汇",false);
	JPanel panel = new JPanel();
	//JLabel label = new JLabel("个单词");
	//static JLabel label1 = new JLabel("");
	JLabel label2 = new JLabel("输入起始单词");
	JPanel textPanel = new JPanel();
	JPanel panel3 = new JPanel();
	static JTextField wordCountText = new JTextField(20);
	//SliderListener sl = new SliderListener();
	RadioButtonListener brl = new RadioButtonListener();
	 static int delay =1000;
	 static int order = 1;
	 /////////////////////////////////////////////////
	 ///////////
	WordSetPanel()
	{
		panel.setOpaque(false);
		//label.setForeground(Color.yellow);
		//label1.setForeground(Color.yellow);
		//label.setFont(new Font("宋体",Font.BOLD,15));
		//label1.setFont(new Font("宋体",Font.BOLD,15));
	    //CheckBoxListener boxl =new CheckBoxListener();
	    //checkBox2.setForeground(Color.yellow);
        //checkBox1.setForeground(Color.yellow);
        //checkBox2.setFont(new Font("宋体",Font.BOLD,15));
        //checkBox1.setFont(new Font("宋体",Font.BOLD,15));
        jrb1.setForeground(Color.yellow);
        jrb2.setForeground(Color.yellow);
        jrb3.setForeground(Color.yellow);
       jrb3.setFont(new Font("宋体",Font.BOLD,15)); 
       jrb1.setFont(new Font("宋体",Font.BOLD,15)); 
       jrb2.setFont(new Font("宋体",Font.BOLD,15)); 	   
 	   //sb = new JSlider(500,10000,delay);	
	 // sb.setValue(delay);
	 this.setLayout(new GridLayout(4,1));
	// sb.setOpaque(false);
	// sb.addChangeListener(sl);
	// label1.setText(String.valueOf((double)(delay/100)/10));
	 g.add(jrb1);
	 g.add(jrb2);
	 g.add(jrb3);
	 jrb1.addActionListener(brl);
	 jrb2.addActionListener(brl);
	 jrb3.addActionListener(brl);
	// panel.add(label1);
      this.setOpaque(false);
	// panel.add(label);
	 textPanel.setLayout(new GridLayout(2,1));
	 textPanel.add(label2);
	 panel3.add(wordCountText);
	 textPanel.add(panel3);
	// sb.setPreferredSize(new Dimension(100,20) );
	//  panel.add(sb);
	  //this.add(panel);
	  this.add(jrb1);
	  this.add(jrb2);
	  this.add(jrb3);
	  this.add(textPanel);  
	  //this.add(checkBox1);
	 // this.add(checkBox2);
	  wordCountText.getDocument().addDocumentListener(new TextListen());
	  
	  //wordCountText.setText(String.valueOf(ReadDat.wordCount));	
	 // checkBox1.addActionListener(boxl);
	//	checkBox2.addActionListener(boxl);
		label2.setForeground(Color.yellow);
	//	checkBox1.setOpaque(false);
	//	checkBox2.setOpaque(false);
		textPanel.setOpaque(false);
		textPanel.setVisible(false);
		label2.setOpaque(false);
		panel3.setOpaque(false);
		jrb1.setOpaque(false);
		jrb2.setOpaque(false);
		jrb3.setOpaque(false);
		ReadDat.currentwordstatus="continue";
		this.setBorder(BorderFactory.createTitledBorder("选择起始单词"));
	}
	
	public 
	
////////////////////////////////////////////////////////////////////////
////////////////	
class RadioButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if(e.getSource()==jrb1)
    		 {
    		 	jrb1.setEnabled(true);
    		 	ReadDat.currentwordstatus="continue";
    		 	textPanel.setVisible(false);
    		 	wordCountText.setText("");
    		 }
    		 
    		if(e.getSource()==jrb2)
    		 {
    		 	jrb2.setEnabled(true);
    		 	ReadDat.currentwordstatus="initial";
    		 	textPanel.setVisible(false);
    		 	wordCountText.setText("");
    		 }
    		 
    		if(e.getSource()==jrb3)
    		 {
    		 	jrb3.setEnabled(true);
    		 	ReadDat.currentwordstatus="defined";
    		 	textPanel.setVisible(true);
    		 }
    	}
    }
/////////////////////////////////////////////////
///////////////
class TextListen implements DocumentListener
{
	public void insertUpdate(DocumentEvent e)
	{
		ReadDat.currentword = wordCountText.getText();
		//System.out.println(ReadDat.wordCount+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	public void removeUpdate(DocumentEvent e)
	{
		ReadDat.currentword = wordCountText.getText();
	}
	
	public void changedUpdate(DocumentEvent e)
	{
		ReadDat.currentword = wordCountText.getText();
		
	}
}

////////////////////////////////////////////////////////////
///////////
/*
class SliderListener implements ChangeListener
    {
    	public void stateChanged(ChangeEvent e)
        {
          delay  = ((JSlider)(e.getSource())).getValue() ;
          label1.setText(String.valueOf((double)(delay/100)/10));
        }
    }*/

}
	