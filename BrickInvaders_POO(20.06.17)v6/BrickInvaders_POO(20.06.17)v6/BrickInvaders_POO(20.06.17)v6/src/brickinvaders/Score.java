/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Jeu;
import iut.Objet;
import java.util.ArrayList;

/**
 *
 * @author Geoffrey
 */
public class Score extends iut.Objet {
    private int _time;
    private int _score;
    private ArrayList<ChiffreScore> _affichage = new ArrayList<ChiffreScore>(); 
    
    public Score(Jeu g, String num, int x, int y) {
        super(g,num,x,y);
        _time = 0;
        _score = 0;
        ChiffreScore centaine = new ChiffreScore(g, "0", 900, 5);
        ChiffreScore dizaine = new ChiffreScore(g, "0", 930, 5);
        ChiffreScore unite = new ChiffreScore(g, "0", 960, 5);
        _affichage.add(unite);
        _affichage.add(dizaine);
        _affichage.add(centaine);
        this.leJeu().ajouter(unite);
        this.leJeu().ajouter(dizaine);
        this.leJeu().ajouter(centaine);
    }

    /**
     * collision avec le score : impossible
     * @param objet objet qui entre en collision avec le score
     * @return false car pas de collision possible
     */
    @Override
    public boolean testerCollision(Objet objet) {
        return false;
    }

    @Override
    public void effetCollision(Objet objet) {
        
    }

    @Override
    public void evoluer(long l) {
        _time+=l;
        if(_time > 2500) { 
            _score++;
            _time = 0;
        }
        
        int unite = _score%10;
        int dizaine = (_score/10)%10;
        int centaine = _score/100;
        
        _affichage.get(0).changeSprite(Integer.toString(unite));
        _affichage.get(1).changeSprite(Integer.toString(dizaine));
        _affichage.get(2).changeSprite(Integer.toString(centaine));
    }
    
    public void addToScore(int points) {
        _score += points;
    }
    
    public int getScore() {
        return _score;
    }
}
