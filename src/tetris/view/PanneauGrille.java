/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import tetris.Grille;
/**
 *
 * @author zero
 */
public class PanneauGrille extends JPanel {
    private Grille grille_;
    public PanneauGrille(Grille g){
        grille_=g;
    }
     
    @Override    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Dimension taille =new Dimension(463,463);
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 22; j++) {
                    g.setColor(Color.white);
                    g.drawRect(i*25,j*25,25,25);
                    //g.setColor(Color.red);
                    //g.fillRect(25*i+3,25*j+3,20,20);
                    if(grille_.lireGrille(i,j)==null){
                      g.setColor(Color.black);
                      g.fillRect(25*i+3,25*j+3,20,20); 
                    }
                    else{
                      g.setColor(grille_.lireGrille(i,j));
                      g.fillRect(25*i+3,25*j+3,20,20);
                    }
                    
                           
            }
        }
    }
}
