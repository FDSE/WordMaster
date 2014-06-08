import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;




public class WordStatisticPanel extends JPanel{
	PieDataset dataset;
	WordStatisticPanel(String letter) throws IOException
	{
		boolean find=false;
		String[] recordname;
		File f = new File("src/record/");
		recordname = f.list();
		int i;
		for (i=0;i<recordname.length;i++)
		{
			if (recordname[i].equals("record-"+letter+".txt"))
			{
				find=true;
			}
		}
		if (i==recordname.length)
			find=false;
		if (find)
		{
			int unrecite,right,wrong;
			String fileName;
			fileName ="src/record/record-"+letter+ ".txt";
			FileReader in = new FileReader(fileName);
			BufferedReader buf = new BufferedReader(in);
			String temp;
			temp=buf.readLine();
			
			temp=buf.readLine();
			
			temp=buf.readLine();
			unrecite=Integer.parseInt(temp);
			temp=buf.readLine();
			wrong=Integer.parseInt(temp);
			temp=buf.readLine();
			right=Integer.parseInt(temp);
			temp=buf.readLine();
			int sum=unrecite+wrong+right;
			
			
			
		DefaultPieDataset dataset1=new DefaultPieDataset();

		dataset1.setValue("未背过单词数", unrecite);
		dataset1.setValue("背错单词数", wrong);
		dataset1.setValue("背对单词数", right);
		dataset=dataset1;
		JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, false);
		PiePlot plot = (PiePlot) chart.getPlot();// 
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
		chart.setBorderPaint(Color.green);
		plot.setForegroundAlpha(1.0f);
		plot.setCircular(true);
		Font font = new Font("黑体", Font.CENTER_BASELINE, 20);
		PiePlot pplot = (PiePlot) chart.getPlot();

		pplot.setLabelFont(new Font("SimSun", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		Date date = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy年MM月dd日");

		TextTitle title = new TextTitle("截止" + sdf.format(date) + "空气质量状况分布图");
		chart.setTitle(title);
		title.setFont(font);
		FileOutputStream fos_jpg=new FileOutputStream("src/record/temp.jpg");
		ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 335, 260, null);
		fos_jpg.close();
        Image b=new ImageIcon("src/record/temp.jpg").getImage();
        
		ImagePanel impn=new ImagePanel(b);
        WordSetPanel a=new WordSetPanel();
        impn.add(a);
        a.setVisible(true);
		
		//ImagePanel impn=new ImagePanel(b);
		//WordSetPanel a=new WordSetPanel();
        //impn.add(a);
        //a.setVisible(false);
		this.add(impn);
		this.setOpaque(false);
		}
		else
		{
			Image b=new ImageIcon("src/image/1.jpg").getImage();
			ImagePanel impn=new ImagePanel(b);
	        WordSetPanel a=new WordSetPanel();
	        impn.add(a);
	        a.setVisible(true);
			
			//ImagePanel impn=new ImagePanel(b);
			//WordSetPanel a=new WordSetPanel();
	        //impn.add(a);
	        //a.setVisible(false);
			this.add(impn);
			this.setOpaque(false);
		}



	}

}
