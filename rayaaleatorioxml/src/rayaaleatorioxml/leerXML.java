package rayaaleatorioxml;

import java.util.Arrays;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="game")
@XmlType(propOrder={"tipo","tamaño","jugadores","nombre","fichaActual","turno"})
@XmlAccessorType(XmlAccessType.FIELD)

public class leerXML {    
    @XmlElement(name="type")
    String tipo;
    
    @XmlElement(name="size")
    private int tamaño;
    
    @XmlElementWrapper(name="players")
    @XmlElement (name="player")
    Jugador [] jugadores;
    
    @XmlElement(name="name")
    private String nombre;
    
    @XmlElement(name="file")
    private String fichaActual;
    
    @XmlElement(name="turn")
    private int turno;

    public leerXML(){
        
    }
    public leerXML(String tipo,int tamaño,Jugador [] jugadores){
        this.tipo=tipo;
        this.tamaño=tamaño;
        this.jugadores=new Jugador[0];
    }
    
    public void nuevoJugador(String nombre,String fichaActual,int turno){
        Jugador nuevo;
        jugadores=Arrays.copyOf(jugadores, jugadores.length+1);
        this.nombre=nombre;
        this.fichaActual=fichaActual;
        this.turno=turno;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFichaActual() {
        return fichaActual;
    }

    public int getTurno() {
        return turno;
    }   

    
}

