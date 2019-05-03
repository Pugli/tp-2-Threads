package LaboratorioV;

import Models.Jugador;
import Models.Tablero;
import Threads.Hilo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Jugador j1 = new Jugador("agustin");
        Tablero t1 = new Tablero();
        Jugador j2 = new Jugador("ROBERTO");
        Tablero t2 = new Tablero();

        Hilo h1 = new Hilo(t1, j1);
        Hilo h2 = new Hilo(t1, j2);

        h1.start();
        h2.start();

        /*Thread hilo1 = new Thread(h1);
        Thread hilo2 = new Thread(h1);

        hilo1.start();
        hilo2.start();
*/
        try{
            h1.join();
            h2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (h1.isWin()) {
            System.out.println("HAZ GANADO!!!"+j1.getName());
        }else{
            System.out.println("VUELVE A INTENTARLO!!!"+j1.getName());
        }

        if (h2.isWin()) {
            System.out.println("HAZ GANADO!!!"+j2.getName());
        }else{
            System.out.println("VUELVE A INTENTARLO!!!"+j2.getName());
        }


    }
}
