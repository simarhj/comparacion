package cc.udistrital.edu.co.comparacion;

public class Comparacion implements Comparable<Comparacion> {

    public Comparacion(int valor) {
        this.valor = valor;
    }

    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Comparacion arg0) {
        return this.valor - arg0.valor;
    }

}
