package Models;



public class Tablero extends Thread{

   // private String[] palabraAAdivinar = {"J", "A", "V", "A"};
   // private String[] palabraAdivinada;
    private String letra;
   // private boolean ganador = false;
    private static boolean despierto=true;

    public Tablero() {
     /*palabraAdivinada = new String[palabraAAdivinar.length];
       limpiar();*/
    }

   /* public boolean isGanador() {
        return ganador;
    }*/

    public synchronized void jugar(Jugador jugador) throws InterruptedException {
        while(!despierto) {
            wait();
        }
        despierto=false;
        System.out.println("hilo "+jugador.getName());
        letra = jugador.pedirLetra();
        this.verificar(letra,jugador);
        this.imprimir(jugador);
        if (this.verificarGanador(jugador)) {
            jugador.setGanador(true);
            System.out.println("HA GANADO "+jugador.getName());
        }
        else {
            jugador.restarVida();
        }
        despierto=true;
        notify();
    }

    /*public void limpiar() {
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = "";
        }
    }*/

    public void imprimir(Jugador jugador) {
        for (int i = 0; i < jugador.getPalabraAdivinada().length; i++) {
            if (jugador.getPalabraAdivinada()[i].equals("")) {
                System.out.print("_");
            } else {
                System.out.print(jugador.getPalabraAdivinada()[i]);
            }

        }
        System.out.println("");
    }

    public void verificar(String letra, Jugador jugador) {
        for (int i = 0; i < jugador.getPalabraAAdivinar().length; i++) {
            if (jugador.getPalabraAAdivinar()[i].equalsIgnoreCase(letra)) {
                jugador.getPalabraAdivinada()[i] = letra;
            }
        }
    }

   /* public int getCantidadElementos() {
        return palabraAAdivinar.length;
    }*/

    public boolean verificarGanador(Jugador jugador) {
        boolean valor = true;
        for (int i = 0; i < jugador.getPalabraAdivinada().length; i++) {
            if (jugador.getPalabraAdivinada()[i].equals("")) {
                valor = false;

            }

        }
        return valor;

    }

}
