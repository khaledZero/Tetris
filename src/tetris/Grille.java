/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import tetris.view.PanneauGrille;
import tetris.pieces.Case;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author zero
 */
public class Grille {
    private int score_;
    private int taille_;
    private int difficulté_;
    private int nbr_ligneSup;
    private Case [][]grille_;
    
    public Grille(){
        difficulté_=1;
        nbr_ligneSup=0;
        score_=0;
        taille_=22;
        grille_= new Case [10][22];       
    }
    public Case lire_case_Grille(int i, int j){
        return grille_[i][j];
    }
    
    public Color lireGrille(int i, int j){
        if(grille_[i][j]==null) return null;
        else return grille_[i][j].getCouleur();
    }
    public JPanel afficheGrille(){
        PanneauGrille pan= new PanneauGrille(this);
        return pan;
    }
    
    
    public void setGrille(Case c, int i,int j){
        grille_[i][j]=c;
    }
    public void setScore(int n){
        score_=n;
    }
    public int getScore(){
        return score_;
    }
    public void setDifficulté(int n){
        difficulté_=n;
    }
    public int getDifficulté(){
        return difficulté_;
    }
    public void setTaille(int t){
        taille_=t;
    }
    public int getTaille(){
        return taille_;
    }
    public void setNbr_ligneSup(int t){
        nbr_ligneSup=t;
    }
    public int getNbr_ligneSup(){
        return nbr_ligneSup;
    }
    
    public void mise_ajourGrille(){        
        for(int j=0; j<22; j++){
            int n=0;
            for(int i=0; i<10; i++){                
                if(this.lireGrille(i, j)!=null) n++;
                if(n==10){
                    this.supp_ligne(j);
                    nbr_ligneSup++;
                    this.mise_ajourGrille();
                }               
            }            
        }
    }
    public void supp_ligne(int j){
        for(int i=0; i<10; i++){
            this.setGrille(null, i, j);
        }
        if(j>0){
            for(int i=0; i<10; i++){
                for(int k=j; k>0; k--){
                this.setGrille(this.lire_case_Grille(i, k-1), i, k);
                }
            }
        }
    }
    
    public void mise_ajour2(Grille g2, Figure fig2){        
        for(int j=0; j<taille_; j++){
            int n=0;
            int nc=0;
            boolean mm_c=false;
            Color c=null;
            for(int i=0; i<10; i++){
                c=this.lireGrille(i, j);
                if(i<9){
                    if((c!=null)&&(c.equals(this.lireGrille(i+1,j)))){
                        nc++;
                        if(nc==4)mm_c=true; 
                    }
                    else{
                        nc=0;
                    }
                }
                
                
                if(this.lireGrille(i, j)!=null) n++;
                
                if(n==10){
                    if(mm_c){
                        for(int ii=0;ii<10;ii++){
                            for(int jj=0;jj<g2.taille_-1;jj++){
                                if(!(((ii==fig2.getCases(0).getX())&&(jj+1==fig2.getCases(0).getY()))
                                        ||((ii==fig2.getCases(1).getX())&&(jj+1==fig2.getCases(1).getY()))
                                        ||((ii==fig2.getCases(2).getX())&&(jj+1==fig2.getCases(2).getY()))
                                        ||((ii==fig2.getCases(3).getX())&&(jj+1==fig2.getCases(3).getY())))){                                    
                                g2.setGrille(g2.lire_case_Grille(ii, jj+1), ii, jj);
                                }
                            }
                        }
                        for(int ii=0;ii<10;ii++){
                            g2.setGrille(this.lire_case_Grille(ii, j), ii, g2.taille_-1);
                        }
                        g2.taille_=g2.taille_-1;
                    }
                    this.supp_ligne(j);                    
                    //this.mise_ajour2(g2, fig2);
                }               
            }            
        }
    }
    
}
