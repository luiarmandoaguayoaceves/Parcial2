package _Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class proyecto extends JFrame{

    private BufferedImage buffer;
    private Graphics2 graPixel;
    private Boolean checkExistance = Boolean.FALSE;
    private JPanel panel;
    public proyecto() {
        setSize(500,500);
        setLocation(50,50);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        panel = new JPanel();
        add(panel);


    }
    @Override
    public void paint(Graphics g) {
        graPixel = new Graphics2(this);
        if( checkExistance == Boolean.FALSE) {
            buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);

            buffer.setRGB(0, 0, Color.blue.getRGB());
            this.getGraphics().drawImage(buffer, getWidth()/2, getHeight()/2, this);

            checkExistance = Boolean.TRUE;
            super.paint(g);
        }
        super.paint(g);
        this.update(g);
    }
    public void update(Graphics g){
        graPixel.lineaBresenham(100, 100, 300, 200, buffer);//metodo creado con argumentos
//        graPixel.animacion(250, 250, 100, 6, Color.black);

    }

}

