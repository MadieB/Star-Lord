package star.lord;


import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madison Barnes
 */
public class Hero extends Character {

     private int health;
     
    //Constructor
    public Hero(){
        super();
        health = 5;
    }
    
     public Hero(int x, int y, Color color, int size, String name){
        super(x,y,color,size,name);
        health = 5;
    }
     public Hero(int x, int y){
        super(x,y);
     }
    //Getters 
    public int getHealth(){
        return health;
    }
    
    //Public Methods
   
    public void collect(){
        
    }
    public void teleport(){
        
    }
    
    //Private Methods
    private void grow(){
       
    }
    private void canTeleport(int y, int x){
        /*if ( x > 0)
    {
        x = + 1;    
    }
    else if ( x < 1300)
    {
        x= - 1;
    }
    this.x = x + x;
    this.dx = dx + x;
        
        if ( y > 5)
    {
        y = - 1;    
    }
    else if ( y < -5)
    {
        y = + 1;
    }
    this.y = y + 1;
    this.dy = dy + y;*/
        }
    
}
