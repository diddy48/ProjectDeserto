/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.deserto;

import deserto.carri.CarroCantiere;
import deserto.carri.normali.CarroLineare;
import deserto.carri.normali.CarroQuadrato;
import deserto.carri.speciale.CarroTalpa;
import static deserto.deserto.Deserto.INTERTIME;
import deserto.pos.Posizione;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author roman
 */
public class Battaglia extends JFrame implements ActionListener {

    private JFrame Control = new JFrame("Pannello di Controllo");
    private JFrame Log = new JFrame("Diario di bordo");
    private JPanel pControl = new JPanel();
    private JPanel pMain = new Panel();
    private JPanel pLog = new JPanel();
    private ArrayList<CarroCantiere> carri = new ArrayList<CarroCantiere>();
    private JTextArea tf = new JTextArea("Simulazione battaglia navale", 12, 85);
    private JScrollPane scroll = new JScrollPane(tf);
    //private Image image;
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    int n;

    public Battaglia(ArrayList<CarroCantiere> carri, int n) {
        this.n = n;
        pControl.setLayout(new GridLayout(1, 1));
        ArrayList<String> titles = new ArrayList<String>();
        titles.add("Esci");
        for (int i = 0; i < 1; i++) {
            buttons.add(new JButton(titles.get(i)));
            pControl.add(buttons.get(i));
            buttons.get(i).addActionListener(this);
        }
        tf.setEditable(false);
        scroll.setAutoscrolls(true);

        this.carri = carri;
        this.add(pMain);
        pLog.add(scroll);
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
        Control.setSize(250, 150);
        Control.setLocation(725, 10);
        Log.setResizable(false);
        Log.setVisible(true);
        Log.setSize(1000, 250);
        Log.setLocation(10, 450);
    }

    public void updateLog(String str) {
        tf.append("\n" + str);
        tf.setCaretPosition(tf.getDocument().getLength());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.get(0)) {
            System.exit(0);
        }
    }

    class Panel extends JPanel {

        private Image image;

        public Panel() {
            image = Toolkit.getDefaultToolkit().getImage("D:\\roman\\Documents\\NetBeansProjects\\ProgettoDeserto\\ProjectDesertoa/deserto.jpg");
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 20, 20, 680, 380, this);
            int start = 20;
            int num = 35;
            int numX = 23;
            for (int i = 0; i < 35; i++) {
                g2.drawLine(start, 20, start, 700);
                g2.drawString("" + i + "", 3, num);
                g2.drawString("" + i + "", numX, 17);
                g2.drawLine(20, start, 700, start);
                start += 20;
                num += 20;
                numX += 20;
            }
            for (int i = 0; i < carri.size(); i++) {
                if (carri.get(i).getClass() == CarroLineare.class) {
                    CarroLineare cl = (CarroLineare) carri.get(i);
                    cl.draw(g2);
                } else if (carri.get(i).getClass() == CarroTalpa.class) {
                    CarroTalpa ct = (CarroTalpa) carri.get(i);
                    ct.draw(g2);
                } else {
                    CarroQuadrato cq = (CarroQuadrato) carri.get(i);
                    cq.draw(g2);
                }
            }
        }
    }

}
