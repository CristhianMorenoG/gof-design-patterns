package org.example.creacion;


public class Factory {

    /**
     * Simplifica el proceso de construccion de objetos,
     * en este caso por medio de un parametro "tipo" construimos el objeto esperado.
     */

    public void crearFigura(String tipo) {

        FiguraGeometrica nuevaFigura = FiguraGeometricaFactory.crearFiguraGeometrica(tipo);
        nuevaFigura.dibujar();

    }
}

interface FiguraGeometrica {
    void dibujar();
}

class Cuadrado implements FiguraGeometrica {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un cuadrado");
    }
}

class Triangulo implements FiguraGeometrica {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un triángulo");
    }
}

class Circulo implements FiguraGeometrica {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class FiguraGeometricaFactory {
    /*
    Al momento de implementar fue necesario cambiar el tipo de public a public static de lo contrario el IDE mostraba alerta
     */
    public static FiguraGeometrica crearFiguraGeometrica(String tipo) {
        if (tipo == null) {
            return null;
        }
        if (tipo.equalsIgnoreCase("CUADRADO")) {
            return new Cuadrado();
        } else if (tipo.equalsIgnoreCase("TRIANGULO")) {
            return new Triangulo();
        } else if (tipo.equalsIgnoreCase("CIRCULO")) {
            return new Circulo();
        } else {
            return null;
        }
    }
}