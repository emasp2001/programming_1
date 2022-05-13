/*
 * Main de la aplicacion.
 * Reglas principales.
 *  L: gira a la izquierda 90 grados.
 *  R: gira a la derecha 90 grados.
 *  U: gira 180 grados.
 *  N: no cambia de direccion.
 */
package tarprogramada1;

/**
 *
 * @author emma
 */
public class TarProgramada1 {
  public static void main(String[] argv) {
    tarprogramada1.LangtonAnt langtonAnt = new LangtonAnt();

    langtonAnt.setCantSimulaciones(20);
    langtonAnt.setRules(crearReglas("LR"));
    langtonAnt.setBoardSize(5, 5);
    langtonAnt.setNumberAnts(1);
    /*
     * langtonAnt.correrSimulacion(); langtonAnt.printBoard();
     */
    LangtonAntUI frame = new LangtonAntUI(langtonAnt);
    frame.setVisible(true);

  }

  /*
   * Funcion convierte una palabra, que este compuesta por letras mayusculas de
   * las reglas, en un vector para enviarlo a la clase.
   */
  private static char[] crearReglas(String rules) {
    char[] reglas = new char[rules.length()];
    for (int i = 0; i < reglas.length; i++) {
      reglas[i] = rules.charAt(i);
    }

    return reglas;
  }

}
