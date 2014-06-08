import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;

public class WordStorePanel extends JPanel
{
	///////////////////////////////////////////////////////////////////////////////
	/////////////table1是单词级别表，table2是单词组表
	String [] tableName1 ={"字典选择"};
	String [] tableName2 ={"词库选择"};
	
	DefaultTableModel model1 = new DefaultTableModel(tableName1,0);
	DefaultTableModel model2 = new DefaultTableModel(tableName2,0);
	JTable table1 = new JTable(model1);
	JScrollPane tablePanel1 = new JScrollPane(table1);
	JTable table2 = new JTable(model2);
	JScrollPane tablePanel2 = new JScrollPane(table2);
	
	//WordBase wordBase = new WordBase();
     tableListener tl = new  tableListener();
     tableListener ttl = new  tableListener();	
	int mousePressCount = 0;
	int wordChooseCount =0;
	TableColumnModel columnModel = table1.getColumnModel();
	TableColumnModel columnModel1 = table2.getColumnModel();
	WordStorePanel()
	{
		columnModel.getColumn(0).setPreferredWidth(125);
		columnModel1.getColumn(0).setPreferredWidth(125);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 
		 table1.setForeground(Color.blue);
		 table2.setForeground(Color.blue);
		 tablePanel1.getHorizontalScrollBar().setBackground(Color.GRAY);
		 tablePanel1.getVerticalScrollBar().setOpaque(false);
		 tablePanel2.getVerticalScrollBar().setOpaque(false);
		 
		 table1.getTableHeader().setForeground(Color.yellow);
		 table1.getTableHeader().setBackground(Color.GRAY);
		 table2.getTableHeader().setForeground(Color.yellow);
		 table2.getTableHeader().setBackground(Color.GRAY);
		 
	    table1.addFocusListener(tl);
	    table2.addFocusListener(ttl);
	    table1.setOpaque(false);
	    table2.setOpaque(false);
	    tablePanel1.setOpaque(false);
	    tablePanel2.setOpaque(false);
		//System.out.println("aaaaaaaaaa");
		table1.setPreferredScrollableViewportSize(new Dimension(160,160));
		table2.setPreferredScrollableViewportSize(new Dimension(160,160));
		tablePanel1.setPreferredSize(new Dimension(160,160));
		tablePanel1.setPreferredSize(new Dimension(160,160));
		//tablePanel1.setSize(new Dimension(125,80));
		//tablePanel2.setSize(new Dimension(125,80));
        //this.setLayout(new GridLayout(2,1));
        //this.add(tablePanel1);
       
        this.add(tablePanel2);
        this.setBorder(BorderFactory.createTitledBorder("选择词库"));
        WordStorePanel.this.setModel();		
	}
	
	////////////////////////////////////////////////////////
	///////////创建单词库的model
	public void setModel()
	{
		
		setCountModel();
	} 
	//////////////////////////////////////////////////////////////////
	//////////////

	
////////////////////////////////////////////////////////////////////////
///////////一个库里有多少组

/////////////////////////////////////////////////////
//////////// 单词组表
public void setCountModel()
	{
		
		
		String [] name = {""};
		
		for(int i = 0; i < 26;i++)
		{
			name[0] = (char)('A'+i )+ "词库";
			model2.insertRow(i,name);
		}
		table2.setModel(model2);
	    columnModel1.getColumn(0).setPreferredWidth(125);
	    table2.setColumnModel(columnModel1);
		
	}

///////////////////////////////////////////////////////////
/////////////////


	//////////////////////////////////////////////////
	////////////表监听
	class  tableListener implements FocusListener
	{
		JTable table;
		public void focusGained(FocusEvent e)
		{
			table = (JTable)e.getSource();
			table.addMouseListener(new MousePressListener());
			
		    mousePressCount = table.getSelectedRow();
		    		
			
			
		}
		
		 public void focusLost(FocusEvent e)
       {
         
         //getSelectName();
       }
       
       
       /////////////////////////////////////////
	///////鼠标监听
	class    MousePressListener extends MouseAdapter
	{
		
		public void mousePressed(MouseEvent e)
		{ 
			if(table == table1)
			  
			mousePressCount = table.getSelectedRow();
			else
			{
		    wordChooseCount =table.getSelectedRow();
		    ReadDat.row=wordChooseCount;
		    ReadDat.letter=""+((char)('A'+wordChooseCount));
			}
		}
			
	
	 }
           
	}
}

