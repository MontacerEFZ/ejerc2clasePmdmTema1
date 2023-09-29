package montacer.elfazazi.ejerc2clasepmdmtema1.modelos;

import java.io.Serializable;

public class Coche implements Serializable {
    private String marca;
    private String modelo;
    private String color;

    public Coche() {
    }

    public Coche(String marca, String modelo, String marca1) {
        this.marca = marca;
        this.modelo = modelo;
        this.marca = marca1;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
