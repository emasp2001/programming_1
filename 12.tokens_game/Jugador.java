/*
 * Metodos necesarios:
LISTO Método  comerFicha  que  toma  una  ficha  al  azar  de  las restantes en el tablero, la agrega a las fichas de jugador y la remueve de las fichas restantes.

Método  pedirJugada  que  llamará  a  pedirUsuario  si  el jugador es humano y a pedirComputadora si el jugador no lo es.

Método pedirUsuario le pide al usuario la ficha que desea posicionar. Para  ello  debe  mostrarle  las  fichas  disponibles.
    Tambien  debe  darle  al usuario  la  opción  de  comerFicha,  en  caso  de  que  el  jugador  no  tenga ninguna  ficha  válida.
    Si  el  jugador  quisiera  comerFicha  y  no  quedaran fichas  restantes,  entonces  pasará  el  turno.  Si  el  jugador  elige 
    una  ficha entonces  pregúntele  en  cuál  extremo  desea  agregarla  (izquierda  o derecha).  Verifique  que  la  ficha  sea  válida
    para  dicho  extremo  y  sino vuelva  a  preguntarle  desde  el  principio.  Si  la  ficha  es  válida  entonces agruéguela  al  tablero,
    en  la  posición  adecuada  y  remuévala  de  la  mano del jugador.

Método pedirComputadora hace exactamente lo mismo que pedirUsuario, pero la ficha a elegir será la primera ficha válida
    en la mano del  jugador  para  cualquiera  de  los  dos  extremos.  Si  no  posee  ninguna ficha  válida  procederá
    igual  que  jugador  (comer  ficha  continuamente  o pasar el turno si no quedan).

 */
package examendos;
import java.util.Scanner; //Para la entrada de datos.

/**
 *
 * @author emma
 */
public class Jugador {
    private ListaFichas fichasPrincipales; //Son las fichas del juego, cada clase las recibe porque pueden ser modificadas por referencia.
    private ListaFichas fichas; //Son las fichas que tiene cada jugador.
    private int puntosObtenidos; //Puntos que el usuario ha ido ganando a traves de las partidas.
    private String identificador; //Un identificar para cada jugador.
    private boolean esHumano; //Para saber si el jugador es humano o es la computadora.
    private ListaFichas tablero;
    private Scanner escaner;
    
    public Jugador(ListaFichas fichasJuego, boolean isHuman, String identifier, ListaFichas tableroJuego){
        this.fichasPrincipales = fichasJuego;
        this.fichas = new ListaFichas();
        this.puntosObtenidos = 0;
        this.identificador = identifier;
        this.esHumano = isHuman;
        this.escaner = new Scanner(System.in);
        this.tablero = new ListaFichas();
        this.tablero = tableroJuego;
    }
    
    /*
    Function: toma  una  ficha  al  azar  de  las restantes en el tablero, la agrega a las fichas de jugador y la remueve de las fichas restantes.
    Return: un -1 si ya no hay fichas, un 0 si pudo comer bien.
    */
    public int comerFicha(){
        int pudoComer=-1; //Asumo que nunca puedo comer.
        Ficha fichaComida = fichasPrincipales.pop();
        if(fichaComida!=null){
            int[] valores = fichaComida.getValores();
            fichas.add(valores[0], valores[1]);
            pudoComer=0;
            if(esHumano==true){
            System.out.println(identificador+" comio "+fichaComida.toStringFicha());
            } else {
                System.out.println(identificador+" comio una ficha.");
            }
        }
        return pudoComer;
    }
    /*
    Function: en base a lo que haya obtenido en la partida aumenta su puntaje.
    */
    public void aumentarPuntaje(int puntajeObtenido){puntosObtenidos+=puntajeObtenido;}
    /*
    Function: hace que el otro juegue, en base a si es una persona o la computadora.
    */
    public void pedirJugada(){
        if(esHumano==true){
            pedirUsuario();
        } else {
            pedirComputadora();
        }
    }
    
    /*
    Function: le pide al usuario la ficha que desea posicionar. Para  ello  debe  mostrarle  las  fichas  disponibles.
    Tambien  debe  darle  al usuario  la  opción  de  comerFicha,  en  caso  de  que  el  jugador  no  tenga ninguna  ficha  válida.
    Si  el  jugador  quisiera  comerFicha  y  no  quedaran fichas  restantes,  entonces  pasará  el  turno.  Si  el  jugador  elige 
    una  ficha entonces  pregúntele  en  cuál  extremo  desea  agregarla  (izquierda  o derecha).  Verifique  que  la  ficha  sea  válida
    para  dicho  extremo  y  sino vuelva  a  preguntarle  desde  el  principio.  Si  la  ficha  es  válida  entonces agruéguela  al  tablero,
    en  la  posición  adecuada  y  remuévala  de  la  mano del jugador.
    */
    public void pedirUsuario(){
        System.out.println("Tablero actual:");
        tablero.imprimirLista();
        System.out.println("Estas son sus fichas:");
        fichas.imprimirLista();
        System.out.println("Seleccione la ficha que desea usar; o digite '-1' para comer una ficha.");
        int decision = escaner.nextInt();
        if(decision!=-1){ //En caso que haya escogido hacer usar una de sus fichas.
            Ficha fichaEscogida = fichas.popByIndice(decision);
            System.out.println("Colocar en extremo izquierdo (i) o derecho (d)?");
            char extremo = (escaner.next()).charAt(0);
            if(esPosicionValida(extremo, fichaEscogida.getValor1(), fichaEscogida.getValor2())==true){ //Osea que si se puede poner ahi.
                if(extremo=='i'){ //Se agrega al inicio del tablero.
                    //Esto se hace para acomodarlo de la forma correcta.
                    if(tablero.getCabeza().getValor1()==fichaEscogida.getValor2()){
                        tablero.addAlPrincipio(fichaEscogida.getValor1(), fichaEscogida.getValor2());
                    } else {
                        tablero.addAlPrincipio(fichaEscogida.getValor2(), fichaEscogida.getValor1());
                    }
                } else{
                    if(tablero.getCola().getValor2()==fichaEscogida.getValor1()){
                        tablero.add(fichaEscogida.getValor1(), fichaEscogida.getValor2());
                    } else {
                        tablero.add(fichaEscogida.getValor2(), fichaEscogida.getValor1());
                    }
                }
            } else{
                System.out.println("Posicion invalida.");
                pedirUsuario(); //Vuelve a repetir todo.
            }
        } else { //En caso que haya decidido comer.
            if(comerFicha()==0){
                pedirUsuario();
            }
        }
    }
    
