
/**
 * A class for testing the creation of a GUI (not for being published, personal testing purposes)
 * 
 * @author Thomas Rosseel
 * @version January 2013
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;


public class Gui
{

 final HashMap<Integer,JTextField> textmap=new HashMap<Integer,JTextField>();
JFrame Frame1 = new JFrame("SUDOKU");
JPanel sudoku=new JPanel(new GridLayout(9,9));
JPanel sub=new JPanel(new BorderLayout());
JPanel info=new JPanel(new GridLayout(4,1));
JButton solvebutton = new JButton("SOLVE");
  JButton clearbutton = new JButton("CLEAR");

public Gui(){




        JMenuBar menuBar = new JMenuBar();
        
        // Add the menubar to the frame
        Frame1.setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem about = new JMenuItem("About");
        JMenuItem exit = new JMenuItem("Exit");

        about.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	 JOptionPane.showMessageDialog(null, "Application created by Thomas Rosseel \n \n All Right Reserved (c) 2013", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });  
        
        
        exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.exit(0);
            }
        });  

        aboutMenu.add(about);
        fileMenu.add(exit);
        
        

//define gridlayout




//create boxes


 
 
 //put boxes in grid
 
 

 
 
 for(int i=1;i<=81;i++){
     JTextField text = new JTextField(1);
     textmap.put(i,text);
    sudoku.add(text);
    
    }
    
  
    sub.add(solvebutton,BorderLayout.NORTH);

    
       sub.add(clearbutton,BorderLayout.EAST);
       
       
       
       
       solvebutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            		solve();
            }
        });      

   clearbutton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                clear();
            }
        });  
       
       
   sub.add(new JLabel("Copyright Thomas Rosseel (c) 2013"),BorderLayout.SOUTH);
   info.add(new JLabel("Application for solving sudokus"));
   info.add(new JLabel("please enter values from 1 to 9,"));
   info.add(new JLabel("other values will be seen by the application as empty cells"));
   info.add(new JLabel("This program works for the most sudokus, solution not guarenteed."));
   sub.add(info,BorderLayout.WEST);
 
Frame1.setLayout(new GridLayout(2,1));
   
   Frame1.add(sudoku);
  Frame1.add(sub);
   Frame1.setSize(800,800);
Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Frame1.setVisible(true);

}


private void solve(){
	
	int[] arraysudoku=new int[81];
	int[][] sudokumatrix=new int[9][9];
	int[][] solvedsudokumatrix=new int[9][9];
	for(int i=1;i<=81;i++){

		String text=textmap.get(i).getText();
		
		int textint=-1;
		try{
			 textint=Integer.parseInt(text);
			if(1>textint || 9<textint){
				textint=-1;
				
			}
			
			
		}catch(Exception e){
			textint=-1;
			
			
		}
		
		arraysudoku[i-1]=textint;

		}
	
	
	for(int j=0;j<=80;j++){
	sudokumatrix[(j-(j%9))/9][(j%9)]=arraysudoku[j];
	
	}
	solvedsudokumatrix=Solve.solve(sudokumatrix);
	
	
	for(int i=0;i<9;i++){
		for (int j=0;j<9;j++)  {
			textmap.get((i*9)+j+1).setText(Integer.toString(solvedsudokumatrix[i][j]));
			if(solvedsudokumatrix[i][j]==-1){
				textmap.get((i*9)+j+1).setText("");
				
			}
			
		}
		
		
	}
	

}

private void clear(){

for(int i=1;i<=81;i++){

textmap.get(i).setText("");

}

}



}
