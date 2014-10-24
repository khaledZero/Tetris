package tetris.view;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import tetris.Controle;
import tetris.Grille;


public class JCheckBoxListener implements ActionListener {
    private Grille grille_;
    private JPanel affichage_;
    private Grille grille_2;
    private JPanel affichage_2;
    private JCheckBox jCheckBox1;
    
    public JCheckBoxListener(Grille g, JPanel aff, JCheckBox jCheck){
        grille_=g;
        affichage_=aff;
        jCheckBox1= jCheck;
    }
   
    public void actionPerformed(ActionEvent e) {
        Color violet=new Color(200, 30, 240);
        Color blueCadet= new Color(95,158,160);// Cadet Blue
        Color gryDim=new Color(105,105,105);//Dim Gray
        Color cornsilk=new Color(205,200,177);//Cornsilk 3
       if(jCheckBox1.isSelected()){
    Controle.couleure_dalt=1;
    for(int i=0;i<10;i++){        
        for(int j=0;j<22;j++){
            if(grille_.lireGrille(i, j)!=null){
            if(grille_.lireGrille(i, j)==Color.BLUE){
               grille_.lire_case_Grille(i, j).setCouleur(new Color(95,158,160));
            }
            
            if(grille_.lireGrille(i, j)==Color.RED){
              grille_.lire_case_Grille(i, j).setCouleur(new Color(105,105,105));
            }
           
            if(grille_.lireGrille(i, j).equals(violet)){
              grille_.lire_case_Grille(i, j).setCouleur(new Color(205,200,177));
            }
            
        } 
        }
            //repaint les figures
        
        /* for(i=0;i<4;i++){
               /*if(fig_.getCases(i).getCouleur()==Color.BLUE){
                   fig_.getCases(i).setCouleur(new Color(95,158,160));
                }
                if(fig_.getCases(i).getCouleur()==Color.RED){
                  fig_.getCases(i).setCouleur(new Color(105,105,105));
                }
                if(fig_.getCases(i).getCouleur()==violet){
                  fig_.getCases(i).setCouleur(new Color(205,200,177));
                }
                if(fig_next_.getCases(i).getCouleur()==Color.BLUE){
                   fig_next_.getCases(i).setCouleur(new Color(95,158,160));
                }
                if(fig_next_.getCases(i).getCouleur()==Color.RED){
                  fig_next_.getCases(i).setCouleur(new Color(105,105,105));
                }
                if(fig_next_.getCases(i).getCouleur()==violet){
                  fig_next_.getCases(i).setCouleur(new Color(205,200,177));
                }
            }*/
    //affichage_fig.repaint();
    affichage_.repaint();    
    }
       } 
    else{
        Controle.couleure_dalt=0;
    for(int i=0;i<10;i++){
        for(int j=0;j<22;j++){
            if(grille_.lireGrille(i, j)!=null){
            if(grille_.lireGrille(i, j).equals(blueCadet)){
               grille_.lire_case_Grille(i, j).setCouleur(Color.BLUE);
            }
            
            if(grille_.lireGrille(i, j).equals(gryDim)){
              grille_.lire_case_Grille(i, j).setCouleur(Color.RED);
            }
            
            if(grille_.lireGrille(i, j).equals(cornsilk)){
              grille_.lire_case_Grille(i, j).setCouleur(new Color(200, 30, 240));
            }
            
        }
        }
    }
    affichage_.repaint();    
    }
    }
}