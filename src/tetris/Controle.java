/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import tetris.pieces.Z;
import tetris.pieces.L;
import tetris.pieces.T;
import tetris.pieces.L_retourné;
import tetris.pieces.Cube;
import tetris.pieces.Barre;
import tetris.pieces.S;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author zero
 */
public class Controle {
    public static int couleure_dalt=0;   
    
    public static void simul(Grille g){
        int nb_supp=g.getNbr_ligneSup();
        g.mise_ajourGrille();
        nb_supp=g.getNbr_ligneSup()-nb_supp;
        if((nb_supp<4)&&(nb_supp>=0)){
            //score= score + nbr de lignes supp * difficulté
            g.setScore(g.getScore()+nb_supp*g.getDifficulté());            
        }
        if(nb_supp>=4){
            //score= score + nbr de lignes supp * 10 * difficulté
            g.setScore(g.getScore()+10*nb_supp*g.getDifficulté());
        }
        if(g.getDifficulté()<=10){
        //difficulté= (|(difficulté+100)/100|)
        g.setDifficulté((int)((g.getNbr_ligneSup()+100)/100));
        }        
    }
   
    public static void simul_2(Grille g1,Grille g2, Figure fig2){        
        g1.mise_ajour2(g2,fig2);
    }   
    
    public static Figure newFigure(){
        Figure f;//=new L();
        int n=(int)(Math.random()*7);
       
         switch (n) {
            case 0:  f= new S();
                    break;
            case 1:  f = new L_retourné();
                     break;
            case 2:  f = new T();
                     break;
            case 3:  f = new Z();
                     break;
            case 4:  f = new Cube();
                     break;
            case 5:  f = new Barre();
                     break;
            default: f=new L();
                     break;
         }
       
        return f;
    } 
    
    public static int delay(Grille g){
        int delay;
        int diff =g.getDifficulté();
        switch (diff) {
            case 1:   delay=1000 ;
                    break;
            case 2:  delay =900 ;
                     break;
            case 3:  delay = 800;
                     break;
            case 4:  delay = 700;
                     break;
            case 5:  delay = 600;
                     break;
            case 6:  delay = 500;
                     break;
            case 7:  delay = 400;
                     break;
            case 8:  delay = 300;
                     break;
            case 9:  delay = 200;
                     break;
            default: delay= 100;
                     break;
         }
        return delay;
    }
    public static Figure cloneFigure(Figure fig){
        Figure fig_clone=null;
        if( (fig instanceof L)){
            fig_clone=new L();
        }
        if( fig instanceof L_retourné){
            fig_clone=new L_retourné(); 
        }
        if( fig instanceof T){
            fig_clone=new T();
        }
        if( fig instanceof Z){
            fig_clone=new Z();
        }
        if( fig instanceof S){
            fig_clone=new S();
        }
        if( fig instanceof Cube){
            fig_clone=new Cube();
        }
        if( fig instanceof Barre){
            fig_clone=new Barre();
        }
        for(int i=0; i<4; i++){
            fig_clone.getCases(i).setCouleur(fig.getCases(i).getCouleur());
        }
        return fig_clone;
    }
}
