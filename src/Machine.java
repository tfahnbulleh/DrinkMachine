
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Machine {
    
    private static Sale Sale;
    private JButton[] MachineControls; 
    private static JTextField UserInput;
   
    public Machine()
    {
       
        Machine.Sale=new Sale();
        this.MachineControls=new JButton[5];
        for (int i = 0; i < Machine.Sale.getDrinksName().length; i++) 
        {
            JButton button=new JButton(Machine.Sale.getDrinksName()[i]);
            MachineControls[i]=button;
        } 
        
    }
    
    public JButton[] getMachineControl()
    {
        return this.MachineControls;
    }
    
    public void buildMachine(JApplet applet)
    {
        JPanel panel=new JPanel(); //new JPanel
        applet.setSize(500,500);//set the size of applet
        panel.setPreferredSize(new Dimension(200,applet.getHeight()-100));//set the prefered size of panel
        applet.setLayout(new BorderLayout());//set the layout of applet to BorderLayout
        
        //for each item in DrinkNames array,
        //create new JButton control
        //set the action listener of the button
        //set the preferred size of the button
        //add the button to panel
        for(String text:Machine.Sale.getDrinksName()) 
        {
           JButton button=new JButton(text);
           button.addActionListener(new ButtonListener());                    
           button.setPreferredSize(new Dimension(190,90));
           panel.add(button);         
        }   
                
        
          JLabel label=new JLabel("Soft Drinks "+Machine.Sale.getPRICE());//new JLabel control
          label.setFont(new java.awt.Font("Times New Roman", 1, 18)); //set the font type, size,and style of the label
          applet.add(label,BorderLayout.CENTER); //
          applet.add(panel,BorderLayout.EAST);//add panel to appletusing BorderLayout
          
          
          JPanel bottomPanel =new JPanel(); //new JPanel container
          bottomPanel.add(new JLabel("Enter the amount tendered"));//add label to bottomPanel
          UserInput=new JTextField();//new JTextField control
          UserInput.setPreferredSize(new Dimension(200,30));//set the prefered size of userInput control
          bottomPanel.add(UserInput); //add userInput control to bottomPanel
          applet.add(bottomPanel,BorderLayout.SOUTH); //add bottomPanel to applet
    }

    private static class ButtonListener implements ActionListener {

        public ButtonListener() 
        {
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
           
            double input;//user input 
           
            try
            {
                input=Double.parseDouble(UserInput.getText()); //convert user input to double
            }
            
            //failed to convert to doble catch numberFormatException
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Invalid data error. A valid number is required");
                return;
            }
            
            //the amount the user input is less than the amount for the drink
            if (input<Machine.Sale.getPRICE()) 
            {
                JOptionPane.showMessageDialog(null,"Insufficient fund. Each drink cost "+Machine.Sale.getPRICE());
            }
            
            //the amount the user input is more or equal to the amount for the drink
            else
            {
                String drinkName=((JButton)e.getSource()).getText(); //get the name of the drink from the event sender
                int messageResult=JOptionPane.showConfirmDialog(null,"Are you sure you want to purchase "+drinkName+"?","Confirm Purchase",JOptionPane.YES_NO_OPTION);
                
                if (messageResult==JOptionPane.YES_OPTION) 
                {
                    Machine.Sale.makeSale(drinkName,input); //method call to make sale
                
                    if (Machine.Sale.getMessage().equalsIgnoreCase("Success"))  //sale is successful
                    {
                       JOptionPane.showMessageDialog(null,"Success! Take your drink. Your change is "+Machine.Sale.getChange());
                       UserInput.setText("");
                    }
                
                  //sale is not successful
                    else
                    {
                        JOptionPane.showMessageDialog(null,Machine.Sale.getMessage());
                        UserInput.setText("");
                    }
                }
                else
                {
                
                }
                
            }
            
        }
    }
  
    
}
