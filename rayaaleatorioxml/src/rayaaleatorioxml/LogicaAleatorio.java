package rayaaleatorioxml;

import java.util.Scanner;

public class LogicaAleatorio extends AbstractJuego{
    public boolean win;  
    private Aleatorio aleatorio;
    int adivina;
    Scanner sc = new Scanner (System.in);
        
    //Constructor
    public LogicaAleatorio (){

    }
    
    public LogicaAleatorio(String tipo, Jugador[]jugadores)
    {
       this.jugadores=jugadores;
       this.win=false;
       iniciar();
    }

    public String getTipo() {
        return "Aleatorio";
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public boolean isWin() {
        return win;
    }
    
    public int getTamaño(){
        int tamaño=' ';
        return tamaño;
    }
    @Override
    public void iniciar(){
        aleatorio = new Aleatorio();
        Scanner sc= new Scanner(System.in);
        if(jugadores==null){
            crearJugadores();
            imprimirJugadores();
        }
        else{
            imprimirJugadores();
        }
        
        adivina=aleatorio.generarNum();
        if(!win){
        rellenarTurnos();
        }
    }
    
    public boolean rellenarTurnos(){
        
        for (int i=0; i<jugadores.length && !win; i++){
                int intento;
                System.out.println(jugadores[i].getNombre() + ", introduzca su intento");
                intento=sc.nextInt();
                win =aleatorio.comprobar(adivina, intento, win);
            } 
                        
            if (win==true){
                win=aleatorio.revancha(win);
            }

    return win;
}

}

