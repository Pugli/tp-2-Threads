package Models;



public class Tablero extends Thread{

    private String[] palabraAAdivinar = {"J", "A", "V", "A"};
    private String[] palabraAdivinada;
    private String letra;
    private boolean ganador = false;
    private static boolean despierto=true;

    public Tablero() {
        palabraAdivinada = new String[palabraAAdivinar.length];
        limpiar();
    }

    public boolean isGanador() {
        return ganador;
    }

    public synchronized void jugar(Jugador jugador) throws InterruptedException {
        while(!despierto) {
            wait();
        }
        despierto=false;
        System.out.println("hilo "+jugador.getName());
        letra = jugador.pedirLetra();
        this.verificar(letra);
        this.imprimir();
        if (this.verificarGanador()) {
            ganador = true;
            System.out.println("HA GANADO "+jugador.getName());
        }
        else {
            jugador.restarVida();
        }
        despierto=true;
        notify();
    }

    public void limpiar() {
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = "";
        }
    }

    public void imprimir() {
        for (int i = 0; i < palabraAdivinada.length; i++) {
            if (palabraAdivinada[i].equals("")) {
                System.out.print("_");
            } else {
                System.out.print(palabraAdivinada[i]);
            }

        }
        System.out.println("");
    }

    public void verificar(String letra) {
        for (int i = 0; i < palabraAAdivinar.length; i++) {
            if (palabraAAdivinar[i].equalsIgnoreCase(letra)) {
                palabraAdivinada[i] = letra;
            }
        }
    }

    public int getCantidadElementos() {
        return palabraAAdivinar.length;
    }

    public boolean verificarGanador() {
        boolean valor = true;
        for (int i = 0; i < palabraAdivinada.length; i++) {
            if (palabraAdivinada[i].equals("")) {
                valor = false;

            }

        }
        return valor;

    }

}
