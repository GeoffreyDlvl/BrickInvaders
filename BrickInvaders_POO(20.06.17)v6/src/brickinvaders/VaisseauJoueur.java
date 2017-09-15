/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Jeu;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Geoffrey
 */
public class VaisseauJoueur extends iut.ObjetTouchable implements KeyListener {
    //private int _score = 0;
    private Score _score;
    private boolean _bonus = false;
    // attribut représentant le moment où le joueur touche un bonus
    private double momentGainJoueur = 0;
    // attribut représentant le timer pour le bonus
    private double _timerBonus = 0;
    private double _time = 0;
    private double _cadence = 100;
    private double velocite=0;
    private BrickInvaders _jeu = (BrickInvaders)this.leJeu();
    
    public VaisseauJoueur(Jeu g) {
        super(g, "vaisseau", 50,130);
        FondJeu fj = new FondJeu(g, "espace", 0, 0);
        this.leJeu().ajouter(fj);
        _score = new Score(g, "0", -50, -50); 
        this.leJeu().ajouter(_score);
    }

    // setter permettant de modifier l'attribut bonus du joueur
    public void setBonusJoueur(boolean b){
        this._bonus = b;
    }
    
    // getter permettant d'avoir accès à l'attribut bonus du joueur
    public boolean getBonusJoueur(){
        return this._bonus;
    }
        
    // setter permettant de configurer le timer du bonus
    public void setTimerBonus(double moment){
        this._timerBonus = moment;
    }
    // getter permettant de  récupérer le timer
    public double getTimerBonus(){
        return this._timerBonus;
    }
    
    /**
     * 
     * @param objet 
     */
    @Override
    public void effetCollision(Objet objet) {
        // rien
    }
    

    /**
     * Génération briques
     * @param l temps écoulé depuis la dernière évolution en ms
     */
    @Override
    public void evoluer(long l) {
        _time+=l;
        _timerBonus += 1;
        _cadence+=l;
        if(_time > 2000) {
            genereBrique(true);
            _time = 0;
        }
        // on regarde si le joueur a le bonus
        if (this._bonus == true){
            // si 500 période se sont écoulé depuis le moment où il a gagner le bonus
            if (this.momentGainJoueur + 1000 == _timerBonus){
                // alors on enlève le bonus
                this.setBonusJoueur(false);
            }
        }
    }
    
    public void genereBrique(boolean activer) {
        if(activer) {
            if(Math.random()<=0.2){
                int posY = (int)(Math.random()*(this.leJeu().hauteur()-this.largeur()));

                Bonus bo = new Bonus(this.leJeu(),"bonus",1050,posY,1000);
                this.leJeu().ajouter(bo);
            }
            else if(Math.random()<0.4){
                int posY = (int)(Math.random()*(this.leJeu().hauteur()-this.largeur()));
                Brique b1 = new Brique(this.leJeu(),"brique",1050,posY,1000);
                Brique b2 = new Brique(this.leJeu(),"brique",1050,posY+50,1000);
                b2.setVelocite(b1.getVelocite());
                this.leJeu().ajouter(b1);
                this.leJeu().ajouter(b2);
            }
            else if(Math.random()<0.4){
                int posY = (int)(Math.random()*(this.leJeu().hauteur()-this.largeur()));
                Brique b1 = new Brique(this.leJeu(),"brique",1050,posY,1000);
                Brique b2 = new Brique(this.leJeu(),"brique",1050,posY+50,1000);
                b2.setVelocite(b1.getVelocite());
                Brique b3 = new Brique(this.leJeu(),"brique",1000,posY,1000);
                b3.setVelocite(b1.getVelocite());
                Brique b4 = new Brique(this.leJeu(),"brique",1050,posY-50,1000);
                b4.setVelocite(b1.getVelocite());
                this.leJeu().ajouter(b1);
                this.leJeu().ajouter(b2);
                this.leJeu().ajouter(b3);
                this.leJeu().ajouter(b4);
            }
            else if(Math.random()<0.4){
                int posY = (int)(Math.random()*(this.leJeu().hauteur()-this.largeur()));
                Brique b1 = new Brique(this.leJeu(),"brique",1050,posY,1000);
                Brique b2 = new Brique(this.leJeu(),"brique",1050,posY+50,1000);
                b2.setVelocite(b1.getVelocite());
                Brique b3 = new Brique(this.leJeu(),"brique",1050,posY+100,1000);
                b3.setVelocite(b1.getVelocite());
                this.leJeu().ajouter(b1);
                this.leJeu().ajouter(b2);
                this.leJeu().ajouter(b3);
            }
            else {
                int posY = (int)(Math.random()*(this.leJeu().hauteur()-this.largeur()));

                Brique b = new Brique(this.leJeu(),"brique",1050,posY,1000);
                this.leJeu().ajouter(b);
            }
        }
    }

    /**
     * Non utilisé
     * @param ke 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    /**
     * Déplacement du joueur ou action de tirer
     * @param ke 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(this.posHaute()>0) {
                    this.deplacer(KeyEvent.VK_UP);
                } break;
            case KeyEvent.VK_DOWN:
                if(this.posBasse()<this.leJeu().hauteur()) {
                    this.deplacer(KeyEvent.VK_DOWN);
                } break;
            case KeyEvent.VK_SPACE:
                if (this._bonus == false){
                    tirer();
                }
                else {
                    tirerRouge();
                } break;
        }
    }
    
    
    @Override
    public void keyReleased(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                    this.velocite=0;
                break;
            case KeyEvent.VK_DOWN:
                    this.velocite=0;
                break;
        }
    }
    
    public void deplacer(int keyCode) {
        if(keyCode == KeyEvent.VK_UP) {
            this.velocite-=0.3;
            this.deplacerXY(0, -5+velocite);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            this.velocite+=0.3;
            this.deplacerXY(0, +5+velocite);
        }
    }
    
    
    /**
     * créé un objet tir en face du vaisseau
     */
    public void tirer() {
        Audio sonTir = new Audio("son/Tir.wav");
        if(_cadence >= 250) {
            Tir t = new Tir(this.leJeu(),"tir",this.posDroite(),this.milieuY()-5);
            this.leJeu().ajouter(t);
            sonTir.run();
            _cadence = 0;
        }
    }
    
    public void tirerRouge() {
        Audio sonTir = new Audio("son/Tir.wav");
        if(_cadence >= 250) {
            Tir t = new Tir(this.leJeu(),"tir_rouge",this.posDroite(),this.milieuY()-5);
            this.leJeu().ajouter(t);
            sonTir.run();
            _cadence = 0;
        }
    }
   
    
    public Score getScore() {
        return _score;
    }   
    
}
