/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Geoffrey
 */
public class BrickInvaders extends iut.Jeu {
    
    // attribut highScore représentant le score à battre
    // obligé de le mettre static pour l'utiliser dans le main
    private static int highScore;
    // attribut t représentant la musique du thème du jeu
    // obligé de le mettre en static pour l'utiliser dans le main et dans la fonction perdu
    private static ThemeJeu t = new ThemeJeu("son/Theme.wav");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // lance la JFrame Menu
        Menu m = new Menu();
        m.run();
        // récupère le score à battre
        BrickInvaders.highScore = m.getScoreAffiché();
        boolean jouerMenu = m.getJouer();
        if (jouerMenu){    
            BrickInvaders jeu = new BrickInvaders();
            t.start();
            jeu.jouer();
        }
    }

    public BrickInvaders() {
        super(1000, 300, "Brick Invaders");
    }
    
    private VaisseauJoueur j;
    
    // attribut représentant les bonus
    private Bonus bonus;
    
    public VaisseauJoueur getJoueur() {
        return j;
    }
    
    // getter permettant de récupérer les bonus
    public Bonus getBonus(){
        return bonus;
    }

    @Override
    protected void creeObjets() {
        j = new VaisseauJoueur(this);
        this.ajouter(j);
        this.ajouteEcouteurClavier(j);
        
    }

    @Override
    protected void dessinerArrierePlan(Graphics grphcs) {
        grphcs.setColor(Color.BLACK);
        grphcs.fillRect(0, 0, largeur(), hauteur());
    }

    @Override
    protected void perdu() {
        // si le joueur a perdu on stop proprement le thread du theme musical du jeu
        t.setRunning(false);
        // Saisi du nom du joueur si il bat un score dans les Highscores
        if (this.j.getScore().getScore() > BrickInvaders.highScore){
            SaisiNom s = new SaisiNom();
            s.setScoreSaisi(this.j.getScore().getScore());
            s.run();
        }
        // créer un panneau pour savoir si le joueur souhaite rejouer une partie avec les options oui et non
        // si l'option choisie est oui
        if (JOptionPane.showConfirmDialog(this, "Souhaitez-vous rejouer ?", "Fin de la partie !", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // relance le jeu
            // on relance la musique de fond
            t.setRunning(true);
            BrickInvaders jeu = new BrickInvaders();
            jeu.jouer();
        // si l'option choisie est non    
        } else {
            // ferme le jeu entièrement
            System.exit(0);         
        }
    }

    @Override
    protected void gagne() {
        //impossible de 'gagner'
    }

    @Override
    protected boolean aGagne() {
        //pas de fin du jeu
        return false;
    }

    @Override
    protected boolean aPerdu() {
        return false;
    }
   
}
