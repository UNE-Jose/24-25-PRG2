package JuegoTresEnRaya.src;

public class Turno {
    private int turnoActual;
    private int numeroJugadores;

    public Turno(boolean comienzoAzar,int jugadores) {
        numeroJugadores = jugadores;
        turnoActual = comienzoAzar ? ((int) (Math.random()*numeroJugadores)) : 0;
    }

    public int leToca() {
        return turnoActual;
    }

    public void cambiar() {
        turnoActual = siguienteJugador();
    }

    public int siguienteJugador() {
        return (turnoActual+1)%numeroJugadores;
    }

    public int jugadorAnterior() {
        return (turnoActual-1+numeroJugadores)%numeroJugadores;
    }
}