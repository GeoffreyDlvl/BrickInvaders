/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Jeu;
import iut.Objet;

/**
 * Classe ne servant qu'à l'affichage des sprites du score
 * @author gd780855
 */
public class ChiffreScore extends iut.Objet{

    public ChiffreScore(Jeu g, String nom, double _x, double _y) {
        super(g, nom, _x, _y);
    }

    @Override
    public boolean testerCollision(Objet objet) {
       return false;
    }

    @Override
    public void effetCollision(Objet objet) {
    }

    @Override
    public void evoluer(long l) {
    }
}
