package rayaaleatorioxml;

import java.util.Scanner;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="games")
@XmlType(propOrder={"j1"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Juegos {
    @XmlElement (name="game")
    leerXML [] j1;
    
    public Juegos(){

    }
    
    public Juegos(leerXML [] j1){
        this.j1=j1;
    }
    
    /*public AbstractJuego [] getJuegos(){
        for(int i=0; i<j1.length;i++){
            System.out.println(j1[i].getTipo());
        }
        return j1;
    }*/


    
}    


