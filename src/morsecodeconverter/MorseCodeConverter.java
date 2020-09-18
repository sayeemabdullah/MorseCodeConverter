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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Sayeem Abdullah
 */
public class MorseCodeConverter {

    public static void playSound(char c) throws IOException{
        InputStream dotSound;
        dotSound = new FileInputStream(new File("sound\\\\morsecode_dot.wav"));
        AudioStream dotAudio = new AudioStream(dotSound);
        InputStream dashSound;
        dashSound = new FileInputStream(new File("sound\\\\morsecode_dash.wav"));
        AudioStream dashAudio = new AudioStream(dashSound);
        char dot = '.' ;
        char dash = '-';
        if(c==dot){
            AudioPlayer.player.start(dotAudio);
            System.out.print(dot);
        }
        else if(c==dash){
            AudioPlayer.player.start(dashAudio);
            System.out.print(dash);
        }
        
    }
    
    public static void charToMorse(char ch) throws InterruptedException, IOException{
            char[] c = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
                  'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                  ',', '.', '?' };

            String[] m = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                    ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                    "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                    "-----", "--..--", ".-.-.-", "..--.." };
            
            for(int i=0;i<c.length;i++){
                if(ch==c[i]){
                    String s = m[i];
                    for(int j=0;j<s.length();j++){
                        char cha=s.charAt(j);
                        playSound(cha);
                        TimeUnit.SECONDS.sleep(1);
                    }
                    TimeUnit.SECONDS.sleep(2);
                    break;
                }
            }
    }
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input= new Scanner(System.in);
        String str = input.nextLine();
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            charToMorse(str.charAt(i));
            System.out.print(" ");
        }
    }
}
