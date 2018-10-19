/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.lord;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Madison Barnes
 */
public class Character {
    //Fields (Variables)
    private int x;
    private int y;
    private int dx;//velocity speed delta x
    private int dy; //velocity speed delta y
    private Color color;
    private int size;
    private String name;
    
    
    //Constructor
    public Character(){
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        color = Color.BLACK;
        size = 20;
        name = "enemy";
    }
    
     public Character(int x, int y, Color color, int size, String name){
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.name = name;
        dx = 0;
        dy = 0;
        
    }
     public Character(int x, int y){
        this.x = x;
        this.y = y;
        color = color;
        size = size;
        name = name;
        
     }
    //Getters 
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Color getColor(){
        return color;
    }
    public int getSize(){
        return size;
    }
    public String getName(){
        return name;
    }
    
    
    //Setters
    public void setX(int x){
    this.x = x;
}
    public void setY(int y){
        this.y = y;
}
    public void setDX(int dx){
    this.dx = dx;
}
    public void setDY(int dy){
        this.dy = dx;
}
    public void setColor (Color color){
        this.color = color;
    }
    public void setSize (int size){
        this.size = size;
    }
    public void setName (String name){
        this.name = name;
    }

    //Public Methods
   public void draw(Graphics g){
       g.setColor(color);
       g.fillRect(x,y,size,size);
   }
    
    public void kill(Character c){
        c.setSize(0);
        /*grow();*/
        System.out.println("Enemy Killed");
    }
    public void move(int dx, int dy){
        x += dx * 5;
        y += dy * 5;    
    }
    public void update(){
        move(dx,dy);
        
    }
   
  
    public void reverseX(){
        
        dx = - dx;
        move(2 * dx, dy);
    }
    
    public void reverseY(){
        
         dy *= -1;
         move(dx, 2 * dy);
    }
    //Private Methods
    private void grow(){
       size += 1;
         y *= -1;
    }
    
}
