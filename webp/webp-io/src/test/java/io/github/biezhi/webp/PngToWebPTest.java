package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author jozsimezei
 * @date 2018/05/08
 */
public class PngToWebPTest {

    public void testConvertToWebp(String rutaOrigen, String rutaDestino) throws IOException {
        File src = new File(rutaOrigen);
        File dest = new File(rutaDestino);

        WebpIO.toWEBP(src, dest);
        WebpIO.close();
    }

    public static void main(String[] args) throws IOException {
        PngToWebPTest programa = new PngToWebPTest();
        String rutaOrigen="C:\\Users\\Jruiz\\Pictures\\webp\\prueba.png";
        String rutaDestino="C:\\Users\\Jruiz\\Pictures\\webp\\prueba.webp";
        programa.testConvertToWebp(rutaOrigen, rutaDestino);
    }
}
