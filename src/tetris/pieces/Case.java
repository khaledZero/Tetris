/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.pieces;

import java.awt.Color;
import tetris.Controle;

/**
 *
 * @author zero
 */
public class Case {
    private int x_;
    private int y_;
    private Color couleur_;
    public Case(int x, int y){
        x_=x;
        y_=y;
       //Min + (int)(Math.random() * ((Max - Min) + 1))
        int n=  (int)(Math.random()*5);
        if(Controle.couleure_dalt==0){
        if(n==0) couleur_=Color.green;
        if(n==1) couleur_=Color.blue;
        //if(n==1) couleur_=Color.green;
        if(n==2) couleur_=Color.red;
        //if(n==2) couleur_=Color.green;
        //if(n==3) couleur_=Color.yellow;
        if(n==3) couleur_=Color.green;
        //if(n==4) couleur_=new Color(200, 30, 240);//violet
        if(n==4) couleur_=Color.green;
        }
        else if(Controle.couleure_dalt==1){
            if(n==0) couleur_=Color.green;
            if(n==1) couleur_=new Color(95,158,160);// Cadet Blue
            if(n==2) couleur_=new Color(105,105,105);//Dim Gray
            if(n==3) couleur_=Color.yellow;
            if(n==4) couleur_=new Color(205,200,177);//Cornsilk 3
        }
    }
    public int getX(){
        return x_;
    }
    public int getY(){
        return y_;
    }
    public Color getCouleur(){
        return couleur_;
    }
    public void setCouleur(Color r){
        couleur_=r;
    }
    public void setX(int x){
        x_=x;
    }
    public void setY(int y){
        y_=y;
    }
}
