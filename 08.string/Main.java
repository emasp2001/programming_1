/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecci.laboratorio7;

/**
 *
 * @author emma
 */
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] argv){
        
        Hileras hileras = new Hileras();
        JOptionPane.showMessageDialog(null, hileras.esPalindromo("anita lava la tina"));
        JOptionPane.showMessageDialog(null, hileras.esAnagrama("fresa", "frase"));
        JOptionPane.showMessageDialog(null, hileras.cifrar("Hola mundoz", 3));
        JOptionPane.showMessageDialog(null, "Maria".compareTo("Pedro"));
        
        hileras.splitHileras("sphinx of black quartz judge my vow", "'");
    }
}
