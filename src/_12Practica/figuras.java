package _12Practica;

import java.awt.Color;
        import java.awt.Graphics;
        import java.awt.image.BufferedImage;
        import javax.swing.JFrame;

public class figuras extends JFrame{

    private BufferedImage buffer;
    private Graphics graPixel;


    public figuras() {
        setLayout(null);
        setBounds(0, 0, 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();



        lineaBresenham(0, 40, 100, 100, buffer);
        lineaBresenham(400, 100, 500, 40, buffer);

        dibujaLinea(400, 100, 600, 100, buffer);
        dibujaLinea(300, 100, 100, 100, buffer);


        for (int ix = 50; ix > 0; ix -= 5) {
            elipse(120, 280, 100 - ix, 80 - ix, buffer);
        }

        for (int ix = 80; ix > 0; ix -= 5) {
            circuloBrensenham(670, 280, 100 - ix, buffer);
        }

        dibujarRectangulo(300 , 280 , 200 , 100 , buffer);
        dibujarRectangulo(305 , 285 , 190 , 90 , buffer);
        dibujarRectangulo(310 , 290 , 180 , 80 , buffer);
        dibujarRectangulo(315 , 295 , 170 , 70 , buffer);

        g.drawImage(buffer, 0, 0, this);
    }

    public void elipse(int x0, int y0, int rx, int ry, BufferedImage buff) {
        int x, y, p, px, py;
        int rx2, ry2, tworx2, twory2;
        ry2 = ry * ry;
        rx2 = rx * rx;
        twory2 = 2 * ry2;
        tworx2 = 2 * rx2;
        /* region 1 */
        x = 0;
        y = ry;;

        dibujaLinea(400, 100, 600, 100, buffer);
        dibujaLinea(300, 100, 100, 100, buffer);
        cuatroPuntos(x0, y0, x, y, buff);
        p = (int) Math.round(ry2 - rx2 * ry + 0.25 * rx2);
        px = 0;
        py = tworx2 * y;
        while (px < py) {
            x = x + 1;
            px = px + twory2;
            if (p < 0) {
                p = p + ry2 + px;
            } else {
                y = y - 1;
                py = py - tworx2;
                p = p + ry2 + px - py;
            }
            cuatroPuntos(x0, y0, x, y, buff);
        }
        p = (int) Math.round(ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - (rx2 * ry2));
        px = 0;
        py = tworx2 * y;
        while (y > 0) {
            y = y - 1;
            py = py - tworx2;
            if (p > 0) {
                p = p + rx2 - py;
            } else {
                x = x + 1;
                px = px + twory2;
                p = p + rx2 + py + px;
            }
            cuatroPuntos(x0, y0, x, y, buff);
        }
    }

    private void cuatroPuntos(int x0, int y0, int x, int y, BufferedImage bu) {
        Color c = Color.BLACK;
        bu.setRGB(x0 + x, y0 + y, c.getRGB());
        bu.setRGB(x0 + x, y0 - y, c.getRGB());
        bu.setRGB(x0 - x, y0 + y, c.getRGB());
        bu.setRGB(x0 - x, y0 - y, c.getRGB());
    }

    public void circuloBrensenham(int xc, int yc, int r, BufferedImage buff) {
        int x = -r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            buff.setRGB(xc - x, yc + y, Color.BLACK.getRGB());
            buff.setRGB(xc - y, yc - x, Color.BLACK.getRGB());
            buff.setRGB(xc + x, yc - y, Color.BLACK.getRGB());
            buff.setRGB(xc + y, yc + x, Color.BLACK.getRGB());

            r = error;
            if (r > x) {
                error += ++x * 2 + 1;
            }
            if (r <= y) {
                error += ++y * 2 + 1;
            }
        } while (x < 0);
    }

    public void lineaBresenham(int x0, int y0, int x1, int y1, BufferedImage bu) {
        Color c = Color.BLUE;
        int x = 0, y = 0;
        int dX = 0, dY = 0, p = 0;
        int incE = 0, incNE = 0, stepsX = 0, stepsY = 0;

        dX = (x1 - x0);
        dY = (y1 - y0);

        if (dY < 0) {
            dY = -dY;
            stepsY = -1;
        } else {
            stepsY = 1;
        }
        if (dX < 0) {
            dX = -dX;
            stepsX = -1;
        } else {
            stepsX = 1;
            x = x0;
            y = y0;
            bu.setRGB(x, y, c.getRGB());
        }

        if (dX > dY) {
            p = 2 * dY - dX;
            incE = 2 * dY;
            incNE = 2 * (dY - dX);
            while (x != x1) {
                x = x + stepsX;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepsY;
                    p = p + incNE;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        } else {
            p = 2 * dX - dY;
            incE = 2 * dX;
            incNE = 2 * (dX - dY);
            while (y != y1) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepsX;
                    p = p + incNE;
                }
                bu.setRGB(x, y, c.getRGB());
            }
        }
    }

    public void dibujarRectangulo(int x, int y, int ancho, int largo, BufferedImage lienzo) {
        lineaBresenham(x, y, x + ancho, y, lienzo);
        lineaBresenham(x, y + largo, x + ancho, y + largo, lienzo);
        lineaBresenham(x, y, x, y + largo, lienzo);
        lineaBresenham(x + ancho, y, x + ancho, y + largo, lienzo);
    }

    //LINEAS
    public void dibujaLinea(int x0, int y0, int x1, int y1, BufferedImage bu) {

        Color c = Color.black;

        float adyacente = (float) Float.max(x0, x1) - Float.min(x0, x1);
        float opuesto = (float) Float.max(y0, y1) - Float.min(y0, y1);
        float pendiente = (float) opuesto / adyacente;

        int sigX = 0;
        int sigY = 0;
        pendiente = Math.abs(pendiente);

        if (x0 < x1) {
            sigX = 1;
        } else {
            sigX = -1;
        }
        if (y0 < y1) {
            sigY = 1;
        } else {
            sigY = -1;
        }

        if (Math.toDegrees(Math.atan(pendiente)) > 45) {
            pendiente = (float) Math.abs(adyacente / opuesto);
            for (int i = 0; i <= Math.abs(opuesto); i++) {
                bu.setRGB(x0 + (int) (i * pendiente * sigX), y0 + (i * sigY), c.getRGB());
            }
        } else {
            for (int h = 0; h <= Math.abs(adyacente); h++) {
                bu.setRGB(x0 + h * sigX, y0 + (int) (h * pendiente * sigY), c.getRGB());
            }
        }
    }
    public static void main(String[] args) {
        figuras as = new figuras();
    }

}