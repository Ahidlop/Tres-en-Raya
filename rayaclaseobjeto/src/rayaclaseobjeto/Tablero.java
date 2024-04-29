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
        int num=0;
        
        
        win=comprobarFilas(win, jugadores);
        if (!win)
        {
            win=comprobarColumnas (win, jugadores); 
            if (!win){
                win=comprobarDiagonaluno(win, jugadores);
                if (!win){
                    win=comprobarDiagonaldos(win, jugadores);
                    if (!win){
                        empate(jugadores);
                    }
                }
            }
        }
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
        }
        
        return win;
    }

    public boolean comprobarColumnas (boolean win,  Jugador [] jugadores)
    {
        int revancha;
        int contador=0;
        
        for (int j=0;(j<tablero.length  && !win);j++)
        {
            boolean salir=false;
            for (int i=0;(i<tablero.length && !win && !salir);i++)
            {
                //array de jugadores
                if (tablero[i][j]==' ' ){
                    salir=true;
                    contador=0;
                }
                else if(tablero[i][j]==tablero[++i][j]){
                    --i;
                    ++contador;
                }
                else{
                    salir=true;
                    contador=0;
                    --i;
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
        }
        
        return win;
    }

     public boolean comprobarDiagonaluno (boolean win,  Jugador [] jugadores)
    {
        int i=0,j=0;
        boolean salir=false;
        int contador=0;
        //Primera diagonal
        do{
            if (tablero[i][j]==' ' ){
                salir=true;
                contador=0;
            }
            else if(tablero[i][j]==tablero[++i][++j]){
                
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
            
        }while (i<tablero.length && j<tablero.length && !salir && !win);
            
        return win;
    }
     
     public boolean comprobarDiagonaldos (boolean win,  Jugador [] jugadores){
        int i=0,j=tablero.length-1;
        //Segunda diagonal
        
        boolean salir=false;
        int contador=0;

        do{
            if (tablero[i][j]==' ' ){
                salir=true;
                contador=0;
            }
            else if(tablero[i][j]==tablero[++i][--j]){
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
            
        }while (i<tablero.length && j>0 && !salir && !win);
        
        return win;
    }
    public void empate (Jugador [] jugadores){
        int empat = ((tablero.length)*(tablero.length));
        int contador=0;
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
             System.out.println("Looser, habeis empatado, comenzad de nuevo bro ");
             vacioTablero();
         }
             
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
