package JuegoTresEnRaya.src;

public class TresEnRaya {
    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;

    private final char[] FICHAS = {'X','O'};
    private final int NUMERO_RAYA = 3;

    public TresEnRaya(){
        tablero = new Tablero(3,FICHAS);
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador(1,3);
        jugadores[1] = new Jugador(2,3);
        turno = new Turno(true,jugadores.length);
    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugadores[turno.leToca()].teToca(tablero);
            turno.cambiar();
        } while (!hayVictoria());
        jugadores[turno.jugadorAnterior()].celebrar();
    }

    private boolean hayVictoria() {
        Coordenada coordenadaJugada = jugadores[turno.jugadorAnterior()].coordenadaJugada;
        int[][] combinaciones ={
            tablero.obtenerFila(coordenadaJugada),
            tablero.obtenerColumna(coordenadaJugada),
            tablero.obtenerDiagonal1(coordenadaJugada),
            tablero.obtenerDiagonal2(coordenadaJugada),
        };

        for (int[] combinacion : combinaciones) {
            if (comprobarRaya(combinacion)) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarRaya(int[] fila) {
        int valorAnterior = fila[0];
        int igualesSeguidos = 1;
        for (int i = 1; i < fila.length; i++) {
            igualesSeguidos = (fila[i] != 0 && fila[i] == valorAnterior) ? igualesSeguidos + 1 : 1;
            valorAnterior = fila[i];
    
            if (igualesSeguidos >= NUMERO_RAYA) return true;
        }
        return false;
    }
}