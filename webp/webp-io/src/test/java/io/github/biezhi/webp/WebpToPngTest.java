package io.github.biezhi.webp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author biezhi
 * @date 2017/10/2
 */
public class WebpToPngTest {

    public void testConvert(String rutaOrigen, String rutaDestino) {
        File src = new File(rutaOrigen);
        File dest = new File(rutaDestino);

        WebpIO.toNormalImage(src, dest);
        WebpIO.close();
    }

    public static void main(String[] args)throws IOException  {
        PngToWebPTest programa = new PngToWebPTest();
        String rutaOrigen="C:\\Users\\Jruiz\\Pictures\\webp\\prueba.webp";
        String rutaDestino="C:\\Users\\Jruiz\\Pictures\\webp\\prueba.png";
        programa.testConvertToWebp(rutaOrigen, rutaDestino);
    }
}
