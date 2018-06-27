
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Drink 
{
    //instance variables
    private final String Name; //drink name
    private final BigDecimal Price; //drink price
   
    
    //constructor
    public Drink(String name, BigDecimal price)
    {
      this.Price=price.setScale(2,RoundingMode.HALF_EVEN);
      this.Name=name;
    }
    
    public Drink(String name, double price)
    {
        this.Price=BigDecimal.valueOf(price).setScale(2,RoundingMode.HALF_EVEN);
        this.Name=name;
    }
    //return drink name
    public String getName() 
    {
        return Name;
    }

    //return drink price
    public BigDecimal getPrice() 
    {
        return Price;
    }
    
    
}
