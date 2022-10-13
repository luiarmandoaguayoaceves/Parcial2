package _14Practica;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author lalo_
 */
public class Frame extends JFrame {
    private Graphicss MyGraphicsInstance;
    private Boolean checkExistance = Boolean.FALSE;

    private BufferedImage buffer;
    public JPanel myJPanel;

    public Frame(){
        super("Grosor de línea en líneas rectas");
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

    public void paint(Graphics g)
    {
        if( checkExistance == Boolean.FALSE)
         {
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
        //MyGraphicsInstance.Pixel(getWidth()/2, getHeight()/2, Color.red);

        MyGraphicsInstance.PuntoMedioGrosor(100, 100, 300, 300, 5, Color.blue);
        MyGraphicsInstance.PuntoMedioGrosor(400, 300, 300, 100, 5, Color.red);//lado de derecha a izquierda
        MyGraphicsInstance.PuntoMedioGrosor(200, 50, 300, 50, 5, Color.green);
        MyGraphicsInstance.PuntoMedioGrosor(400, 120, 400, 200, 5, Color.pink);
        MyGraphicsInstance.PuntoMedioGrosor(440, 200, 440, 120, 5, Color.magenta);
    }
}
