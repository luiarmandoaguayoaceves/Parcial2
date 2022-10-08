package LineaDDARecta03;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LineaRecta extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel;

    public LineaRecta(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();//toma la dimencion de la pantalla
        Dimension tamanioPantalla = miPantalla.getScreenSize();
        int altoPantalla = tamanioPantalla.height;
        int anchoPantalla = tamanioPantalla.width;
        setSize(anchoPantalla/2, altoPantalla/2);
        setLocation(anchoPantalla/4, altoPantalla/4);

        setLayout(null);
    }
    public void paint(Graphics g) { //Metodo Paint pasa por parametro Graphic con nombre g
        super.paint(g);//permite usar la variable local y desde la superclase
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);//crea objeto buffer con parametros de alto, ancho, y el BuffereImage para pintar un pixel
//        The BufferedImage subclass describes an Image with an accessible buffer of image data. A BufferedImage is comprised of a ColorModel and a Raster of image data. The number and types of bands in the SampleModel of the Raster must match the number and types required by the ColorModel to represent its color and alpha components. All BufferedImage objects have an upper left corner coordinate of (0, 0). Any Raster used to construct a BufferedImage must therefore have minX=0 and minY=0.
        graPixel = buffer.createGraphics();//Metodo almacenado en variable

        dibujaLinea(0, 100, 200, 100, buffer);//Metodo con 5 parametros
        g.drawImage(buffer, 0, 0, this);//variable g con metodo drawImage con el buffer valores default en este
    }

    private void dibujaLinea(int x0, int y0, int x1, int y1, BufferedImage bu) {
        Color c = Color.black;//Color del pixel
        int dX = x1 - x0;//inicializar variable
        int dY = y1 - y0;//inicializando variable
        int step = 0;//paso

        float xInc = 0, x = 0, y = 0;//inicializar valor flotante
        if (Math.abs(dX) > Math.abs(dY)){
            step = Math.abs(dX);
        }else {
            step = Math.abs(dY);
        }

        xInc = (float) dX / step;

        x = x0;
        y = y0;

        bu.setRGB(Math.round(x), Math.round(y), c.getRGB());//Variable Bu con el metodo RGB pasando el parametro X, Y y getRGB
        for (int i = 1; i <= step; i++) {
            x += xInc;
            bu.setRGB(Math.round(x), Math.round(y), c.getRGB());
        }
    }


    public static void main(String[] args) {
        LineaRecta linea = new LineaRecta();
        linea.setDefaultCloseOperation(EXIT_ON_CLOSE);
        linea.setVisible(true);
    }
}