    /*
    Function: hace exactamente lo mismo que pedirUsuario, pero la ficha a elegir será la primera ficha válida
    en la mano del  jugador  para  cualquiera  de  los  dos  extremos.  Si  no  posee  ninguna ficha  válida  procederá
    igual  que  jugador  (comer  ficha  continuamente  o pasar el turno si no quedan).
    */
    public void pedirComputadora(){
        Ficha opcionEnCabeza = buscarFichaCabeza(tablero.getCabeza(), fichas.getCabeza(), 0);
        Ficha opcionEnCola = null;
        if(opcionEnCabeza==null){
            opcionEnCola = buscarFichaCola(tablero.getCola(), fichas.getCabeza(), 0);
        }
        if(opcionEnCabeza==null && opcionEnCola==null){ //Osea que no hay opciones
            if(comerFicha()==0){ //Osea que aun puede comer.
                pedirComputadora();
            }
        } else {
            if(opcionEnCabeza!=null){
                if(tablero.getCabeza().getValor1()==opcionEnCabeza.getValor2()){
                    tablero.addAlPrincipio(opcionEnCabeza.getValor1(), opcionEnCabeza.getValor2());
                } else {
                    tablero.addAlPrincipio(opcionEnCabeza.getValor2(), opcionEnCabeza.getValor1());
                }
            } else {
                if(tablero.getCola().getValor1()==opcionEnCola.getValor2()){
                    tablero.add(opcionEnCola.getValor1(), opcionEnCola.getValor2());
                } else {
                    tablero.add(opcionEnCola.getValor2(), opcionEnCola.getValor1());
                }
            }
        }
    }
    
    public ListaFichas getFichasPersonales(){return fichas;}
    public void setFichasPrincipales(ListaFichas fichasNuevas){fichasPrincipales=fichasNuevas;}
    public void setTablero(ListaFichas fichasNuevas){tablero=fichasNuevas;}
    public int getPuntaje(){return puntosObtenidos;}
    /*
    Function: averigua si es una posicion valida donde se desea agregar la nueva ficha, a la izquierda o a la derecha.
    */
    private boolean esPosicionValida(char lado, int valor1, int valor2){
        boolean valida=false;
        if(lado=='i'){ //Significa que es a la izquierda.
            if((tablero.getCabeza().getValor1() == valor1) || (tablero.getCabeza().getValor1() == valor2)){ //Osea que es una posicion valida.
                valida=true;
            }
        } else{ //significa que es a la derecha.
            if(lado=='d'){ //Lo pongo solo para recordar en caso de tener que editar el codigo.
                if((tablero.getCola().getValor2() == valor1) || (tablero.getCola().getValor2() == valor2)){ //Osea que es una posicion valida.
                    valida=true;
                }
            }
        }
        return valida;
    }
    
    public void posicionarPrimerFicha(){
        Ficha ficha = fichas.pop();
        tablero.add(ficha.getValor1(), ficha.getValor2());
    }
    public String getIndentificador(){return identificador;}
    
    /*
    Function: se usan solo para cuando es una computadora, se encarga de buscar si tiene un ficha que pueda usar en el tablero para poder jugar.
    */
    private Ficha buscarFichaCabeza(Ficha cabezaTablero, Ficha actual, int indice){
        if(actual!=null){
            return ((actual.getValor1()==cabezaTablero.getValor1()) || (actual.getValor2()==cabezaTablero.getValor1())) ? fichas.popByIndice(indice) : buscarFichaCabeza(cabezaTablero, actual.getSiguiente(), indice+1);
        } else {
            return null;
        }
    }
    
    private Ficha buscarFichaCola(Ficha colaTablero, Ficha actual, int indice){
        if(actual!=null){
            return ((actual.getValor1()==colaTablero.getValor2()) || (actual.getValor2()==colaTablero.getValor2())) ? fichas.popByIndice(indice) : buscarFichaCola(colaTablero, actual.getSiguiente(), indice+1);
        } else{
            return null;
        }
    }
}
