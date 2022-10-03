package pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {//Clase pixel.Ventana
    private BufferedImage buffer;
    private Graphics graPixel;
    public Pixel() {//Metodo constructor
        Toolkit miPantalla = Toolkit.getDefaultToolkit();//tomar el dato de pantalla
        Dimension tamanioPanatalla = miPantalla.getScreenSize();//dimension de la pantalla X y Y
        int altoPantalla = tamanioPanatalla.height;//Tomar el Alto X
        int anchoPantalla = tamanioPanatalla.width;//Tomar el Ancho Y

        setSize(anchoPantalla/2, altoPantalla/2);//Dividir el alto  entre 2 y el ancho entre 2 para el tamaño
        setLocation(anchoPantalla/4, altoPantalla/4);//dividir entre 4 para la locacion

        setLayout(null);//tipo de acomodo en la ventana
    }
    @Override
    public void paint(Graphics g) { //Metodo Paint pasa por parametro Graphic con nombre g
        super.paint(g);//permite usar la variable local y desde la superclase
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);//crea objeto buffer con parametros de alto, ancho, y el BuffereImage para pintar un pixel
//        The BufferedImage subclass describes an Image with an accessible buffer of image data. A BufferedImage is comprised of a ColorModel and a Raster of image data. The number and types of bands in the SampleModel of the Raster must match the number and types required by the ColorModel to represent its color and alpha components. All BufferedImage objects have an upper left corner coordinate of (0, 0). Any Raster used to construct a BufferedImage must therefore have minX=0 and minY=0.
        graPixel = buffer.createGraphics();//Metodo almacenado en variable
        dibujaPixel(250, 250, buffer);//Metodo con 3 parametros
        g.drawImage(buffer, 0, 0, this);//variable g con metodo drawImage con el buffer valores default en este
    }
    public void dibujaPixel(int x0, int y0, BufferedImage bu) {
        Color c = Color.black;//Color del pixel
        bu.setRGB(x0, y0, c.getRGB());//Variable Bu con el metodo RGB pasando el parametro X, Y y getRGB
    }

    public static void main(String[] args) {
        Pixel ventana = new Pixel();//crear Objto Ventana de valor ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//objeto ventana con metodo para cerrar
        ventana.setVisible(true);//variable ventana y metodo visible
    }
}