package rayaclaseobjeto;

import java.util.Scanner;

public class Tablero{
    char [][] tablero;
    private int contador=0;
    Scanner sc = new Scanner (System.in);
    
    public Tablero(int n){
        tablero= new char [n][n];
    }
     public char [][] vacioTablero()
    {
        for(int i=0;i<tablero.length;i++)
            {
            for(int j=0;j<tablero.length;j++)
                {
                System.out.print(tablero[i][j]=' ');
                if(j<tablero.length-1)
                    System.out.print(" | ");
                }
            System.out.println(" ");
            if (i<tablero.length-1)
                System.out.println("----------");
            }  
        return tablero;
    }
    
    public void imprimirTablero()
    {
        for(int i=0;i<tablero.length;i++)
            {
            for(int j=0;j<tablero.length;j++)
                {
                System.out.print(tablero[i][j]);
                if(j<tablero.length-1)
                    System.out.print(" | ");
                }
                System.out.println(" ");
                if (i<tablero.length-1)
                System.out.println("----------");
            }  
    }
    
    //Method rellenar tablero 
    public void rellenarTablero (Jugador actual)
    {
        int fila,columna;
        
        do{
            System.out.println("Elija " +actual.getNombre()+ " una fila");
            fila=sc.nextInt();
            System.out.println("Elija " +actual.getNombre()+ " una columna");
            columna=sc.nextInt();
        }while(fila>tablero.length-1 || columna>tablero.length-1 || fila<0 || columna<0 || tablero[fila][columna]!=' ');
        if (tablero [fila][columna]==' ')
            { 
            tablero [fila][columna]=actual.getFicha();
            }
        contador++;
    }
    
    public boolean comprobar (Jugador[]jugadores){
        
        boolean win=false;
        int [] puntoFicha = new int [tablero.length];
        int [] ganaFicha = new int [tablero.length];
        
        int num=0;
        
        /*for (int i=0; i<tablero.length; i++){
            num = (num*tablero.length)+1;
            puntoFicha[i]=num;
        }

        for(int i=0; i<tablero.length;i++){
            ganaFicha[i]= (puntoFicha[i]*tablero.length);
        }*/
        
        win=comprobarFilas(win, jugadores);
        /*if (!win)
        {
            win=comprobarColumnas (win, puntoFicha, ganaFicha, jugadores); 
            if (!win){
                win=comprobarDiagonaluno(win, puntoFicha, ganaFicha, jugadores);
                if (!win){
                    win=comprobarDiagonaldos(win, puntoFicha, ganaFicha, jugadores);
                    if (!win){
                        empate(jugadores);
                    }
                }
            }

        }*/
        return win;
    }

    public boolean comprobarFilas (boolean win,  Jugador [] jugadores)
    {
        int revancha;
        int contador=0;
        
        for (int i=0;(i<tablero.length && !win);i++)
        {
            boolean salir=false;
            for (int j=0;(j<tablero.length && !salir && !win);j++)
            {
                //array de jugadores
                if (tablero[i][j]==' ' ){
                    salir=true;
                    contador=0;
                }
                else if(tablero[i][j]==tablero[i][++j]){
                    --j;
                    ++contador;
                }
                else{
                    salir=true;
                    contador=0;
                }
                
                
                if (contador==(tablero.length-1)){
                    for (int k=0; k<jugadores.length && !win; k++){
                        if (jugadores[k].getFicha()==tablero[i][j]){
                            System.out.println("Has ganado "+ jugadores[k].getNombre()+ " con ficha "+ jugadores[k].getFicha());
                            win=true;
                        }
                    }
                }
                
            }
            
                /*
                if (tablero[i][j]==J1.getFicha()){
                    contador=contador+x;
                }
                else if(tablero[i][j]==J2.getFicha()){
                    contador=contador+y;
                }
            }
            if(contador==ganaX){
                win=true;
                System.out.println("Ha ganado el jugador "+J1.getNombre());
            }
            else if(contador==ganaY){
                win=true;
                System.out.println("Ha ganado el jugador "+J2.getNombre());
            }   
            else{
                contador=0;
            }*/
        }
        
        return win;
    }

    public boolean comprobarColumnas (boolean win, int x, int y, int ganaX, int ganaY, Jugador J1,Jugador J2)
    {
        for (int j=0;(j<tablero.length && !win);j++)
        {
            for (int i=0;(i<tablero.length);i++)
            {
                if (tablero[i][j]==J1.getFicha()){
                    contador=contador+x;
                }
                else if(tablero[i][j]==J2.getFicha()){
                    contador=contador+y;
                }
            }
            if(contador==ganaX){
                win=true;
                System.out.println("Ha ganado el jugador "+J1.getNombre());
            }
            else if(contador==ganaY){
                win=true;
                System.out.println("Ha ganado el jugador "+J2.getNombre());
            }
            else{
                contador=0;
            }
        }
        return win;
    }

     public boolean comprobarDiagonaluno (boolean win, int x, int y, int ganaX, int ganaY, Jugador J1,Jugador J2)
    {
        int i=0,j=0;
        //Primera diagonal
        do{
                if (tablero[i][j]==J1.getFicha()){
                    contador+=x;
                }
                else if(tablero[i][j]==J2.getFicha()){
                    contador+=y;
                }
                i++;
                j++;
            }while (i<tablero.length && j<tablero.length);
            if(contador==ganaX){
                win=true;
                System.out.println("Ha ganado el jugador "+J1.getNombre());
            }
            else if(contador==ganaY){
                win=true;
                System.out.println("Ha ganado el jugador "+J2.getNombre());
            }
            return win;
        }
     
     public boolean comprobarDiagonaldos (boolean win, int x, int y, int ganaX, int ganaY, Jugador J1,Jugador J2){
        int i=0,j=tablero.length-1;
        //Primera diagonal
        do{
                if (tablero[i][j]==J1.getFicha()){
                    contador=contador+x;
                }
                else if(tablero[i][j]==J2.getFicha()){
                    contador=contador+y;
                }
                i++;
                j--;
            }while (i<tablero.length && j>=0);
            if(contador==ganaX){
                win=true;
                System.out.println("Ha ganado el jugador "+J1.getNombre());
            }
            else if(contador==ganaY){
                win=true;
                System.out.println("Ha ganado el jugador "+J2.getNombre());
            }
            return win;
    }
    public void empate (Jugador J1,Jugador J2){
        int empat = ((tablero.length)*(tablero.length));
        boolean salir=false;
        for (int i=0; (i<tablero.length );i++){
             for (int j=0; j<tablero.length && !salir ;j++){
                 if (tablero[i][j]!=' '){
                    contador++;
                    }
                 else{
                     salir=true;
                 }
                }
             }
         if (contador==empat){
             System.out.println("Looser, habeis empatado, comenzad de nuevo bro "+J1.getNombre()+" , "+J2.getNombre());
             vacioTablero();
         }
             
         }
    
    public boolean revancha (boolean win){
        int rev;
        if (win){
            System.out.println("¿Queréis la revancha?");
            System.out.println("1.Si");
            System.out.println("2.No");
            do{
                rev=sc.nextInt();
            }while (rev>2 || rev<1);
            if (rev==1){
                vacioTablero ();
                win=false;
            }
            else{
                System.out.println("Fin del juego");
            }       
        }
        return win;
}

}
