package ar.edu.ort.tp3;

/**
 * Created by 41471933 on 21/6/2016.
 */
public class Jugada {
    public String username;
    public String secuencia;
    public int jugada;

    public Jugada(String username, String secuencia, int jugada) {
        this.username = username;
        this.secuencia = secuencia;
        this.jugada = jugada;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public int getJugada() {
        return jugada;
    }

    public void setJugada(int jugada) {
        this.jugada = jugada;
    }
}
