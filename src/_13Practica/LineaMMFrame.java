package _13Practica;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author lalo_
 */

public class LineaMMFrame extends JFrame {
    
    private LineaMMGraphics MyGraphicsInstance;
    private Boolean checkExistance = Boolean.FALSE;

    private BufferedImage buffer;
    public JPanel myJPanel;

    public LineaMMFrame(){
        super("Tipos De Lineas");
        setSize(500,500);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJPanel = new JPanel();
        add(myJPanel);
        setVisible(true);
        MyGraphicsInstance = new LineaMMGraphics(this);
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
        //MyGraphicsInstance.Pixel(getWidth()/2, getHeight()/2, Color.red);

        int mascara[] = {1,1,1,1,0,0,0,0};
        //int mascara[] = {1,0};
        //int mascara[] = {1,0,0,0,0,0};
        //int mascara[] = {1,1,1,0};
        //int mascara[] = {1,1,1,1,1,1,1};
        //int mascara[] = {0,0,0,0,0};

        MyGraphicsInstance.PuntoMedioMascara(100, 100, 300, 300, mascara, Color.black);
        MyGraphicsInstance.PuntoMedioMascara(400, 300, 300, 100, mascara, Color.red);//lado de derecha a izquierda
        MyGraphicsInstance.PuntoMedioMascara(200, 50, 300, 50, mascara, Color.green);
        MyGraphicsInstance.PuntoMedioMascara(400, 120, 400, 200, mascara, Color.blue);
        MyGraphicsInstance.PuntoMedioMascara(440, 200, 440, 120, mascara, Color.cyan);
    }
}
