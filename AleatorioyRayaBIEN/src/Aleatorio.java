import java.util.Random;
import java.util.Scanner;

public class Aleatorio {
    int adivina;
    boolean win=false;
    boolean terminado=false;
    Scanner sc= new Scanner(System.in);
    
    public Aleatorio(){
        
    }

    public int generarNum(){
        int max;
        Random aleat = new Random();
        System.out.println("Voy a generar un número aleatorio a adivinar, ¿cuál queréis que sea el máximo?");
        max=sc.nextInt();
        adivina=aleat.nextInt(max);
        System.out.println("Ya he generado el número, que comience el juego!");
        return adivina;
    }
    
    public boolean comprobar(int adivina, int intento, boolean win){
        if (adivina==intento){
            win=true;
            System.out.println("Has ganado!!");
        }
        else{
            System.out.println("Intentalo de nuevo");
        }
        return win;
    }
    
    public boolean revancha (boolean win){
        int rev;
        if (win){
            do{
                System.out.println("¿Queréis la revancha?");
                System.out.println("1.Si");
                System.out.println("2.No");
                rev=sc.nextInt();
            }while (rev>2 || rev<1);
            
            if (rev==1){
                generarNum();
                win=false;
            }
            else{
                System.out.println("Fin del juego");
            }       
        }
        return win;
    }
}

