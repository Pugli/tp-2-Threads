package Threads;

import Models.Jugador;
import Models.Tablero;

public class Hilo extends Thread {

    private Tablero tablero;
    private Jugador jugador;
    //private static boolean despierto=true;


    public Hilo(Tablero tablero, Jugador jugador) {
        this.tablero = tablero;
        this.jugador = jugador;
    }

    public boolean isWin(){
        return jugador.isGanador();
    }

    @Override
    public void run() {
        try{
            super.run();
        while(jugador.getVidas()>0 && !jugador.isGanador()) {
            /*System.out.println("hilo "+jugador.getName());
            while(!despierto) wait();
            despierto=false;*/
            tablero.jugar(jugador);
            /*despierto=true;
            notifyAll();*/
        }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
