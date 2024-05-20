import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Juego [] j1= crearJuego(sc);
        continuarJuego(j1);
        
    }
    
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
    
    public static void continuarJuego (Juego [] j1)
    {
        boolean win, salir=false;
        int contador=0;
        
        while(!salir){
            for (int i=0; i<j1.length ;i++){ //recorre cada tablero
                if (j1[i].terminado()==false){
                    System.out.println("Juego "+(i+1));
                    win=j1[i].rellenarTurnos();
                    if (win){
                        contador++;
                        win=false;
                    } 
                }
                else{
                    System.out.println("Juego "+(i+1)+" terminado");
                } 
                
                if (contador==(j1.length)){
                salir=true;
                }
            }
            
        }
    }   
}


