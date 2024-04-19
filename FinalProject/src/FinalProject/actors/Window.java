/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject.actors;

import gamebase.elements.Sprite;
import gamebase.elements.SpriteContainer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author aduin
 */
public class Window extends SpriteContainer {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Atributos
    protected Bear bear;
    protected Fish fish;
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Método Constructor
    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width 
     */
    public Window (int x, int y, int height, int width) {
        
        super(x, y, height, width);
        this.setColor(Color.CYAN); // Establece el color del contenedor.
        bear = new Bear((width-Bear.B_WIDTH)/2, (height-Bear.B_HEIGHT),Bear.B_WIDTH, Bear.B_HEIGHT);  // Muestra el objeto en el centro de la parte inferior. 

        bear.setGraphicContainer(this); // Establece el contenedor de bear como el mismo contenedor.
        
        
    } 

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos
    /*
     Permite agregar peces en el contenedor
    */
    private void addFishes() {
   
        int nFishes = 4;
        int fishY = 50;

        for (int i = 0; i <= nFishes; i++) {
       
            int fishX = (int) (Math.random() * width);
            Fish fish = new Fish(fishX, fishY, Fish.F_WIDTH, Fish.F_HEIGHT);
        
            fish .setGraphicContainer(this);

            sprites.add(fish);
        
        }
    }
    
    /*
     Permite revisar si hay una colisión y elimina el objeto si la hay.
    */
    public void processFishesEaten(){
        for(int i=0; i<sprites.size(); i++) {
            if(sprites.get(i) instanceof Fish) {
                Fish fish = (Fish) sprites.get(i);
                
                if(bear.checkCollision(fish)) {
                        sprites.remove(fish);
                }
            }
        }
    }
    
    /*
     Permite el movimiento 
    */
    public void keyPressed(int code) {
        if(code == KeyEvent.VK_RIGHT | code == KeyEvent.VK_LEFT) {
            if(bear.move(code)) {
                processFishesEaten();
            }
        }      
    }
    
    @Override
    public void paint(Graphics g) {  
        g.setColor(color);
        g.fillRect(x, y, width, height);

        for(Sprite sprite : sprites) {
            sprite.paint(g);
        }
        
        //bear.paint(g);
    }
    
    @Override
    public void refresh() {
        if(container != null)
            container.refresh();
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }
}
