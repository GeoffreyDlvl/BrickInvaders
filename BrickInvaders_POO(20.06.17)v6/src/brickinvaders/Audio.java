/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

/**
 *
 * @author maxim
 */
import  java.io.*;
import javax.sound.sampled.*;
 
 
public class Audio implements Runnable{
     
     
    private AudioInputStream audioInputStream = null;
    private SourceDataLine line;
    
    // attribut spécifiant le son du fichier à lire
    private String fichierSon;
    
    // constructeur par paramètre
    public Audio(String f){
        this.fichierSon = f;
    }
     
    @Override
    public void run(){
        File fichier = new File(this.fichierSon);
        try {
        AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
         
        try {
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
          
         try {
             line = (SourceDataLine) AudioSystem.getLine(info);
                        
             } catch (LineUnavailableException e) {
               e.printStackTrace();
               return;
             }
          
        try {
                line.open(audioFormat);
        } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
        }
        line.start();
        try {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                 line.write(bytes, 0, bytesRead);
                }
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }
    }
}
