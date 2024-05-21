package rayaaleatorioxml;

import java.util.Scanner;
import javax.xml.bind.annotation.*;

@XmlRootElement (name="player")
@XmlType(propOrder = {"nombre","fichaActual","turno"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Jugador{
    @XmlElement(name="name")
    private String nombre;
    @XmlElement(name="file")
    private String fichaActual;
    @XmlElement(name="turn")
    private int turno;
    
    public Jugador(){
        this.nombre=null;
        this.fichaActual=" ";
        this.turno=' ';
    }
    
    //Constructor
    public Jugador(String nombre, String fichaActual, int turno){
        this.fichaActual=fichaActual;
        this.nombre=nombre;
        this.turno=turno;
    }

    public String getFicha() {
        return fichaActual;
    }

    public void setFicha(String fichaActual) {
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

