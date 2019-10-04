package ui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DoorlockLayout extends JFrame {
	
	public DoorlockLayout() throws HeadlessException {
		super("MyDoorlock!!!");
		super.setLayout(new GridLayout(2, 1));
		JPanel showPanel = new JPanel();
		JTextField screen = new JTextField("", 15);
		JLabel image = new JLabel();
		
		screen.setEditable(false);
	
		showPanel.add(screen);
		showPanel.add(image);
		showPanel.add(new JButton("1231231"));
		
		add(showPanel);
		
		
		JPanel digitPanel = new JPanel();
		
		List <JButton> buttonList = new ArrayList <JButton>();
		
		buttonList.add(new JButton("1"));
		buttonList.add(new JButton("2"));
		buttonList.add(new JButton("3"));
		buttonList.add(new JButton("4"));
		buttonList.add(new JButton("5"));
		buttonList.add(new JButton("6"));
		buttonList.add(new JButton("7"));
		buttonList.add(new JButton("8"));
		buttonList.add(new JButton("9"));
		buttonList.add(new JButton("*"));
		buttonList.add(new JButton("0"));
		buttonList.add(new JButton("#"));
		
	    digitPanel.setLayout(new GridLayout(4, 3));
	    
	    for (JButton btn :buttonList) {
	    	digitPanel.add(btn);
	    }
	    
	    for (JButton btn :buttonList) {
	    	btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (btn.getText().equals("#")) {
						screen.setText("");
						return;
					}					
					System.out.println("버튼눌러짐~!:" + btn.getText());
					screen.setText(screen.getText() + btn.getText());
				}
		    });
	    }
	    

	    
		add(digitPanel);
		
		super.setSize(300, 400);
		super.setVisible(true);
		// x 버튼 활성화 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //process - 여러개의 thread를 가질 수 있다.
        //call back method == Listener (call back method 집합의 인터페이스)
	}
	
		
	  public static void main(String[] args) { 
	        new DoorlockLayout(); 
	   } 
	   
}
