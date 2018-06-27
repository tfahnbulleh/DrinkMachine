/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Sale 
{
    private final String[] DrinksName;
    private LinkedList<Drink> Drinks;
    private boolean IsSaleSuccess;
    private double Change;
    private String Message;
    private final double PRICE=0.75;
    
    //constructor
    public Sale()
    {
        //name of drinks 
        this.DrinksName = new String[]{"Cola","Lemon Lime Soda","Grape Soda","Root Beer","Bottled Water"};
        this.Drinks=new LinkedList<>(); //drink list
        InitializedDrinkLists();//method call to initialize drink list
    }

    //return the value of Price
    public double getPRICE() 
    {
        return PRICE;
    }
    
    /**
     return the value of Message
     *method should be call after each sale
     * 
     * @return
     */
    public String getMessage() 
    {
        return Message;
    }

    /**
     determine if Sale is successful
     
     * @return
     */
    public boolean getIsSaleSucess() 
    {
        return this.IsSaleSuccess;
    }
     
    /**
     get the value of Change 
     method must be call after Making a sale
     * @return
     */
    public double getChange() 
    {
        return Change;
    }
    
    /**
     get the name of all drinks available
     * @return
     */
    public String[] getDrinksName() 
    {
        return DrinksName;
    }
    
    //get the amount of drink available
    //the drink name must be pass as argument during method call
    private int getDrinkQuantity(String name)
    {
        int quantity=0; //initialize quantity
        
        //iterate Drinks 
        //if the each drink name is the same as name, increase quantity by one
        for(Drink drink:this.Drinks) 
        {
            if (drink.getName().equalsIgnoreCase(name))
            {
                quantity+=1;
            }
        }
        return quantity;
    }
    
    //initialized DrinkList
    //Each drink name will have ten drinks
    private void InitializedDrinkLists()
    {
       
        for(String name:this.DrinksName)
        {
            for (int i = 0; i < 10; i++) 
            {
                this.Drinks.add(new Drink(name,this.PRICE));
            }
        }       
    }
    
    //method to make sale
    //the drink name and the amount the user is paying must be pass as argument
    public void makeSale(String name,double amount)
    {
        if (this.getDrinkQuantity(name)<1) //check if the amount of drink left in stock is less than one
        {
            this.IsSaleSuccess=false;
            this.Message=name+" is not available";
        }
     
        //the amount of drink in stock is more than one
        else
        {
            for (int i = 0; i <this.Drinks.size(); i++) //iterate throug Drink
            {
                if (this.Drinks.get(i).getName().equalsIgnoreCase(name)) //the vale of name equals the value of Drink[i].name
                {
                    //validate if the value of amount is less than the price of the drink
                    if (amount<Drinks.get(i).getPrice().doubleValue())  
                    {
                        this.IsSaleSuccess=false; //set the value of IsSaleSuccess
                        this.Message="Insufficient fund"; //set the value of message
                    }
                    
                    //the value of amount is not less than the drink price
                    else
                    {
                        this.Drinks.remove(i); //remove item from drink from the array
                        this.Change=amount-this.Drinks.get(i).getPrice().doubleValue(); //calcualte the change
                        this.IsSaleSuccess=true; //set the value of IsSaleSuccess
                        this.Message="Success"; //set the value of message
                    }
                    break; //break out of the loop
                }
            }
        }
    }//end of makeSale method
    
}
