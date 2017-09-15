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
public class Tir extends iut.ObjetTouchable {
    
    private BrickInvaders _jeu = (BrickInvaders)this.leJeu();
    
    public Tir(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    /**
     * Endommage ou détruit l'objet cible
     * @param objet objet cible
     */
    @Override
    public void effetCollision(Objet objet) {
        if(objet.getClass().getName() == "brickinvaders.Brique") {
            this.leJeu().supprimer(this);
        }
    }

    /**
     * Le tir se déplace et atteint éventuellement une cible
     * @param l temps écoulé depuis la dernière évolution en ms
     */
    @Override
    public void evoluer(long l) {
        this.deplacerXY(3, 0);
    }
    
}
