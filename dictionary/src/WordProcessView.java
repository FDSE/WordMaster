import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.Timer;

import org.dom4j.DocumentException;


public class WordProcessView extends JPanel{
	 private ProcessModel process;
	private Timer activityMonitor;
	   private JButton startButton;
	   private JButton exitButton;
	   private JProgressBar progressBar;
	   private JCheckBox checkBox;
	   private JTextArea textArea;
	   private SimulatedActivity activity;
       private JLabel label;
       private JPanel labelpanel;
       private JPanel processpanel;
	WordProcessView(ProcessModel o)
	{
        process=o;
        labelpanel=new JPanel();
        processpanel=new JPanel();
		this.setLayout(new GridLayout(2,1));
		label=new JLabel();
		label.setText("开始设置初始单词...");
	    progressBar = new JProgressBar();
	    progressBar.setStringPainted(true);
	    progressBar.setMaximum(1000);
        activity = new SimulatedActivity(1000);
        String result=o.basemodel.judgeWhereToStart();
        ReadDat.result=result;
        new Thread(activity).start();
        activityMonitor = new Timer(500, new
                ActionListener()
                {
                   public void actionPerformed(ActionEvent event)
                   {
                      int current = activity.getCurrent();
                      progressBar.setStringPainted(!progressBar.isIndeterminate());
                      progressBar.setValue(current);

                      // check if task is completed
                      if (current == activity.getTarget())
                      {
                         activityMonitor.stop();
                         try {
							process.changeModel(5);
						} catch (DocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                      }
                      
                      else if (current>400)
                      {
                    	 
                    	  label.setText(ReadDat.result);
                        
                      }
                   }
                });
        activityMonitor.start();
        labelpanel.add(label);
        this.add(labelpanel);
        label.setOpaque(false);
        labelpanel.setOpaque(false);
        processpanel.add(progressBar);
        this.add(processpanel);
        progressBar.setOpaque(false);
        processpanel.setOpaque(false);
        this.setOpaque(false);
	}
}
class SimulatedActivity implements Runnable
{
   /**
      Constructs the simulated activity thread object. The
      thread increments a counter from 0 to a given target.
      @param t the target value of the counter.
   */
   public SimulatedActivity(int t)
   {
      current = 0;
      target = t;
   }

   public int getTarget()
   {
      return target;
   }

   public int getCurrent()
   {
      return current;
   }

   public void run()
   {
      try
      {
         while (current < target)
         {
            Thread.sleep(5);
            current++;
         }
      }
      catch(InterruptedException e)
      {
      }
   }

   private volatile int current;
   private int target;
}







