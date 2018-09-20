/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.lord;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Madison Barnes
 */
public class Space extends JPanel{
    
    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;
    
    /**
     *
     */
    public Space() {
        super();
        marginX = 10;
        marginY = 10; 
        hero = new Hero(600, 480, Color.GREEN, 20, "Peter Quill");
        enemy = new Enemy(400, 400,Color.DARK_GRAY, 20,"Thanos");
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/17);
        
    }

   
    private class ScheduleTask extends TimerTask{
        
    @Override
   public void run(){
     wallCollisions(hero);
     wallCollisions(enemy);
     heroVsEnemy();
      hero.update();
       enemy.update();
       
       repaint();
   }
    }
   public void keyPressed(KeyEvent e) {
      
       if (e.getKeyCode() == KeyEvent.VK_W){
           hero.setDY(-1);
       }
        else if (e.getKeyCode() == KeyEvent.VK_A){
           hero.setDX(-1);
       }
        else if (e.getKeyCode() == KeyEvent.VK_S){
           hero.setDY(1);
       }
       else if (e.getKeyCode() == KeyEvent.VK_D){
           hero.setDX(1);
       }
   }
    public void keyReleased(KeyEvent e){
       if  (e.getKeyCode() == KeyEvent.VK_W)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_A)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_S)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_D)
            hero.setDX(0);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        g.setColor(Color.WHITE);
        drawStars(g);
        g.setColor(Color.BLUE);
        drawStars(g);
        g.setColor(Color.MAGENTA);
        drawStars(g);
        g.setColor(Color.CYAN);
        drawStars(g);
        g.setColor(Color.YELLOW);
        drawStars(g);
        g.setColor(Color.GRAY);
        drawStars(g);
        g.setColor(Color.PINK);
        drawStars(g);
       g.setColor(Color.LIGHT_GRAY);
        drawStars(g);
        g.setColor(Color.RED);
        drawStars(g);
        g.setColor(Color.ORANGE);
        drawStars(g);
        hero.draw(g);
        enemy.draw(g);
          //g.dispose();
    }
        
    private void drawStars(Graphics g){
    /*int x = (int) (Math.random()*1200);
    int y = (int) (Math.random()*960);
    int rand1 = (int)(Math.random()*15);
    int rand2 = (int) (Math.random()*15);
        for(int i = 0; i <500; i++){
            x += marginX;
            y += marginY;
            g.fillOval(x,y,rand1,rand2);
            System.out.println(x+" "+y);*/
        int x = 0;
        int y = 0;
    for (int i = 0; i < 1000; i++) {
          y = (int) (Math.random()*960);
          x = (int) (Math.random()*1300);
          Color curr = g.getColor();
          if (x % 2 == 0) 
              g.setColor(curr.brighter());
          else
              g.setColor(curr.darker());
          g.fillOval(x, y, 3, 3);
          
         
           //if (x > 1100 || y > 860){
             //break;
            //}     
        }
    }
    
    private void heroVsEnemy(){
        //variables need: hero needs to know enemies info (location & size)
        //where the enemy is - enemy.getX(), enemy.getY()
        //has enemy and hero collided with one another
        if (hero.getX() + hero.getSize()  == enemy.getX() && hero.getY() + hero.getSize() == enemy.getY() ){
        hero.kill(enemy);
        enemy.setX(-2000);
        }
    }
     
    private void wallCollisions(Character c) {
        //walls - this.getWidth(), this.getHeight(), 
        //where the hero is - hero.getX(), hero.getY()
        if (c.getX() <= 0 || c.getX() + 20 >= this.getWidth()){
            c.reverseX();
        }
        if (c.getY() <= 0 || c.getY() + 20 >= this.getHeight()){
            c.reverseY();
        }
    }
    
}
