
package rayaclaseobjeto;
import java.util.Scanner;

public class LogicaJuego {
    private Jugador [] jugadores;
    int nJugadores;
    private boolean win;
    private Tablero tablero;

    Scanner sc = new Scanner (System.in);
    
    //Constructor
    public LogicaJuego (){
        nJugadores=eleccionJugadores();
        this.jugadores=new Jugador [nJugadores];
        this.win=false;
        iniciar();
    }
    
    public int eleccionJugadores(){
        int i=2;
        System.out.println("¿Cuántos jugadores vais a ser?");
        i=sc.nextInt();
        return i;
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
        
        while (!win){
            for (int i=0; i<jugadores.length && !win; i++){
                tablero.rellenarTablero(jugadores[i]);
                tablero.imprimirTablero();
                win =tablero.comprobar(jugadores);
            } 
                        
            if (win==true){
                win=tablero.revancha(win);
            }
        }
    }
    
    public void crearJugadores(){
        String nombre;
        char ficha;
        int turno;
        
        Jugador [] jugadoresAux = new Jugador [jugadores.length];
        
        for (int i =0;i<jugadores.length;i++){
            System.out.println("Introduzca el nombre del jugador");
            nombre=sc.next();
            
            ficha=comprobarFicha(i);       
            
            turno=elegirTurno(i);
            
            jugadores[i]= new Jugador (nombre, ficha, turno);
            jugadoresAux[(jugadores[i].getTurno()-1)]=jugadores[i];
            
        }
        jugadores=jugadoresAux;
    }
    public int elegirTurno (int numJugadorMayor){
        int turno; 
        do{
            System.out.println("Cual será tu turno?");
            turno=sc.nextInt();
            if (turno>jugadores.length || turno<1){
                System.out.println("Solo son válidos los turnos del 1 al "+jugadores.length+" , introduzca de nuevo:");
            }
        }while(turno>jugadores.length  || turno<1 );
        
        for(int i=0; i<numJugadorMayor; i++){
            if(turno==jugadores[i].getTurno()){ //FAALLO, NO PUEDO GET TURNO SI NO EXISTE!!!
                    System.out.println("Su turno no puede ser igual al turno de otro jugador, introduzca de nuevo");
                    i=-1;
                    do{
                        turno=sc.nextInt();
                        if (turno>jugadores.length || turno<1){
                            System.out.println("Solo son válidos los turnos del 1 al "+jugadores.length+" , introduzca de nuevo:");
                        }
                    }while(turno>jugadores.length  || turno<1 ); 
            }
        }
        return turno;
    }      
    
    
    public char comprobarFicha (int numJugadorMayor){
        char ficha;
        System.out.println("Introduzca su ficha"); 
        ficha=sc.next().charAt(0); 
        
        for(int i=0; i<numJugadorMayor; i++){
            if(ficha==jugadores[i].getFicha()){ 
                System.out.println("Su ficha no puede ser igual a la de otro jugador, introduzca de nuevo");
                ficha=sc.next().charAt(0); 
                i=-1;                      
            }
        }
        return ficha;
    } 
    
    
    public void imprimirJugadores(){
        for (int i=0; i<jugadores.length; i++){
            System.out.println(i+1+"º Jugador;");
            jugadores[i].imprimirJugadores();
        }
    }
 
}
