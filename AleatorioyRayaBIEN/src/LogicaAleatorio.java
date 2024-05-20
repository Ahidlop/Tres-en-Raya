import java.util.Scanner;

public class LogicaAleatorio extends Juego{
        private Aleatorio aleatorio;
        int adivina;
        boolean terminado = false;
        Scanner sc = new Scanner (System.in);
        
    //Constructor
    public LogicaAleatorio (){
        aleatorio = new Aleatorio();
        iniciar();
    }
    
    @Override
    public void iniciar(){
        Scanner sc= new Scanner(System.in);
        crearJugadores();
        imprimirJugadores();
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

