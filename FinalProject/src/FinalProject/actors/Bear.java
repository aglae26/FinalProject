/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject.actors;

import gamebase.elements.Sprite;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author aduin
 */
public class Bear extends Sprite {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Atributos
    /**
     * WIDTH: Alto de la imagen.
     */
    public static final int B_WIDTH = 10;
    /**
     * HEIGHT: Ancho de la imagen.
     */
    public static final int B_HEIGHT = 10;
    /**
     * STEP_SIZE: Cantidad de pixeles a los que se mueve.
     */
    protected int STEP_SIZE = 5;
     /**
     * points: Contador de puntaje.
     */
    private int points;
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Método Constructor
    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width 
     */
     public Bear(int x, int y, int height, int width) {
        super(x, y, height, width);   
        this.points = 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos de Acceso
    public int getPoints() {
        return points;   
    }
    
    public void setPoints(int points) {     
        this.points = points;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos
    /*
     Permite el movimiento según la tecla presionada
    */
    public boolean move(int direction) {
        int px = x;
        int py = y;
        
        switch(direction) {
            case KeyEvent.VK_LEFT -> px -= STEP_SIZE;

            case KeyEvent.VK_RIGHT -> px += STEP_SIZE;
        }
    /*
     Verifica si está dentro de los límites del contenedor.
    */
        if(!isOutOfGraphicContainer(px, py, width, height)) {
            x = px;
            y = py;
    
            if(container != null){
                container.refresh();
                return true;
            } 
        }
        return false;   
        
    }
    /*
     Suma los puntos.
    */
    public void sumPoints(int points) {
        this.points += points;
    }
    /*
     Verifica si se realizó una colisión y suma puntos.
    */
    public void checkCollisionAndSumPoints(Sprite other, int points) {
        if (this.checkCollision(other)) {
            sumPoints(points);
        }
    }
     
      @Override
    public void paint (Graphics g) {
    ImageIcon oso = new ImageIcon(getClass().getResource("/home/aduin/NetBeansProjects/FinalProject/src/gamebase/images/bear.png"));
    g.drawImage(oso.getImage(),B_WIDTH,B_HEIGHT,100,100,null);
    g.fillRect(x, y, width, height);
    }
}
