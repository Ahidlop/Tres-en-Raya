import java.util.Scanner;

public class Jugador {
    private char fichaActual;
    private String nombre;
    private int turno;
    
    //Constructor
    public Jugador( String nombre, char fichaActual, int turno){
        this.fichaActual=fichaActual;
        this.nombre=nombre;
        this.turno=turno;
    }

    public char getFicha() {
        return fichaActual;
    }

    public void setFicha(char fichaActual) {
        this.fichaActual = fichaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTurno() {
        return turno;
    }    
    
    public void setTurno(int turno) {
        this.turno = turno;
    } 
    
    public void imprimirJugadores(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Ficha: "+fichaActual);
        System.out.println("Turno: "+turno);
    }
}

