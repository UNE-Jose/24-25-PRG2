package JuegoTresEnRaya.src;

public class Jugador {
    private int fichasPorColocar;
    private int jugador;
    public Coordenada coordenadaJugada;

    public Jugador(int jugador, int numeroFichas) {
        this.jugador = jugador;
        this.fichasPorColocar = numeroFichas;
    }

    private void ponerFicha(Tablero tablero) {
        Coordenada coordenada = pedirCoordenadaValida(tablero, "Dame una coordenada válida donde colocar la ficha (Primero X y después Y):");

        tablero.ponerFicha(coordenada,jugador);
        coordenadaJugada = coordenada;

        fichasPorColocar--;
    }

    private void moverFicha(Tablero tablero) {
        Coordenada origen = pedirCoordenadaValida(tablero, "Dame una coordenada válida donde sacar una ficha (Primero X y después Y):");
        Coordenada latter = pedirCoordenadaValida(tablero, "Dame una coordenada válida donde colocar la ficha (Primero X y después Y):");
    
        tablero.moverFicha(origen, latter, jugador);
        coordenadaJugada = latter;
    }
    
    private Coordenada pedirCoordenadaValida(Tablero tablero, String mensaje) {
        Coordenada coordenada;
        do {
            System.out.println(mensaje);
            coordenada = new Coordenada();
            coordenada.pedir();
        } while (!coordenada.esValida() || !tablero.estaOcupado(coordenada));
        return coordenada;
    }

    public void teToca(Tablero tablero) {
        if (fichasPorColocar > 0) {
            ponerFicha(tablero);
            fichasPorColocar--;
        } else {
            moverFicha(tablero);
        }
    }

    public void celebrar() {
        System.out.println("Enhorbuana el jugador " + jugador + " ha ganado.");
    }
}