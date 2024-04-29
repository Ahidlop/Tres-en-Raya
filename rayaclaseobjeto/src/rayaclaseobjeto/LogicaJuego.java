
package rayaclaseobjeto;
import java.util.Scanner;

public class LogicaJuego extends Juego{
    
    private Tablero tablero;
    Scanner sc = new Scanner (System.in);
    boolean terminado = false;
    //Constructor
    public LogicaJuego (){
        iniciar();
    }
    
    
    
    public void iniciar(){
        int n;
        boolean win=false; 
        
        crearJugadores();
        imprimirJugadores();
        
        n=3;
        System.out.println("¿A qué n en ralla queréis jugar?");
        n=sc.nextInt();
        
        /*int nTableros;
        System.out.println("¿A cuantos juegos queréis jugar?");
        Tablero [nTableros] tableros;
        for (int i=0; i<tableros.length; i++){
            tableros[i]=new Tablero();
        }
        */
        tablero = new Tablero(n);
        
        tablero.vacioTablero();
        if(!win){
            win=rellenarTurnos();
        }
        
        
    }
    public boolean terminado(){
        boolean terminado;
        if(!win){
            terminado=false;
        }
        else{
            terminado=true;
        }
        return terminado;
    }
    
    public boolean rellenarTurnos(){
        
            for (int i=0; i<jugadores.length && !win; i++){
                tablero.imprimirTablero();
                tablero.rellenarTablero(jugadores[i]);
                tablero.imprimirTablero();
                win =tablero.comprobar(jugadores);
            } 
                        
            if (win==true){
                win=tablero.revancha(win);
            }

    return win;
}
}
