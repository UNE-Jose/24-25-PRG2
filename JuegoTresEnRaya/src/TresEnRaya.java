package JuegoTresEnRaya.src;

public class TresEnRaya {
    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;

    public TresEnRaya(){
        tablero = new Tablero(3);
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador('X',3);
        jugadores[1] = new Jugador('O',3);
    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugadores[turno.leToca()].teToca(tablero);
            turno.cambiar();
        } while (!tablero.hayFichasEnRaya());
        jugadores[turno.noLeToca()].celebrar();
    }
}