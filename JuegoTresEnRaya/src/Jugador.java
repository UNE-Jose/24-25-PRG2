package JuegoTresEnRaya.src;

public class Jugador {
    private int fichasPorColocar;
    private char color;

    public Jugador(char color, int numeroFichas) {
        this.color = color;
        this.fichasPorColocar = numeroFichas;
    }

    private void ponerFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();

        do {
            coordenada.pedir();
        } while(!coordenada.esValida() || tablero.estaOcupado(coordenada));
        tablero.ponerFicha(coordenada,color);
    }

    private void moverFicha(Tablero tablero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ponerFicha'");
    }

    public void teToca(Tablero tablero) {
        if (fichasPorColocar >0) {
            ponerFicha(tablero);
        } else {
            moverFicha(tablero);
        }
    }

    public void celebrar() {
        System.out.println("Enhorbuana el jugador " + color + " ha ganado.");
    }

}