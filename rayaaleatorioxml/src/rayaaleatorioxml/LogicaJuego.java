package rayaaleatorioxml;


import java.util.Scanner;

public class LogicaJuego extends AbstractJuego{
    public boolean win;
    Scanner sc = new Scanner (System.in);
    private Tablero tablero;    
    int tamaño;
    //Constructor
    public LogicaJuego (){

    }
    public LogicaJuego(int tamaño){
        this.tamaño=tamaño;
    }
    public LogicaJuego(int tamaño, Jugador[]jugadores, boolean win)
    {
       this.tamaño=tamaño;
       this.jugadores=jugadores;
       this.win=false;
    }
    
    @Override
    public void iniciar(){
        int n;
        boolean win=false; 
        if(jugadores==null){
            crearJugadores();
            imprimirJugadores();
        }
        else{
            imprimirJugadores();
        }
        
        if (tamaño==' '){
            System.out.println("¿A qué n en ralla queréis jugar?");
            n=sc.nextInt();
        }
        else{
            n=tamaño;
        }
       
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
    public boolean isWin(){
        return win;
    }
    public String getTipo(){
        return "Tablero";
    }
}

