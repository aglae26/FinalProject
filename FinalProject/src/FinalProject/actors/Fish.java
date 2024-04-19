/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject.actors;

import gamebase.elements.SpriteMobile;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author aduin
 */
public class Fish extends SpriteMobile {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Atributos
    /**
     * WIDTH: Alto de la imagen.
     */
    public static final int F_WIDTH = 10;
    /**
     * HEIGHT: Ancho de la imagen.
     */
    public static final int F_HEIGHT = 10;
    /**
     * STEP_SIZE: Cantidad de pixeles a los que se mueve.
     */
    protected int STEP_SIZE = 2;
    /**
     * Timer: Temporizador que genera eventos.
     */
    private Timer timer;
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Método Constructor
    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width 
     */
    public Fish (int x, int y, int height, int width) {
            super(x, y, height, width);
            setStep(STEP_SIZE);
            
            timer = new Timer(100, (ActionListener) this); // Genera eventos cada 100 milisegundos.
            timer.start(); // Inicializa el temporizador.
    }
    
       @Override
    public void paint (Graphics g) {
    ImageIcon pez = new ImageIcon(getClass().getResource("/home/aduin/NetBeansProjects/FinalProject/src/gamebase/images/fish.png"));
    g.drawImage(pez.getImage(),F_WIDTH,F_HEIGHT,100,100,null);
    g.fillRect(x, y, width, height);
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos
    /*
     Llama el método swimDown.
    */
    public void actionPerformed(ActionEvent e) {
        swimDown();
    }
    /*
     Permite el movimiento del pez hacia abajo
    */
    private void swimDown() {
        int newY = getY() + getStep();
        setY(newY);
        
        if (this.isOutOfGraphicContainer() == true){
            System.out.println("GAME OVER");     
        } else {
            if (getContainer() != null) {
                getContainer().refresh();
            }  
            if (this.isOutOfGraphicContainer() == false){
                setY(-getHeight());
            }
        }
        
    }
    
   
}
  
