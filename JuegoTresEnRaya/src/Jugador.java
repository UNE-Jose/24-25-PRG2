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
        Coordenada coordenada = pedirCoordenadaValida(tablero,false ,"Dame una coordenada válida donde colocar la ficha (Primero X y después Y):");

        tablero.ponerFicha(coordenada,jugador);
        coordenadaJugada = coordenada;

        fichasPorColocar--;
    }

    private void moverFicha(Tablero tablero) {
        Coordenada origen = pedirCoordenadaValida(tablero,true ,"Dame una coordenada válida donde sacar una ficha (Primero X y después Y):");
        Coordenada latter = pedirCoordenadaValida(tablero,false ,"Dame una coordenada válida donde colocar la ficha (Primero X y después Y):");
    
        tablero.moverFicha(origen, latter, jugador);
        coordenadaJugada = latter;
    }
    
    private Coordenada pedirCoordenadaValida(Tablero tablero,boolean debeEstarOcupado ,String mensaje) {
        Coordenada coordenada;
        do {
            System.out.println(mensaje);
            coordenada = new Coordenada(tablero.tamaño());
            coordenada.pedir();
        } while (!(tablero.estaOcupado(coordenada) == debeEstarOcupado));
        return coordenada;
    }

    public void teToca(Tablero tablero) {
        if (fichasPorColocar > 0) {
            ponerFicha(tablero);
        } else {
            moverFicha(tablero);
        }
    }

    public void celebrar() {
        System.out.println("Enhorbuana el jugador " + jugador + " ha ganado.");
    }
}