package _04Practica;
//algoritmo de Bresenham
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LineaRecta extends JFrame{


    private BufferedImage buffer;
    private Graphics graPixel;

    public LineaRecta() {
        setSize(400,400);//tamanio de ventana
        setLocation(100,100);//posicion
        setLayout(null);//layout posicion de los objetos
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);//traer el metodo del padre el metodo paint
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);//buffer del la imagen
        graPixel = buffer.createGraphics();//echi pixel
        lineaBresenham(100, 100, 300, 200, buffer);//metodo creado con argumentos
        g.drawImage(buffer, 0, 0, this);//objeto graphics con metodo imagen y pasa argumentos
    }
    public void lineaBresenham(int Xo, int Yo, int Xf, int Yf, BufferedImage bu) {//metodo con parametros
        Color c = Color.black;//color
        int x = 0, y = 0, dX, dY, p, incE, incNE, stepsX, stepsY;//variables

        dX = (Xf - Xo);//diferencia de cordenadas X
        dY = (Yf - Yo);//Diferencia de cordenadas y

        if (dY < 0) {//si conrdenada y es menor a 0
            dY = -dY;//cambiar el signo
            stepsY = -1;//iguala a -1
        } else {
            stepsY = 1;//iguala a 1
        }
        if (dX < 0) {//si coordenada X es negativo
            dX = -dX;//cambiar signo
            stepsX = -1;//igualar a -1
        } else {
            stepsX = 1;//igualado a 1
            x = Xo;//asignar vaalor
            y = Yo;//asignar valor
            bu.setRGB(x, y, c.getRGB());//imprimir pixel
        }
        if (dX > dY) {//200 > 0
            p = 2 * dY - dX;// 2 * 0 - 200 = -200
            incE = 2 * dY;//2 * 0 =0
            incNE = 2 * (dY - dX);//2 * (0 - 200) = -400
            while (x != Xf) {//mientras x != 200
                x = x + stepsX;//0 + 1
                if (p < 0) {//-200 < 0
                    p = p + incE;//-200+0
                } else {
                    y = y + stepsY; //100 + 1
                    p = p + incNE;//-200 -400
                }
                bu.setRGB(x, y, c.getRGB()); //pinta
            }
        } else {
            p = 2 * dX - dY;
            incE = 2 * dX;
            incNE = 2 * (dX - dY);
            while (Yo != Yf) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepsX;
                    p = p + incNE;
                }
            }
            bu.setRGB(x, y, c.getRGB());
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        LineaRecta a = new LineaRecta();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }

}
