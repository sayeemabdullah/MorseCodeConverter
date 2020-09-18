/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsecodeconverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Sayeem Abdullah
 */
public class MorseCodeConverter {

    public static void playSound(String c) throws IOException{
        InputStream dotSound;
        dotSound = new FileInputStream(new File("sound\\\\morsecode_dot.wav"));
        AudioStream dotAudio = new AudioStream(dotSound);
        InputStream dashSound;
        dashSound = new FileInputStream(new File("sound\\\\morsecode_dash.wav"));
        AudioStream dashAudio = new AudioStream(dashSound);
        
        if(".".equals(c)){
            AudioPlayer.player.start(dotAudio);
        }
        else if("_".equals(c)){
            AudioPlayer.player.start(dashAudio);
        }
        
    }
    
    
    public static void main(String[] args) throws IOException {
        playSound(".");
    }
    
}
