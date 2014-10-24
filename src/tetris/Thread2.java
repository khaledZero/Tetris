/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import tetris.view.JouerA2;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author zero
 */
public class Thread2 extends Thread implements KeyListener {
    private Timer timer_1;    
    private Figure fig_;
    private Figure fig_next;
    private JPanel pan_next_fig;
    private JPanel pan_grille_;
    private JLabel jLabel_1;
    private JLabel jLabel_2;
    private Grille grille_;
    private Grille grille_2;
    private int delai_=1000;
    private JPanel pan_figure_;
    private JPanel jPanel4;
    private Thread1 thread_1;
    private JouerA2 f2_;
    private JPanel option_;
    private int i_figure=0;
    
public Thread2(JPanel pan_g, JPanel pan_fig,JLabel jl,Thread1 th1,
        Grille g1, Grille g2, JouerA2 f2, JPanel op){
        option_=op;
        f2_=f2;
        thread_1=th1;
        //affichage de la grille
        jLabel_1=jl;
        grille_=g1;
        grille_2=g2;
        pan_grille_=grille_.afficheGrille();
        pan_grille_.setBounds(0,0,251,551);       
        pan_g.add(pan_grille_);
        pan_grille_.setBackground(Color.black);
        fig_=Controle.cloneFigure(
                     (Figure)f2.getListe_fig().get(i_figure));
        //next figure
        if(f2_.getListe_fig().size()==i_figure+1){
            f2_.getListe_fig().add(Controle.newFigure());
             fig_next=Controle.cloneFigure(
                     (Figure)f2.getListe_fig().get(i_figure+1));
             i_figure=i_figure+1;
             
        }
        else{
             fig_next=Controle.cloneFigure(
                     (Figure)f2.getListe_fig().get(i_figure+1));
             i_figure=i_figure+1;
        }
        
        pan_figure_=fig_next.afficheFigure();
        pan_fig.add(pan_figure_);
        pan_next_fig=pan_fig;
        pan_figure_.repaint();
        pan_figure_.setBounds(0,0,101,101);
        pan_figure_.setBackground(Color.black);
}
public Timer getTimer(){
        return timer_1;
    }
public void setLabel(String s){
    jLabel_1.setVisible(true);
    jLabel_1.setText(s);
}
public Grille getGrille(){
    return grille_;
}
public Figure getFigure(){
    return fig_;
}
public void run(){
    
timer_1 = new Timer(delai_, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
//Inserer ici le code a repeter
        try{
    fig_.descendre(grille_);
   
    }
    catch (Exception ex) {
        
        if((grille_.lireGrille(4, 0)!=null)
                    ||(grille_.lireGrille(5, 0)!=null)){
            
                jLabel_1.setVisible(true);                
                //affichage_.setVisible(false);
                jLabel_1.setText("GAME OVER");
                pan_grille_.add(jLabel_1);
                pan_grille_.repaint();
                //affichage_.setEnabled(true);
                timer_1.stop();
                f2_.getThread1().getTimer().stop();
                f2_.getThread1().setLabel("YOU ARE THE WINNER");
                //System.out.println("je suis là");
                f2_.getBtn().setVisible(true);
                return;
                }           
            //timer.stop();
            Controle.simul_2(grille_,grille_2,f2_.getThread1().getFigure());
            //Controle.simul(grille_);
            delai_=Controle.delay(grille_);
            timer_1.setDelay(delai_);
                       
            pan_grille_.repaint();            
            fig_=fig_next;
             if(f2_.getListe_fig().size()==i_figure+1){
             f2_.getListe_fig().add(Controle.newFigure());
             fig_next=Controle.cloneFigure(
                     (Figure)f2_.getListe_fig().get(i_figure+1));
             i_figure=i_figure+1;
             
            }
            else{
             fig_next=Controle.cloneFigure(
                     (Figure)f2_.getListe_fig().get(i_figure+1));
             i_figure=i_figure+1;
            }           
                 
                pan_figure_=fig_next.afficheFigure();                
                //jPanel3.add(affichage_fig);
                pan_next_fig.add(pan_figure_);
                pan_figure_.repaint();
                pan_figure_.setBounds(0,0,101,101);
                pan_figure_.setBackground(Color.black);
                
                
            }
    finally{        
         pan_grille_.repaint();
        //System.out.println("finaly:   "+fig_+"   "+test);
        }               
            }});
timer_1.start();
}

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {timer_1.setDelay(50);}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(timer_1.isRunning()){
         if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {fig_.deplacerGauche(grille_);
             pan_grille_.repaint();}
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
          fig_.deplacerDroite(grille_);
            pan_grille_.repaint();
        }
         else if(e.getKeyCode()==KeyEvent.VK_UP)
        {
          fig_.rotate(grille_);
            pan_grille_.repaint();
        }
         else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {timer_1.setDelay(delai_);}         
        }
    }
    
}
