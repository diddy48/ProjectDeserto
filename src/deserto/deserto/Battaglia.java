/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.deserto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author roman
 */
public class Battaglia extends JFrame {

    private JFrame Control = new JFrame("Pannello di Controllo");
    private JFrame Log = new JFrame("Diario di bordo");
    private JPanel pControl = new JPanel();
    private JPanel pMain = new Panel();
    private JPanel pLog = new JPanel();
    //private Image image;

    //ArrayList<JButton> buttons = new ArrayList<JButton>();
    public Battaglia() {
        //image = Toolkit.getDefaultToolkit().getImage("D:\\roman\\Documents\\NetBeansProjects\\ProgettoDeserto\\ProjectDesertoa/deserto.jpg");
        this.add(pMain);
        Log.add(pLog);
        Control.add(pControl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Control.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pMain.setVisible(true);
        pLog.setVisible(true);
        pControl.setVisible(true);
        setTitle("BattleGame");
        setResizable(false);
        setVisible(true);
        setSize(705, 408);
        setLocation(10, 10);
        Control.setResizable(false);
        Control.setVisible(true);
        Control.setSize(500, 350);
        Control.setLocation(765, 10);
        Log.setResizable(false);
        Log.setVisible(true);
        Log.setSize(1000, 250);
        Log.setLocation(10, 450);
    }

    class Panel extends JPanel {

        private Image image;

        public Panel() {
            image = Toolkit.getDefaultToolkit().getImage("D:\\roman\\Documents\\NetBeansProjects\\ProgettoDeserto\\ProjectDesertoa/deserto.jpg");
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 20, 20,680,380, this);
            int start = 20;
            int num = 35;
            int numX = 23;
            for (int i = 0; i < 35; i++) {
                g2.drawLine(start, 20, start, 700);
                g2.drawString(""+i+"", 3, num);
                g2.drawString(""+i+"", numX, 17);
                g2.drawLine(20, start, 700, start);
                start += 20;
                num+=20;
                numX+=20;
            }
        }
    }

}
