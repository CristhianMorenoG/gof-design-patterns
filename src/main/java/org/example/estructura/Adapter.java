package org.example.estructura;

public class Adapter {
    /**
     * Permite cerrar brechas o transformar un elemento que
     * esta desarrollado o escrito en un leguaje ajeno para que pueda
     * ser interpretado por el recurso esperado
     */

    public void archivoSonido() {
        ReproductorDeAudio nuevoArchivo1 = new ReproductorMp3();
        nuevoArchivo1.reproducir("Las mañanitas.mp3");
        ReproductorDeAudio nuevoArchivo2 = new ReproductorWav();
        nuevoArchivo2.reproducir("Buenos dias.wav");
        ReproductorDeAudio nuevoArchivo3 = new AdaptadorDeAudio();
        nuevoArchivo3.reproducir("Las mañanitas.wav");




    }


}


interface ReproductorDeAudio {
    void reproducir(String archivo);
}

class ReproductorMp3 implements ReproductorDeAudio {
    @Override
    public void reproducir(String archivo) {
        if (archivo.endsWith(".mp3")) {
            System.out.println("Reproduciendo archivo MP3: " + archivo);
            return;
        }
        throw new IllegalArgumentException("Formato invalido");
    }
}

class ReproductorWav implements ReproductorDeAudio {
    @Override
    public void reproducir(String archivo) {
        if (archivo.endsWith(".wav")) {
            System.out.println("Reproduciendo archivo WAV: " + archivo);
            return;
        }
        throw new IllegalArgumentException("Formato invalido");
    }
}

class AdaptadorDeAudio implements ReproductorDeAudio {
    private ReproductorMp3 reproductorMp3 = new ReproductorMp3();

    @Override
    public void reproducir(String archivo) {
        String nuevoFormato = "";
        if (archivo.endsWith(".wav")) {
            nuevoFormato = archivo.substring(0, archivo.lastIndexOf(".")) + ".mp3";
            reproductorMp3.reproducir(nuevoFormato);
        }
    }
}
