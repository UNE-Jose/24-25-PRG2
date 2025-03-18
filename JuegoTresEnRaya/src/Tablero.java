package JuegoTresEnRaya.src;

public class Tablero {
    private char[][] tabla;

    public Tablero(int alto, int largo) {
        tabla = new char[alto][largo];
    }

    public Tablero(int cuadradoLado) {
        this(cuadradoLado, cuadradoLado);
    }

    public void mostrar() {
        for (int i = 0;i<tabla.length;i++) {
            for (char caracter : tabla[i]) {
                System.out.print("|" + caracter);
            }
            System.out.print("|");
            System.out.println("-".repeat(tabla.length*2+1));
        }
    }

    public boolean hayFichasEnRaya() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hayTresEnRaya'");
    }

    public boolean estaOcupado(Coordenada coordenada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaOcupado'");
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ponerFicha'");
    }

}
