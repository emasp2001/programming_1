/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examendos;

/**
 *
 * @author emma
 */
public class Ficha {
    private int[] valor;
    private int valorTotal;
    private Ficha siguiente; //Siguiente ficha enlazada.
    
    public Ficha(int valor1, int valor2){
        this.valor = new int[2];
        valor[0]=valor1;
        valor[1]=valor2;
        valorTotal = valor[0]+valor[1];
        this.siguiente=null;
    }
    public void setSiguiente(Ficha next){siguiente=next;}
    public int[] getValores(){return valor;}
    public int getValorTotal(){return valorTotal;}
    public Ficha getSiguiente(){return siguiente;}
    public int getValor1(){return valor[0];}
    public int getValor2(){return valor[1];}
    public String toStringFicha(){return valor[0]+":"+valor[1];}
}
