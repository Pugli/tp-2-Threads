package Models;



public class Tablero {

    private String[] palabraAAdivinar = {"J", "A", "V", "A"};
    private String[] palabraAdivinada;

    public Tablero() {
        palabraAdivinada = new String[palabraAAdivinar.length];
        limpiar();
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
