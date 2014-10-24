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
public class Thread1 extends Thread implements KeyListener {
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
    private Thread2 thread_2;
    private JPanel option_;
    private int i_figure=0;
    private JouerA2 f2_;
    private JFrame j;
    
    
public Thread1(JPanel pan_g, JPanel pan_fig,JLabel jl, 
        Thread2 th2,Grille g1, Grille g2,JouerA2 f2, JPanel op){
        f2_=f2;
        option_=op;
        thread_2=th2;
        //affichage de la grille
        jLabel_1=jl;
        grille_=g1;
        grille_2=g2;
        pan_grille_=grille_.afficheGrille();
        pan_grille_.setBounds(0,0,251,551);       
        pan_g.add(pan_grille_);
        pan_grille_.setBackground(Color.black);
        fig_=Controle.cloneFigure((Figure)f2.getListe_fig().get(i_figure));
        //next figure
        pan_next_fig=pan_fig;
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
        pan_next_fig.add(pan_figure_);
        pan_figure_.repaint();
        pan_figure_.setBounds(0,0,101,101);
        pan_figure_.setBackground(Color.black);
        
        //j=f2_.getFrame();
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
                thread_2.getTimer().stop();
                thread_2.setLabel("YOU ARE THE WINNER");
                //System.out.println("je suis là");
                f2_.getBtn().setVisible(true);
                return;
                }           
            //timer.stop();
            //Controle.simul_2(grille_,grille_2);
             Controle.simul_2(grille_,grille_2,f2_.getThread2().getFigure());
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
        if(e.getKeyCode()==KeyEvent.VK_D)
        {timer_1.setDelay(50);}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(timer_1.isRunning()){
         if(e.getKeyCode()==KeyEvent.VK_S)
        {fig_.deplacerGauche(grille_);
             pan_grille_.repaint();}
         else if(e.getKeyCode()==KeyEvent.VK_F)
        {
          fig_.deplacerDroite(grille_);
            pan_grille_.repaint();
        }
         else if(e.getKeyCode()==KeyEvent.VK_E)
        {
          fig_.rotate(grille_);
            pan_grille_.repaint();
        }
         else if(e.getKeyCode()==KeyEvent.VK_D)
        {timer_1.setDelay(delai_);}         
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            if((timer_1.isRunning())&&(thread_2.getTimer().isRunning())){
            timer_1.stop();
            thread_2.getTimer().stop();            
            j= new JFrame();
            f2_.setFrame(j);
            j.add(option_);
            j.setVisible(true);            
            // taille et position
            j.setSize(410,390);
            j.setLocationRelativeTo(j.getParent());
            j.setResizable(false);
            option_.setVisible(true);
            j.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){ 
                timer_1.start();
                thread_2.getTimer().start();
                    //requestFocus();	
                }
                }); 
            }    
        }
    }
    
}
