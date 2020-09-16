package cl.inacap.misconciertos;

import android.widget.EditText;

public class Registro {

    private String nombre;
    private String fecha;
    private String genero;
    private int valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return
                " Artista: " + nombre +
                        " Fecha: " + fecha +
                        " Genero: " + genero +
                        " Valor: $" + valor + ".";
    }
}
