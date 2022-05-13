/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecci.tarprog2;

/**
 *
 * @author emma
 */
public class Main {
  public static void main(String[] argv) {
    final String casoPrueba1 = "10^x3 + 5x2 + 2x + 12"; // -----> Funciona.
    final String casoPrueba2 = "-10X3 +-5X^2"; // --------------> Funciona.
    final String casoPrueba3 = "-10x^3 - 5x2"; // --------------> Funciona.

    ecci.tarprog2.Graficador g = new Graficador();
    g.setVisible(true);

  }
}