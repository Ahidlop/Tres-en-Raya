package rayaaleatorioxml;

import java.io.File;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class MainXml {
    public static void main(String[] args) throws JAXBException {
    Scanner sc = new Scanner (System.in);

        try{
            JAXBContext contexto= JAXBContext.newInstance(Juegos.class);
            Unmarshaller um = contexto.createUnmarshaller();
            Juegos games = (Juegos) um.unmarshal(new File("C:\\Users\\aleja\\OneDrive\\Documentos\\NetBeansProjects\\rayaaleatorioxml\\src\\rayaaleatorioxml\\tresenraya.xml"));
            AbstractJuego [] game = new AbstractJuego[games.j1.length];
            game=eleccionTipo(game, games);
            iniciarJuegos(game);
            Rellenar(game);
        }catch (JAXBException e){
            System.out.println(e);
        }
    }
    
        public static AbstractJuego [] eleccionTipo(AbstractJuego [] game, Juegos games ){
        for(int i=0; i<game.length;i++){
                if(games.j1[i].getTipo().compareTo("Tablero")==0){
                    game[i]=new LogicaJuego(games.j1[i].getTamaño());
                }
                else{
                    game[i]=new LogicaAleatorio();
                }
                game[i].jugadores = new Jugador[games.j1[i].jugadores.length];

                for (int j= 0; j< games.j1[i].jugadores.length; j++) {
                    game[i].jugadores[j]= new Jugador(games.j1[i].jugadores[j].getNombre(), games.j1[i].jugadores[j].getFicha(), games.j1[i].jugadores[j].getTurno());
                }
            }
        return game;
    }
        
        public static void Jugar (AbstractJuego [] game){
            for(int i=0; i<game.length;i++){
                game[i].iniciar();
            }
        }
        public static void Rellenar (AbstractJuego [] game){
            for(int i=0; i<game.length;i++){
                game[i].rellenarTurnos();
            }
        }
        
        /*
    public static Juego [] crearJuego(Scanner sc){
        int njuegos;

        System.out.println("¿A cuántos juegos queréis jugar?");
        njuegos=sc.nextInt();
        
        Juego [] j1 = new Juego[njuegos];
       
        for (int i=0; i<j1.length; i++){
            int elecc;
            System.out.println("Elige "+(i+1)+"º Juego: 1. Aleatorio , 2.N en raya");
            do{
                elecc=sc.nextInt();
            }while (elecc>2||elecc<1);
            if (elecc==1){
                System.out.println((i+1)+".Aleatorio");
                j1[i]=new LogicaAleatorio();
            }
            else{
                System.out.println((i+1)+".Tablero");
                j1[i]= new LogicaJuego();
            }
        }   
        return j1;
    }

    */
    public static void iniciarJuegos (AbstractJuego [] j1)
    {
        boolean win, salir=false;
        int contador=0;
        
        for (int i=0; i<j1.length ;i++){
            j1[i].iniciar();
        }
        while(!salir){
            
            for (int i=0; i<j1.length ;i++){ //recorre cada tablero
                if (j1[i].terminado()==false){
                    System.out.println("Juego "+(i+1));
                    win=j1[i].rellenarTurnos();
                    if (win){
                        
                        contador++;
                        win=false;
                    } 
                    if (contador==(j1.length)){
                            salir=true;
                        }
                }
                else{
                    System.out.println("Juego "+(i+1)+" terminado");
                } 
                
            }
        }
    }  
    
}
