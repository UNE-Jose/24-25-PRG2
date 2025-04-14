package JuegoTresEnRaya.src;

public class Tablero {
    private int[][] tabla;
    private char[] fichas;

    private final int VACIO = 0;

    public Tablero(int[][] tabla, char[] fichas) {
        this.tabla = tabla;
        this.fichas = fichas;
    }

    public Tablero(int alto, int largo, char[] fichas) {
        tabla = new int[alto][largo];
        this.fichas = fichas;
    }

    public Tablero(int cuadradoLado, char[] fichas) {
        this(cuadradoLado, cuadradoLado,fichas);
    }

    public int[] tamaño() {
        return new int[] {tabla[0].length, tabla.length};
    }

    public void mostrar() {
        for (int i = 0;i<tabla.length;i++) {
            for (int j = 0; j<tabla.length;j++) {
                System.out.print(parse(tabla[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private char parse(int ficha) {
        return (ficha == VACIO) ? '_' : fichas[ficha-1];
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return tabla[coordenada.y()][coordenada.x()] != VACIO;
    }

    public void ponerFicha(Coordenada coordenada, int ficha) {
        tabla[coordenada.y()][coordenada.x()] = ficha;
    }

    public int sacarFicha(Coordenada coordenada) {
        int fichaSacada = tabla[coordenada.y()][coordenada.x()];
        tabla[coordenada.y()][coordenada.x()] = VACIO;
        return fichaSacada;
    }

    public void moverFicha(Coordenada origen, Coordenada latter, int jugador) {
        ponerFicha(latter, sacarFicha(origen));
    }

    public int[] obtenerFila(Coordenada coordenada) {
        return tabla[coordenada.y()];
    }

    public int[] obtenerColumna(Coordenada coordenada) {
        int[] columna = new int[tabla.length];
        for (int i = 0; i < columna.length; i++) {
            columna[i] = tabla[i][coordenada.x()];
        }
        return columna;
    }

    public int[] obtenerDiagonal1(Coordenada coordenada) {
        int inicioX = coordenada.x() >= coordenada.y() ? coordenada.x() - coordenada.y() : 0;
        int inicioY = coordenada.y() > coordenada.x() ? coordenada.y() - coordenada.x() : 0;
        int[] diagonal = new int[Math.min(tabla.length - inicioY, tabla[0].length - inicioX)];
    
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = tabla[inicioY + i][inicioX + i];
        }
    
        return diagonal;
    }

    public int[] obtenerDiagonal2(Coordenada coordenada) {
        int suma = coordenada.x() + coordenada.y();
        int inicioX = suma < tabla[0].length ? suma : tabla[0].length - 1;
        int inicioY = suma < tabla[0].length ? 0 : suma - (tabla[0].length - 1);
        int[] diagonal = new int[Math.min(inicioX + 1, tabla.length - inicioY)];
    
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = tabla[inicioY + i][inicioX - i];
        }
        return diagonal;
    }
}