/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamebase.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author aduin
 */
public abstract class Sprite {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Atributos
    /**
     * x: Posición en x.
     */
    protected int x;
    /**
     * y: Posición en y.
     */
    protected int y;
    /**
     * height: Altura.
     */
    protected int height;
    /**
     * width: Ancho.
     */
    protected int width;
    /**
     * color: Color.
     */
    protected Color color;
    /**
     * image: Imágenes.
     */
    protected ImageIcon image;
    /**
     * container: Contenedor del juego.
     */
    protected GraphicContainer container; 
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Método Constructor 
    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width 
     */
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos de Acceso
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public GraphicContainer getContainer() {
        return container;
    }

    public void setGraphicContainer(GraphicContainer gcontainer) {
        this.container = gcontainer;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos
    public boolean isOutOfGraphicContainer() {
        
        return isOutOfGraphicContainer(x, y, width, height);
    }
    
    public boolean isOutOfGraphicContainer(int x, int y, int width, int height) {
        
        if(container == null)
            return false;
        
        Rectangle bounds = container.getBoundaries();
        
        return !(x >= bounds.getX() &
                 y >= bounds.getY() &
                 x + width  <= bounds.getX() + bounds.getWidth() &
                 y + height <= bounds.getY() + bounds.getHeight());
    }
    
    public boolean checkCollision(Sprite other)
    {
     /**
     * Sobrepuesto en el eje x.
     */
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

    /**
     * Sobrepuesto en el eje y.
     */
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

    /**
     * Sobrepuesto en ambos ejes.
     */
        return collisionX && collisionY;        
    }

    public abstract void paint(Graphics g);
}
