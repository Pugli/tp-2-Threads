package Models;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Jugador {

    private boolean uso = false;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int vidas=7;
    private String name;

    public String getName() {
        return name;
    }
public void restarVida(){
        this.vidas--;
}
    public Jugador(String name) {
        this.name = name;
    }

    public int getVidas() {
        return vidas;
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public  String pedirLetra(){
        String valor = "";

        try {

            valor = this.randomAlphaNumeric(1);
            System.out.println("Letra elegida:"+valor);
        } catch (Exception ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}


