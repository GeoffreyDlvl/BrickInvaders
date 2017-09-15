/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Jeu;
import iut.Objet;

/**
 *
 * @author Geoffrey
 */
public class Brique extends iut.ObjetTouchable {
    private int _durabilite = 100;
    private double velocite = 0;
    private BrickInvaders _jeu = (BrickInvaders)this.leJeu();
    
    public Brique(Jeu g, String nom, int x, int y, int durabilite) {
        super(g, nom, x, y);
        this.velocite = Math.random();
    }
    
    public BrickInvaders getJeu() {
        return _jeu;
    }
    
    /**
     * getteur, retourne la durabilité (la vie) de l'objet
     * @return la durabilité
     */
    public int getDurabilite() {
        return _durabilite;
    }
    
    /**
     * setteur, modifie la durabilité de l'objet
     * @param durabilite nouvelle durabilité
     */
    public void setDurabilite(int durabilite) {
        _durabilite = durabilite;
    }
    
    /**
     * L'objet subit des points de dégat
     * @param pointsDegat nombre de points de dégat subit
     */
    public void degats(int pointsDegat) {
        if (_jeu.getJoueur().getBonusJoueur() == true){
            _durabilite -= pointsDegat * 2;
            if(_durabilite <= 0) {
                this.leJeu().supprimer(this);
                _jeu.getJoueur().getScore().addToScore(5);
            }
        } else {
            _durabilite -= pointsDegat;
            if(_durabilite <= 0) {
                this.leJeu().supprimer(this);
                _jeu.getJoueur().getScore().addToScore(5);
            }
        }
    }

    /**
     * Détruit le joueur ou est détruit par un tir
     * @param objet 
     */
    @Override
    public void effetCollision(Objet objet) {
        if(objet == _jeu.getJoueur()) {
            Audio sonImpact = new Audio("son/Impact.wav");
            sonImpact.run();
            this.leJeu().mourir();
        } else if(objet.getClass().getName() == "brickinvaders.Tir") {
            int degat = (int)(Math.random()*10)+10; //dégats entre 10 et 20
            this.degats(degat);
        }
    }

    /**
     * Se déplace vers la gauche
     * @param l 
     */
    @Override
    public void evoluer(long l) {
        if(_jeu.getJoueur().getScore().getScore() < 10)
            this.deplacerXY(-1.5+velocite, 0);
        else if(_jeu.getJoueur().getScore().getScore() < 20)
            this.deplacerXY(-2.5+velocite, 0);
        else if(_jeu.getJoueur().getScore().getScore() < 30)
            this.deplacerXY(-3+velocite, 0);
        else if(_jeu.getJoueur().getScore().getScore() < 100)
            this.deplacerXY(-3.5+velocite, 0);
        else if(_jeu.getJoueur().getScore().getScore() < 200)
            this.deplacerXY(-4+velocite, 0);
        else if(_jeu.getJoueur().getScore().getScore() < 500)
            this.deplacerXY(-2.8+velocite, 0);
        else
            this.deplacerXY(-3, 0);
    }
  
    public double getVelocite() {
        return velocite;
    }
    public void setVelocite(double velocite) {
        this.velocite=velocite;
    }
}
