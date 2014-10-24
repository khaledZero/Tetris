/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import tetris.pieces.Case;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author zero
 */
public  abstract class Figure /*implements FigureInter*/  {
  private Figure fig_;
  private int etat_;
  
  public Figure(){
     //fig_=new L();
       etat_=0;
  }
  public int getEtat(){
      return etat_;
  }
  public void setEtat(int e){
      etat_=e;
  }
  public abstract JPanel afficheFigure();
    
  public abstract void deplacerGauche(Grille g);
  public abstract void deplacerDroite(Grille g);
  
  public abstract void descendre(Grille g) throws Exception;
  
  public abstract void rotate(Grille g);
  public abstract Case getCases(int i);   
}
