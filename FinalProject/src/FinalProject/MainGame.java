/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FinalProject;

import FinalProject.actors.Window;
import FinalProject.ui.Game;



/**
 *
 * @author aduin
 */
public class MainGame {
    public static void main(String[] args) {
        Window window = new Window(0, 0, 500, 500);
        
        Game w = new Game();
        w.setWindow(window);
        window.setGraphicContainer(window);
        w.setSize(500, 500);
        w.setTitle("Eating Fishes Game");
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }
}
