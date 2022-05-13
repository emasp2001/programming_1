/*
 * Metodos necesarios:
Método juego que  debe  preguntar  al  usuario  hasta cuantos  puntos  desea  jugar  e  iniciará  partidas  nuevas hasta  que  algún jugador gane.
Los jugadores empezarán con 0 puntos y el jugador inicial será elegido al azar. Al finalizar el juego imprima el resultado final de los jugadores.

Método  partida  que  empieza  una  partida  de 0, cada jugador empieza con 7 fichas al azar y el tablero empieza vacío. Al iniciar cada  partida
recuede  alternar  los  jugadores  iniciales.  Cada  turno,  se imprimirá  el  tablero  actual  y  al  jugador  actual  se  le  pedirá  que  elija
una ficha a posicionar. Luego se le pedirá al siguiente jugador lo mismo y se continuará  hasta  que  alguno  de  los  jugadores  quede  sin  fichas
en  mano o  ninguno  de  los  2  jugadores  pueda  poner  una  ficha  (asuma  que  el jugador  humano  es  honrado  y  solo  pasa  el  turno  si  no
le  quedan  fichas válidas).  Cuando  esto  ocurra  deberá  agregar  los  puntos  adecuados  al jugador  ganador.  Al  finalizar  una  partida  imprima
el  estado  final  del tablero y el puntaje actual de cada jugador.

 */
package examendos;
import java.util.Scanner; //Para la entrada de datos.

/**
 *
 * @author emma
 */
public class Juego {
    private Jugador jugadorHumano; 
    private Jugador jugadorCP;
    private ListaFichas fichasDisponibles;
    private ListaFichas tablero;
    private int puntajeAlcanzar; //Puntos que deben alcanzar los jugadores para poder ganar.
    private Scanner escaner;
    private int cantidadFichasIniciar;
 
    /*
    Function: preguntar  al  usuario  hasta cuantos  puntos  desea  jugar  e  iniciará  partidas  nuevas hasta  que  algún jugador gane.
    Los jugadores empezarán con 0 puntos y el jugador inicial será elegido al azar. Al finalizar el juego imprima el resultado final de los jugadores.  
    */
    public Juego(){
        this.escaner = new Scanner(System.in);
        System.out.println("Cuantos puntos desea que se requieran para ganar el juego?");
        this.puntajeAlcanzar = escaner.nextInt();
        this.fichasDisponibles = new ListaFichas();
        this.tablero = new ListaFichas();
        llenarFichasDisponibles();
        this.jugadorHumano = new Jugador(fichasDisponibles, true, "Emmanuel", tablero);
        this.jugadorCP = new Jugador(fichasDisponibles, false, "Maquina", tablero);
        this.cantidadFichasIniciar = 7;
        
        //Inicia el juego.
        while(jugadorHumano.getPuntaje()<puntajeAlcanzar && jugadorCP.getPuntaje()<puntajeAlcanzar){
           partida();
        }
        String ganador = "";
        if(jugadorHumano.getPuntaje()>jugadorCP.getPuntaje()){ganador=jugadorHumano.getIndentificador();}else{ganador=jugadorCP.getIndentificador();}
        System.out.println("El ganado es: "+ganador);
    }
    
    /*
    Function: empieza  una  partida  de 0, cada jugador empieza con 7 fichas al azar y el tablero empieza vacío. Al iniciar cada  partida
    recuede  alternar  los  jugadores  iniciales.  Cada  turno,  se imprimirá  el  tablero  actual  y  al  jugador  actual  se  le  pedirá  que  elija
    una ficha a posicionar. Luego se le pedirá al siguiente jugador lo mismo y se continuará  hasta  que  alguno  de  los  jugadores  quede  sin  fichas
    en  mano o  ninguno  de  los  2  jugadores  pueda  poner  una  ficha  (asuma  que  el jugador  humano  es  honrado  y  solo  pasa  el  turno  si  no
    le  quedan  fichas válidas).  Cuando  esto  ocurra  deberá  agregar  los  puntos  adecuados  al jugador  ganador.  Al  finalizar  una  partida  imprima
    el  estado  final  del tablero y el puntaje actual de cada jugador.
    */
    private void partida(){
        fichasDisponibles.vaciarLista();
        llenarFichasDisponibles();
        tablero.vaciarLista();
        
        jugadorHumano.setFichasPrincipales(fichasDisponibles);
        jugadorHumano.setTablero(tablero);
        jugadorCP.setFichasPrincipales(fichasDisponibles);
        jugadorCP.setTablero(tablero);
        
        int contador=0;
        while(contador!=cantidadFichasIniciar){
            jugadorHumano.comerFicha();
            jugadorCP.comerFicha();
            contador++;
        }
        
        System.out.println("Maquina ha puesto una ficha inicial.");
        jugadorCP.posicionarPrimerFicha();
        while(jugadorHumano.getFichasPersonales()!=null || jugadorCP.getFichasPersonales()!=null){
            jugadorHumano.pedirUsuario();
            tablero.imprimirLista();
            jugadorCP.pedirComputadora();
            System.out.println(jugadorCP.getIndentificador()+" coloco una ficha.");
        }
        //Se hace para aumentar los puntos del otro jugador, ademas no es posible que ambos se queden sin fichas al mismo tiempo. Y en este punto uno de los dos ya se quedo sin puntos.
        if(jugadorHumano.getFichasPersonales()==null){ //Significa que el usuario se quedo sin fichas y por ende gano.
            jugadorHumano.aumentarPuntaje(jugadorCP.getFichasPersonales().getCabeza().getValorTotal());
        } else{
            jugadorCP.aumentarPuntaje(jugadorHumano.getFichasPersonales().getCabeza().getValorTotal());
        }
        System.out.println("Puntaje final de partida: "+jugadorHumano.getPuntaje()+"-"+jugadorCP.getPuntaje());
    }
    
    public Jugador getJugadorHumano(){return jugadorHumano;}
    public Jugador getJugadorCP(){return jugadorCP;}
    private void llenarFichasDisponibles(){
        int contador = 0;
        while(contador<29){
            agregarElementoSinRepetir();
            contador++;
        }
    }
    
    /*
    Function: se encargar de agregar una ficha en fichasDisponibles pero solo lo agrega si el elemento no existe aun en la lista.
    */
    private void agregarElementoSinRepetir(){
        int aleatorio1 = (int)(Math.random()*7);
        int aleatorio2 = (int)(Math.random()*7);
        
        if(fichasDisponibles.contains(fichasDisponibles.getCabeza(), aleatorio1, aleatorio2)==false){ //Osea que no existe ese valor.
            fichasDisponibles.add(aleatorio1, aleatorio2);
        } else {
            agregarElementoSinRepetir();
        }
    }
}
