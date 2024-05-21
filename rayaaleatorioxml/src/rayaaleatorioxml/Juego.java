package rayaaleatorioxml;


import java.util.Scanner;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="game")
@XmlType(propOrder={"tipo","tamaño","jugadores"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Juego{
    @XmlElement(name="type")
    String tipo;
    
    @XmlElement(name="size")
    private int tamaño;
    
    @XmlElementWrapper(name="players")
    @XmlElement (name="player")
    public Jugador [] jugadores;
    @XmlTransient
    boolean win;
    @XmlTransient
    Scanner sc = new Scanner (System.in);
    
    public Juego()
    {
        //this.jugadores=new Jugador [eleccionJugadores()];
        //this.win=false; 
    }
    public Juego (String tipo, int tamaño, Jugador[]jugadores){
        this.tipo=tipo;
            this.tamaño=tamaño;
            this.jugadores=jugadores;
            this.win=false;
    }

    public String getTipo() {
        return tipo;
    }
    


}

