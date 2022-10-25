package _15Practica;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author lalo_
 */
public class Frame extends JFrame{
    private Graphicss MyGraphicsInstance;
    private Boolean checkExistance = Boolean.FALSE;

    private BufferedImage buffer;
    public JPanel myJPanel;

    public Frame(){
        super("Tipos de línea en circunferencias");
        setSize(500,500);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJPanel = new JPanel();
        add(myJPanel);
        setVisible(true);
        MyGraphicsInstance = new Graphicss(this);
    }

    public void paint(Graphics g){
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

    //public void paintComponent(Graphics g){
    public void update(Graphics g){
        //MyGraphicsInstance.PixelPerron(getWidth()/2, getHeight()/2, Color.red);

        //int mascara[] = {1,1,1,1,0,0,0,0};
        //int mascara[] = {1,0};
        int mascara[] = {1,0,0,0,0,0};
        //int mascara[] = {1,1,1,0};
        
        //int mascara[] = {1,1,1,1,1,1,1};
        //int mascara[] = {0,0,0,0,0};

        MyGraphicsInstance.BresenhamCirculoMascara(250, 250, 100, mascara, Color.black);
    }
}
