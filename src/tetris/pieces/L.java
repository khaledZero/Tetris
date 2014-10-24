/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.pieces;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import tetris.Figure;
import tetris.Grille;
import tetris.view.PanneauFigure;
/**
 *
 * @author zero
 */
public class L extends Figure {
  private Case [] cases_;
  public L(){
      cases_=new Case[4];
      cases_[0]=new Case(-1,-1);
      cases_[1]=new Case(-1,-1);
      cases_[2]=new Case(-1,-1);
      cases_[3]=new Case(-1,-1);      
  }
  public Case getCases(int i){
      return cases_[i];
  }
  public JPanel afficheFigure(){
        PanneauFigure pan= new PanneauFigure(this);
        return pan;
  }
  
  public void descendre(Grille g) throws Exception{
    if(this.getEtat()==0){
    int nj=0; int ni=4;  
    if(this.cases_[2].getX()!=-1) {
                nj=this.cases_[2].getY()+1; 
                ni=this.cases_[2].getX();
    }
    //si on est en bas de la grille
    if (nj==22) throw new Exception();
    //si les cases suivantes sont occupée 
    if((g.lireGrille(ni,nj)!=null)||(g.lireGrille(ni+1, nj)!=null))
                throw new Exception();
    
    if((g.lireGrille(ni,nj)==null)&&(g.lireGrille(ni+1, nj)==null)){        
            g.setGrille(this.cases_[2],ni,nj);
            this.cases_[2].setX(ni);
            this.cases_[2].setY(nj);            
            g.setGrille(this.cases_[3], ni+1, nj);
            this.cases_[3].setX(ni+1);
            this.cases_[3].setY(nj);
        if(nj==1){
            g.setGrille(this.cases_[1],ni,nj-1);
            this.cases_[1].setX(ni);
            this.cases_[1].setY(nj-1);
            g.setGrille(null,ni+1,nj-1);
            
        }
        if(nj==2){
            g.setGrille(this.cases_[1],ni,nj-1);
            this.cases_[1].setX(ni);
            this.cases_[1].setY(nj-1);
            g.setGrille(this.cases_[0],ni,nj-2);
            this.cases_[0].setX(ni);
            this.cases_[0].setY(nj-2);
            g.setGrille(null, ni+1, nj-1);
        }
        if(nj>=3){
            g.setGrille(this.cases_[1],ni,nj-1);
            this.cases_[1].setX(ni);
            this.cases_[1].setY(nj-1);
            g.setGrille(this.cases_[0],ni,nj-2);
            this.cases_[0].setX(ni);
            this.cases_[0].setY(nj-2);
            g.setGrille(null, ni, nj-3);
            g.setGrille(null, ni+1, nj-1);
        }
      }
  }
  // etat ==1 (alangé)
  if(this.getEtat()==1){
      int ni=4;
      int nj=0;
      if(cases_[3].getY()!=-1){
            ni= cases_[3].getX();
            nj= cases_[3].getY()+1;
       }
    //si on est en bas de la grille
    if (nj==22) throw new Exception();
    //si les cases suivantes sont occupée 
    if((g.lireGrille(ni,nj)!=null)||(g.lireGrille(ni+1, nj-1)!=null)
            ||(g.lireGrille(ni+2, nj-1)!=null))
                throw new Exception();
    
    
        if(nj==0){
            if((g.lireGrille(ni,nj)==null)){
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                /*
                g.setGrille(null, ni, nj-2);
                g.setGrille(null, ni+1, nj-2);
                g.setGrille(null, ni+2, nj-2);
                 */
            }
        }
        if(nj==1){
            if((g.lireGrille(ni,nj)==null)&&(g.lireGrille(ni+1, nj-1)==null)
                    &&(g.lireGrille(ni+2, nj-1)==null)){
            g.setGrille(cases_[3], ni, nj);
            cases_[3].setX(ni);
            cases_[3].setY(nj);
            g.setGrille(cases_[2], ni, nj-1);
            cases_[2].setX(ni);
            cases_[2].setY(nj-1);
            g.setGrille(cases_[1], ni+1, nj-1);
            cases_[1].setX(ni+1);
            cases_[1].setY(nj-1);
            g.setGrille(cases_[0], ni+2, nj-1);
            cases_[0].setX(ni+2);
            cases_[0].setY(nj-1);
            /*
            g.setGrille(null, ni, nj-2);
            g.setGrille(null, ni+1, nj-2);
            g.setGrille(null, ni+2, nj-2);
             */
            }
            
        }
        if(nj>=2){
            if((g.lireGrille(ni,nj)==null)&&(g.lireGrille(ni+1, nj-1)==null)
                    &&(g.lireGrille(ni+2, nj-1)==null)){
                 g.setGrille(cases_[3], ni, nj);
                 cases_[3].setX(ni);
                 cases_[3].setY(nj);
                 g.setGrille(cases_[2], ni, nj-1);
                 cases_[2].setX(ni);
                 cases_[2].setY(nj-1);
                 g.setGrille(cases_[1], ni+1, nj-1);
                 cases_[1].setX(ni+1);
                 cases_[1].setY(nj-1);
                 g.setGrille(cases_[0], ni+2, nj-1);
                 cases_[0].setX(ni+2);
                 cases_[0].setY(nj-1);
            
                 g.setGrille(null, ni, nj-2);
                 g.setGrille(null, ni+1, nj-2);
                 g.setGrille(null, ni+2, nj-2);
             
            }
        }    
  }
  //etat vers le bas
  if(this.getEtat()==2){
      int ni=4;
      int nj=0;
      if(cases_[0].getY()!=-1){
          ni=cases_[0].getX();
          nj=cases_[0].getY();
      }
      //si on est en bas de la grille
    if (nj==21) throw new Exception();
    //si les cases suivantes sont occupée 
    if((g.lireGrille(ni,nj+1)!=null)||((nj!=0)&&
            g.lireGrille(ni-1, nj-1)!=null)) throw new Exception();
    
    if(nj==0){
        if(g.lireGrille(ni, nj+1)==null){
            g.setGrille(cases_[0], ni, nj+1);
            cases_[0].setX(ni);
            cases_[0].setY(nj+1);
            g.setGrille(cases_[1], ni, nj);
            cases_[1].setX(ni);
            cases_[1].setY(nj);
        }
    }
    if(nj==1){
        if((g.lireGrille(ni, nj+1)==null)&&(g.lireGrille(ni-1, nj-1)==null)){
            g.setGrille(cases_[0], ni, nj+1);
            cases_[0].setX(ni);
            cases_[0].setY(nj+1);
            g.setGrille(cases_[1], ni, nj);
            cases_[1].setX(ni);
            cases_[1].setY(nj);
            g.setGrille(cases_[2], ni, nj-1);
            cases_[2].setX(ni);
            cases_[2].setY(nj-1);
            g.setGrille(cases_[3], ni-1, nj-1);
            cases_[3].setX(ni-1);
            cases_[3].setY(nj-1);
        }
    }
    if(nj>=2){
        if((g.lireGrille(ni, nj+1)==null)&&(g.lireGrille(ni-1, nj-1)==null)){
            g.setGrille(cases_[0], ni, nj+1);
            cases_[0].setX(ni);
            cases_[0].setY(nj+1);
            g.setGrille(cases_[1], ni, nj);
            cases_[1].setX(ni);
            cases_[1].setY(nj);
            g.setGrille(cases_[2], ni, nj-1);
            cases_[2].setX(ni);
            cases_[2].setY(nj-1);
            g.setGrille(cases_[3], ni-1, nj-1);
            cases_[3].setX(ni-1);
            cases_[3].setY(nj-1);
            g.setGrille(null, ni, nj-2);
            g.setGrille(null, ni-1, nj-2);
        }
    }
      
  }
  //etat 3
  if(this.getEtat()==3){
      int ni=4;
      int nj=0;
      if(cases_[1].getX()!=-1){
          ni=cases_[1].getX();
          nj=cases_[1].getY();
      }
      //si on est en bas de la grille
      if (nj==21) throw new Exception();
    //si les cases suivantes sont occupée 
      if((g.lireGrille(ni,nj+1)!=null)
              ||(g.lireGrille(ni+1, nj+1)!=null)
              ||(g.lireGrille(ni-1, nj+1)!=null)) throw new Exception();
      if(nj==0){
          if((g.lireGrille(ni, nj+1)==null)
                  &&(g.lireGrille(ni+1, nj+1)==null)
                  &&(g.lireGrille(ni-1, nj+1)==null)){
              g.setGrille(cases_[0], ni-1, nj+1);
              cases_[0].setX(ni-1);
              cases_[0].setY(nj+1);
              g.setGrille(cases_[1], ni, nj+1);
              cases_[1].setX(ni);
              cases_[1].setY(nj+1);
              g.setGrille(cases_[2], ni+1, nj+1);
              cases_[2].setX(ni+1);
              cases_[2].setY(nj+1);
              g.setGrille(cases_[3], ni+1, nj);
              cases_[3].setX(ni+1);
              cases_[3].setY(nj);
              g.setGrille(null, ni-1, nj);
              g.setGrille(null, ni, nj);
          }
      }
      if(nj>=1){
          if((g.lireGrille(ni, nj+1)==null)
                  &&(g.lireGrille(ni+1, nj+1)==null)
                  &&(g.lireGrille(ni-1, nj+1)==null)){
              g.setGrille(cases_[0], ni-1, nj+1);
              cases_[0].setX(ni-1);
              cases_[0].setY(nj+1);
              g.setGrille(cases_[1], ni, nj+1);
              cases_[1].setX(ni);
              cases_[1].setY(nj+1);
              g.setGrille(cases_[2], ni+1, nj+1);
              cases_[2].setX(ni+1);
              cases_[2].setY(nj+1);
              g.setGrille(cases_[3], ni+1, nj);
              cases_[3].setX(ni+1);
              cases_[3].setY(nj);
              g.setGrille(null, ni-1, nj);
              g.setGrille(null, ni, nj);
              g.setGrille(null, ni+1, nj-1);
          }
      }
      
  }
  }
  
