/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view;
import tetris.pieces.Z;
import tetris.pieces.L;
import tetris.pieces.T;
import tetris.pieces.L_retourné;
import tetris.pieces.Cube;
import tetris.pieces.Barre;
import tetris.pieces.S;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import tetris.Figure;
/**
 *
 * @author zero
 */
public class PanneauFigure extends JPanel {
    private Figure figure_;
    
    public PanneauFigure(L f){
        figure_=f;
    }
    public PanneauFigure(L_retourné f){
        figure_=f;
    }
    public PanneauFigure(S f){
        figure_=f;
    }
    public PanneauFigure(Z f){
        figure_=f;
    }
    public PanneauFigure(T f){
        figure_=f;
    }
    public PanneauFigure(Barre f){
        figure_=f;
    }
    public PanneauFigure(Cube f){
        figure_=f;
    }
      
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Dimension taille =new Dimension(463,463);
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                    g.setColor(Color.white);
                    g.drawRect(i*25,j*25,25,25);           
                    g.setColor(Color.black);
                    g.fillRect(25*i+3,25*j+3,20,20);                                   
            }
        }
        
        if(figure_ instanceof L){
            g.setColor(((L)figure_).getCases(0).getCouleur());
            int i=1; int j=0;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L)figure_).getCases(1).getCouleur());
            i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L)figure_).getCases(2).getCouleur());
             i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L)figure_).getCases(3).getCouleur());
             i=2;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);            
        }
        
        if(figure_ instanceof L_retourné){
            g.setColor(((L_retourné)figure_).getCases(0).getCouleur());
            int i=2; int j=0;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L_retourné)figure_).getCases(1).getCouleur());
            i=2;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L_retourné)figure_).getCases(2).getCouleur());
             i=2;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((L_retourné)figure_).getCases(3).getCouleur());
             i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        if(figure_ instanceof T){
            g.setColor(((T)figure_).getCases(3).getCouleur());
            int i=1; int j=0;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((T)figure_).getCases(2).getCouleur());
            i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((T)figure_).getCases(1).getCouleur());
             i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((T)figure_).getCases(0).getCouleur());
             i=2;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        if(figure_ instanceof Z){
            g.setColor(((Z)figure_).getCases(3).getCouleur());
            int i=2; int j=0;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Z)figure_).getCases(2).getCouleur());
            i=2;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Z)figure_).getCases(1).getCouleur());
             i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Z)figure_).getCases(0).getCouleur());
             i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        if(figure_ instanceof S){
            g.setColor(((S)figure_).getCases(3).getCouleur());
            int i=1; int j=0;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((S)figure_).getCases(2).getCouleur());
            i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((S)figure_).getCases(1).getCouleur());
             i=2;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((S)figure_).getCases(0).getCouleur());
             i=2;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        if(figure_ instanceof Barre){
            g.setColor(((Barre)figure_).getCases(3).getCouleur());
            int i=1; int j=3;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Barre)figure_).getCases(2).getCouleur());
            i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Barre)figure_).getCases(1).getCouleur());
             i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Barre)figure_).getCases(0).getCouleur());
             i=1;  j=0;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        if(figure_ instanceof Cube){
            g.setColor(((Cube)figure_).getCases(3).getCouleur());
            int i=2; int j=1;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Cube)figure_).getCases(2).getCouleur());
            i=2;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Cube)figure_).getCases(1).getCouleur());
             i=1;  j=2;
            g.fillRect(25*i+3,25*j+3,20,20);
            g.setColor(((Cube)figure_).getCases(0).getCouleur());
             i=1;  j=1;
            g.fillRect(25*i+3,25*j+3,20,20); 
        }
        
        
        
        
                    
    }
}
