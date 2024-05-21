
package rayaaleatorioxml;

import java.util.Scanner;

public abstract class AbstractJuego {
    Jugador [] jugadores;
   
    Scanner sc;
    
    public AbstractJuego(){
        sc=new Scanner(System.in);
        
    }
        public int eleccionJugadores(){
        int i;
        System.out.println("¿Cuántos jugadores vais a ser?");
        i=sc.nextInt();
        return i;
    }
    
    public void crearJugadores(){
        String nombre;
        String ficha;
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
            if(turno==jugadores[i].getTurno()){ 
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
    
    
    public String comprobarFicha (int numJugadorMayor){
        String ficha;
        System.out.println("Introduzca su ficha"); 
        ficha=sc.next(); 
        
        for(int i=0; i<numJugadorMayor; i++){
            if(ficha==jugadores[i].getFicha()){ 
                System.out.println("Su ficha no puede ser igual a la de otro jugador, introduzca de nuevo");
                ficha=sc.next(); 
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
    public boolean terminado(){
        boolean terminado;
        if(!isWin()){
            terminado=false;
        }
        else{
            terminado=true;
        }
        return terminado;
    }
    public abstract boolean isWin();
    public abstract void iniciar ();
    public abstract boolean rellenarTurnos();
    public abstract String getTipo();
}
