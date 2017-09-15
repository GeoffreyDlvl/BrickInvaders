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
 * @author maxim
 */
public class FondJeu extends Objet{
    
    private BrickInvaders _jeu = (BrickInvaders)this.leJeu();

    public FondJeu(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
    public BrickInvaders getJeu() {
        return _jeu;
    }

    @Override
    public boolean testerCollision(Objet objet) {
        return false;
    }

    @Override
    public void effetCollision(Objet objet) {
        // rien
    }

    @Override
    public void evoluer(long l) {
        // rien
    }
    
}
