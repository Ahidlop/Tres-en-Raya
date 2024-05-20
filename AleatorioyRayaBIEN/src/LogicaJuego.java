
import java.util.Scanner;

public class LogicaJuego extends Juego{
    
    private Tablero tablero;
    Scanner sc = new Scanner (System.in);
    boolean terminado = false;
    //Constructor
    public LogicaJuego (){
        iniciar();
    }
    
    
    
    @Override
    public void iniciar(){
        int n;
        boolean win=false; 
        
        crearJugadores();
        imprimirJugadores();
        
        System.out.println("¿A qué n en ralla queréis jugar?");
        n=sc.nextInt();
        
        tablero = new Tablero(n);
        
        tablero.vacioTablero();
        if(!win){
            win=rellenarTurnos();
        }
        
        
    }
    
    
    public boolean rellenarTurnos(){
        tablero.imprimirTablero();
            for (int i=0; i<jugadores.length && !win; i++){
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

