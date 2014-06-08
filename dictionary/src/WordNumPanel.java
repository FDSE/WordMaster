import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




public class WordNumPanel extends JPanel{
	JLabel label;
	JTextField wordCountText;
	JPanel textpanel;
	JPanel labelpanel;
	JLabel mention;
	JPanel mentionpanel;
	ProcessModel process;
	WordNumPanel(ProcessModel o)
	{
		process=o;
		this.setLayout(new GridLayout(1,3));
		label=new JLabel("�����뱳����������");
		textpanel=new JPanel();
		labelpanel=new JPanel();
		mentionpanel=new JPanel();
		mention=new JLabel("��ʾ��");
		mentionpanel.add(mention);
		wordCountText=new JTextField();
		
		wordCountText.getDocument().addDocumentListener(new TextListen());
		label.setOpaque(false);
		wordCountText.setOpaque(false);
		textpanel.setOpaque(false);
		labelpanel.setOpaque(false);
		labelpanel.add(label);
		textpanel.add(wordCountText);
		this.add(labelpanel);
		this.add(textpanel);
		this.add(mentionpanel);
	}
	class TextListen implements DocumentListener
	{
		public void insertUpdate(DocumentEvent e)
		{
			ReadDat.wordcount= wordCountText.getText();
			if (!process.basemodel.setCountWord(Integer.parseInt(ReadDat.wordcount)))
			{
				mention.setText("�����������ƣ����Զ���ȡΪ��������");
			}
			//System.out.println(ReadDat.wordCount+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		public void removeUpdate(DocumentEvent e)
		{
			ReadDat.wordcount = wordCountText.getText();
			if (!process.basemodel.setCountWord(Integer.parseInt(ReadDat.wordcount)))
			{
				mention.setText("�����������ƣ����Զ���ȡΪ��������");
			}
		}
		
		public void changedUpdate(DocumentEvent e)
		{
			ReadDat.wordcount = wordCountText.getText();
			if (!process.basemodel.setCountWord(Integer.parseInt(ReadDat.wordcount)))
			{
				mention.setText("�����������ƣ����Զ���ȡΪ��������");
			}
			
		}
	}

}
