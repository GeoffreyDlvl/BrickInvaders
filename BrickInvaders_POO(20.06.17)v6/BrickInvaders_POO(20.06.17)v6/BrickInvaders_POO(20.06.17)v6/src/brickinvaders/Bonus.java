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
public class Bonus extends iut.ObjetTouchable {
    private boolean _destructible;
    private int _durabilite=200;
    private BrickInvaders _jeu = (BrickInvaders)this.leJeu();

    public Bonus(Jeu g, String nom, int x, int y, int durabilite) {
        super(g, nom, x, y);
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
     * le joueur obtient un bonus
     * @param objet 
     */
    @Override
    public void effetCollision(Objet objet) {
        if(objet == _jeu.getJoueur()) {
            this.leJeu().supprimer(this);
            this.getJeu().getJoueur().setBonusJoueur(true);
            this.getJeu().getJoueur().setTimerBonus(0);
            _jeu.getJoueur().getScore().addToScore(3);
        }
    }

    /**
     * Se déplace vers la gauche
     * @param l 
     */
    @Override
    public void evoluer(long l) {
        this.deplacerXY(-1.5, 0);
    }
}