  public  void deplacerGauche(Grille g){
    if(this.getEtat()==0){
    int ni=4, nj=0;
    if(cases_[2].getX()!=-1){
        ni= cases_[2].getX();
        nj= cases_[2].getY();
    }
    if(ni>0){
        if(nj==0)
            if(cases_[2].getX()!=-1){
            if(g.lireGrille(ni-1, nj)==null){
                g.setGrille(cases_[2], ni-1, nj);
                cases_[2].setX(ni-1);
                cases_[2].setY(nj);
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                g.setGrille(null, ni+1, nj);
            }
            }
        if(nj==1){
            if((g.lireGrille(ni-1, nj-1)==null)
                    &&(g.lireGrille(ni-1, nj)==null)){
                g.setGrille(cases_[2], ni-1, nj);
                cases_[2].setX(ni-1);
                cases_[2].setY(nj);
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                g.setGrille(null, ni+1, nj);
                g.setGrille(cases_[1], ni-1, nj-1);
                cases_[1].setX(ni-1);
                cases_[1].setY(nj-1);
                g.setGrille(null, ni, nj-1);
                } 
        }
        if(nj>=2){
            if((g.lireGrille(ni-1, nj-2)==null)
                    &&(g.lireGrille(ni-1, nj-1)==null)
                    &&(g.lireGrille(ni-1, nj)==null)){
                g.setGrille(cases_[2], ni-1, nj);
                cases_[2].setX(ni-1);
                cases_[2].setY(nj);
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                g.setGrille(null, ni+1, nj);
                g.setGrille(cases_[1], ni-1, nj-1);
                cases_[1].setX(ni-1);
                cases_[1].setY(nj-1);
                g.setGrille(null, ni, nj-1);
                g.setGrille(cases_[0], ni-1, nj-2);
                cases_[0].setX(ni-1);
                cases_[0].setY(nj-2);
                g.setGrille(null, ni, nj-2);          
            }
        }   
    }
    }
    if(this.getEtat()==1){
        int ni=4;
        int nj=0;
        if(cases_[3].getX()!=-1){
            ni=cases_[3].getX();
            nj=cases_[3].getY();
        }
        if(ni>0){
            if(nj==0){
                if(cases_[3].getX()!=-1){
                if(g.lireGrille(ni-1, nj)==null){
                    g.setGrille(cases_[3], ni-1, nj);
                    cases_[3].setX(ni-1);
                    cases_[3].setY(nj);
                    g.setGrille(null, ni, nj);
                }
                }
            }
            if(nj>=1){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-1, nj-1)==null)){
                    g.setGrille(cases_[3], ni-1, nj);
                    cases_[3].setX(ni-1);
                    cases_[3].setY(nj);
                    g.setGrille(cases_[2], ni-1, nj-1);
                    cases_[2].setX(ni-1);
                    cases_[2].setY(nj-1);
                    g.setGrille(cases_[1], ni, nj-1);
                    cases_[1].setX(ni);
                    cases_[1].setY(nj-1);
                    g.setGrille(cases_[0], ni+1, nj-1);
                    cases_[0].setX(ni+1);
                    cases_[0].setY(nj-1);
                    g.setGrille(null, ni+2, nj-1);
                    g.setGrille(null, ni, nj);
                }
            }
        }
    }
    if(this.getEtat()==2){
        int ni=4;
        int nj=0;
        if(cases_[0].getY()!=-1){
            ni=cases_[0].getX();
            nj=cases_[0].getY();
        }
        if(ni>1){
            if(nj==0){
                if(cases_[0].getX()!=-1){
                if(g.lireGrille(ni-1, nj)==null){
                    g.setGrille(cases_[0], ni-1, nj);
                    cases_[0].setX(ni-1);
                    cases_[0].setY(nj);
                    g.setGrille(null, ni, nj);
                }
                }
            }           
            if(nj==1){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-1, nj-1)==null)){
                    g.setGrille(cases_[0], ni-1, nj);
                    cases_[0].setX(ni-1);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj-1);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj-1);
                    g.setGrille(null, ni, nj);
                    g.setGrille(null, ni, nj-1);
                }
            }
            if(nj>=2){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-1, nj-1)==null)
                        &&(g.lireGrille(ni-2, nj-2)==null)){
                    g.setGrille(cases_[0], ni-1, nj);
                    cases_[0].setX(ni-1);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj-1);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj-1);
                    g.setGrille(null, ni, nj);
                    g.setGrille(null, ni, nj-1);
                    g.setGrille(cases_[3], ni-2, nj-2);
                    g.setGrille(cases_[2], ni-1, nj-2);
                    g.setGrille(null, ni, nj-2);
                }
            }
        }
    }
    if(this.getEtat()==3){
        int ni=4;
        int nj=0;
        if(cases_[1].getX()!=-1){
            ni=cases_[1].getX();
            nj=cases_[1].getY();
        }
        if(ni>1){
            if(nj==0){
                if(cases_[1].getX()!=-1){
                if(g.lireGrille(ni-2, nj)==null){
                    g.setGrille(cases_[0], ni-2, nj);
                    cases_[0].setX(ni-2);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni, nj);
                    cases_[2].setX(ni);
                    cases_[2].setY(nj);
                    g.setGrille(null, ni+1, nj);
                }
                }
            }
            if(nj>=1){
                if((g.lireGrille(ni-2, nj)==null)
                        &&(g.lireGrille(ni, nj-1)==null)){
                    g.setGrille(cases_[0], ni-2, nj);
                    cases_[0].setX(ni-2);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni, nj);
                    cases_[2].setX(ni);
                    cases_[2].setY(nj);
                    g.setGrille(cases_[3], ni, nj-1);
                    cases_[3].setX(ni);
                    cases_[3].setY(nj-1);
                    g.setGrille(null, ni+1, nj);
                    g.setGrille(null, ni+1, nj-1);
                }
            }
        }
    }
  }
  public  void deplacerDroite(Grille g){
      if(this.getEtat()==0){
      int ni=4;
      int nj=0;
      if(cases_[2].getX()!=-1){
            ni= cases_[2].getX();
            nj= cases_[2].getY();
        }
      if(ni<8){
                if(nj==0){
                    if(cases_[2].getX()!=-1){
                    if(g.lireGrille(ni+2, nj)==null){
                        g.setGrille(cases_[3], ni+2, nj);
                        cases_[3].setX(ni+2);
                        cases_[3].setY(nj);
                        g.setGrille(cases_[2], ni+1, nj);
                        cases_[2].setX(ni+1);
                        cases_[2].setY(nj);                
                        g.setGrille(null, ni, nj); 
                    }
                    }
                }
                if(nj==1){
                  if((g.lireGrille(ni+1, nj-1)==null)&&
                          (g.lireGrille(ni+2, nj)==null)){
                     g.setGrille(cases_[3], ni+2, nj);
                     cases_[3].setX(ni+2);
                     cases_[3].setY(nj);
                     g.setGrille(cases_[2], ni+1, nj);
                     cases_[2].setX(ni+1);
                     cases_[2].setY(nj);                
                     g.setGrille(null, ni, nj); 
                     g.setGrille(cases_[1], ni+1, nj-1);
                     cases_[1].setX(ni+1);
                     cases_[1].setY(nj-1);
                     g.setGrille(null, ni, nj-1); 
                  }  
                 }
                if(nj>=2){
                   if((g.lireGrille(ni+1, nj-2)==null)&&
                           (g.lireGrille(ni+1, nj-1)==null)&&
                          (g.lireGrille(ni+2, nj)==null)){
                      g.setGrille(cases_[3], ni+2, nj);
                      cases_[3].setX(ni+2);
                      cases_[3].setY(nj);
                      g.setGrille(cases_[2], ni+1, nj);
                      cases_[2].setX(ni+1);
                      cases_[2].setY(nj);                
                      g.setGrille(null, ni, nj); 
                      g.setGrille(cases_[1], ni+1, nj-1);
                      cases_[1].setX(ni+1);
                      cases_[1].setY(nj-1);
                      g.setGrille(null, ni, nj-1); 
                      g.setGrille(cases_[0], ni+1, nj-2);
                      cases_[0].setX(ni+1);
                      cases_[0].setY(nj-2);
                      g.setGrille(null, ni, nj-2);          
                    }
                  }       
      }
      
  }
  //etat = 1 (alangé)
  if (this.getEtat()==1){
    int ni=4;
    int nj=0;
    if(cases_[3].getX()!=-1){
        ni=cases_[3].getX();
        nj=cases_[3].getY();
    }
    if(ni<7){
        if(nj==0){
            if(cases_[3].getX()!=-1){
            g.setGrille(cases_[3], ni+1, nj);
            cases_[3].setX(ni+1);
            cases_[3].setY(nj);
            g.setGrille(null, ni, nj);              
        }
        }
        if(nj>=1){
            if((g.lireGrille(ni+3, nj-1)==null)&&
                    (g.lireGrille(ni+1, nj)==null)){
            g.setGrille(cases_[0], ni+3, nj-1);
            cases_[0].setX(ni+3);
            cases_[0].setY(nj-1);
            g.setGrille(cases_[1], ni+2, nj-1);
            cases_[1].setX(ni+2);
            cases_[1].setY(nj-1);
            g.setGrille(cases_[2], ni+1, nj-1);
            cases_[2].setX(ni+1);
            cases_[2].setY(nj-1);
            g.setGrille(cases_[3], ni+1, nj);
            cases_[3].setX(ni+1);
            cases_[3].setY(nj);
            g.setGrille(null, ni, nj);
            g.setGrille(null, ni, nj-1);
            }
        }
    }
  }
  if(this.getEtat()==2){
      int ni=4;
      int nj=0;
      if(cases_[0].getX()!=-1){
          ni=cases_[0].getX();
          nj=cases_[0].getY();
      }
      if(ni<9){
          if(nj==0){
              if(cases_[0].getX()!=-1){
              if(g.lireGrille(ni+1, nj)==null){
                  g.setGrille(cases_[0], ni+1, nj);
                  cases_[0].setX(ni+1);
                  cases_[0].setY(nj);
                  g.setGrille(null, ni, nj);
              }
              }
          }
          if(nj==1){
              if((g.lireGrille(ni+1, nj)==null)
                      &&(g.lireGrille(ni+1, nj-1)==null)){
                  g.setGrille(cases_[0], ni+1, nj);
                  cases_[0].setX(ni+1);
                  cases_[0].setY(nj);
                  g.setGrille(null, ni, nj);
                  g.setGrille(cases_[1], ni+1, nj-1);
                  cases_[1].setX(ni+1);
                  cases_[1].setY(nj-1);
                  g.setGrille(null, ni, nj-1);
              }
          }
          if(nj>=2){
              if((g.lireGrille(ni+1, nj)==null)
                      &&(g.lireGrille(ni+1, nj-1)==null)
                      &&(g.lireGrille(ni+1, nj-2)==null)){
                  g.setGrille(cases_[0], ni+1, nj);
                  cases_[0].setX(ni+1);
                  cases_[0].setY(nj);
                  g.setGrille(null, ni, nj);
                  g.setGrille(cases_[1], ni+1, nj-1);
                  cases_[1].setX(ni+1);
                  cases_[1].setY(nj-1);
                  g.setGrille(null, ni, nj-1);
                  g.setGrille(cases_[2], ni+1, nj-2);
                  cases_[2].setX(ni+1);
                  cases_[2].setY(nj-2);
                  g.setGrille(cases_[3], ni, nj-2);
                  cases_[3].setX(ni);
                  cases_[3].setY(nj-2);
                  g.setGrille(null, ni-1, nj-2);
              }
          }
      }
  }
  if(this.getEtat()==3){
      int ni=4;
      int nj=0;
      if(cases_[1].getX()!=-1){
          ni=cases_[1].getX();
          nj=cases_[1].getY();
      }
      if(ni<8){
          if(nj==0){
              if(cases_[1].getX()!=-1){
              if(g.lireGrille(ni+2, nj)==null){
                  g.setGrille(cases_[2], ni+2, nj);
                  cases_[2].setX(ni+2);
                  cases_[2].setY(nj);
                  g.setGrille(cases_[1], ni+1, nj);
                  cases_[1].setX(ni+1);
                  cases_[1].setY(nj);
                  g.setGrille(cases_[0], ni, nj);
                  cases_[0].setX(ni);
                  cases_[0].setY(nj);
                  g.setGrille(null, ni-1, nj);                  
              }
              }
          }
          if(nj>=1){
              if((g.lireGrille(ni+2, nj)==null)
                      &&(g.lireGrille(ni+2, nj-1)==null)){
                  g.setGrille(cases_[2], ni+2, nj);
                  cases_[2].setX(ni+2);
                  cases_[2].setY(nj);
                  g.setGrille(cases_[1], ni+1, nj);
                  cases_[1].setX(ni+1);
                  cases_[1].setY(nj);
                  g.setGrille(cases_[0], ni, nj);
                  cases_[0].setX(ni);
                  cases_[0].setY(nj);
                  g.setGrille(cases_[3], ni+2, nj-1);
                  cases_[3].setX(ni+2);
                  cases_[3].setY(nj-1);
                  g.setGrille(null, ni-1, nj);
                  g.setGrille(null, ni+1, nj-1);
              }
          }
      }
  }
  }
  public  void rotate(Grille g){
    if(this.getEtat()==0){ 
      int ni=4;
      int nj=0;
      if(cases_[2].getX()!=-1){
            ni= cases_[2].getX();
            nj= cases_[2].getY();
        }
      if(ni<8){
      /*if(nj==0){
          g.setGrille(null, ni, nj);
          g.setGrille(null, ni+1, nj);
          cases_[3].setX(-1);
          cases_[3].setY(-1);
          cases_[2].setX(-1);
          cases_[2].setY(-1);
      }*/
      if(nj==1){
          g.setGrille(cases_[3], ni, nj-1);
          cases_[3].setX(ni);
          cases_[3].setY(nj-1);
          cases_[2].setX(-1);
          cases_[2].setY(-1);
          cases_[1].setX(-1);
          cases_[1].setY(-1);
          g.setGrille(null, ni+1, nj);
          g.setGrille(null, ni, nj);
          this.setEtat(1);
          return;
      }
      if(nj>=2){
          if((g.lireGrille(ni+1, nj-2)==null)
                  &&(g.lireGrille(ni+2, nj-2)==null)){
             g.setGrille(cases_[0], ni+2, nj-2);
             cases_[0].setX(ni+2);
             cases_[0].setY(nj-2);
             g.setGrille(cases_[1], ni+1, nj-2);
             cases_[1].setX(ni+1);
             cases_[1].setY(nj-2);
             g.setGrille(cases_[2], ni, nj-2);
             cases_[2].setX(ni);
             cases_[2].setY(nj-2);
             g.setGrille(cases_[3], ni, nj-1);
             cases_[3].setX(ni);
             cases_[3].setY(nj-1);
             g.setGrille(null, ni, nj);
             g.setGrille(null, ni+1, nj);
             this.setEtat(1);
             return;
          }
      }
            
    }
      
    }
    if(this.getEtat()==1){
        int ni=4;
        int nj=0;
        if(cases_[3].getY()!=-1){
            ni=cases_[3].getX();
            nj=cases_[3].getY();
        }
        if(ni<=7){
            if(nj==0){
                if((g.lireGrille(ni+2, nj)==null)&&
                        (g.lireGrille(ni+2, nj+1)==null)){
                    g.setGrille(cases_[0], ni+2, nj+1);
                    cases_[0].setX(ni+2);
                    cases_[0].setY(nj+1);
                    g.setGrille(cases_[1], ni+2, nj);
                    cases_[1].setX(ni+2);
                    cases_[1].setY(nj);
                    g.setGrille(null, ni, nj);
                    cases_[3].setX(-1);
                    cases_[3].setY(-1);
                    this.setEtat(2);
                    return;
                }
            }
            if(nj>=1){
                if((g.lireGrille(ni+2, nj)==null)&&
                        (g.lireGrille(ni+2, nj+1)==null)){
                    g.setGrille(cases_[0], ni+2, nj+1);
                    cases_[0].setX(ni+2);
                    cases_[0].setY(nj+1);
                    g.setGrille(cases_[1], ni+2, nj);
                    cases_[1].setX(ni+2);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni+2, nj-1);
                    cases_[2].setX(ni+2);
                    cases_[2].setY(nj-11);
                    g.setGrille(cases_[3], ni+1, nj-1);
                    cases_[3].setX(ni+1);
                    cases_[3].setY(nj-1);
                    g.setGrille(null, ni, nj-1);
                    g.setGrille(null, ni, nj);
                    this.setEtat(2);
                    return;
                }
            }
            
        }
    }
    if(this.getEtat()==2){
        int ni=4;
        int nj=0;
        if(cases_[0].getY()!=-1){
            ni=cases_[0].getX();
            nj=cases_[0].getY();
        }
        if(ni>1){
            if(nj==0){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-2, nj)==null)){
                    g.setGrille(cases_[0], ni-2, nj);
                    cases_[0].setX(ni-2);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni, nj);
                    cases_[2].setX(ni);
                    cases_[2].setY(nj);
                    this.setEtat(3);
                    return;
                }
            }
            if(nj==1){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-2, nj)==null)){
                    g.setGrille(cases_[0], ni-2, nj);
                    cases_[0].setX(ni-2);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni, nj);
                    cases_[2].setX(ni);
                    cases_[2].setY(nj);
                    g.setGrille(cases_[3], ni, nj-1);
                    cases_[3].setX(ni);
                    cases_[3].setY(nj-1);
                    this.setEtat(3);
                    return;
                }
            }
            if(nj>=2){
                if((g.lireGrille(ni-1, nj)==null)
                        &&(g.lireGrille(ni-2, nj)==null)){
                    g.setGrille(cases_[0], ni-2, nj);
                    cases_[0].setX(ni-2);
                    cases_[0].setY(nj);
                    g.setGrille(cases_[1], ni-1, nj);
                    cases_[1].setX(ni-1);
                    cases_[1].setY(nj);
                    g.setGrille(cases_[2], ni, nj);
                    cases_[2].setX(ni);
                    cases_[2].setY(nj);
                    g.setGrille(cases_[3], ni, nj-1);
                    cases_[3].setX(ni);
                    cases_[3].setY(nj-1);
                    g.setGrille(null, ni, nj-2);
                    g.setGrille(null, ni-1, nj-2);
                    this.setEtat(3);
                    return;
                }
            }            
        }
    }
    if(this.getEtat()==3){
        int ni=4;
        int nj=0;
        if(cases_[1].getX()!=-1){
            ni=cases_[1].getX();
            nj=cases_[1].getY();
        }
        if(nj==0){
            g.setGrille(cases_[2], ni-1, nj);
            cases_[2].setX(ni-1);
            cases_[2].setY(nj);
            cases_[0].setX(-1);
            cases_[0].setY(-1);
            g.setGrille(cases_[3], ni, nj);
            cases_[3].setX(ni);
            cases_[3].setY(nj);
            cases_[1].setX(-1);
            cases_[1].setY(-1);
            g.setGrille(null, ni+1, nj);
            this.setEtat(0);
            return;
        }
        if(nj==1){
            if(g.lireGrille(ni-1, nj-1)==null){
                g.setGrille(cases_[1], ni-1, nj-1);
                cases_[1].setX(ni-1);
                cases_[1].setY(nj-1);
                g.setGrille(cases_[2], ni-1, nj);
                cases_[2].setX(ni-1);
                cases_[2].setY(nj);
                cases_[0].setX(-1);
                cases_[0].setY(-1);
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                g.setGrille(null, ni+1, nj);
                g.setGrille(null, ni+1, nj-1);
                this.setEtat(0);
                return;
            }
        }
        if(nj>=2){
            if((g.lireGrille(ni-1, nj-2)==null)
                    &&(g.lireGrille(ni-1, nj-1)==null)){
                g.setGrille(cases_[0], ni-1, nj-2);
                cases_[0].setX(ni-1);
                cases_[0].setY(nj-2);
                g.setGrille(cases_[1], ni-1, nj-1);
                cases_[1].setX(ni-1);
                cases_[1].setY(nj-1);
                g.setGrille(cases_[2], ni-1, nj);
                cases_[2].setX(ni-1);
                cases_[2].setY(nj);                
                g.setGrille(cases_[3], ni, nj);
                cases_[3].setX(ni);
                cases_[3].setY(nj);
                g.setGrille(null, ni+1, nj);
                g.setGrille(null, ni+1, nj-1);
                this.setEtat(0);
                return;
            }
        }
    }
  }
    
}
