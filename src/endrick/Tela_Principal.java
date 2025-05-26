package endrick;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela_Principal extends JFrame {
    private static final long serialVersionUID = 1L;

    public void exitProcedure() {
        dispose();
        System.exit(0);
    }

    public Tela_Principal() throws IOException {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(400, 400, 400, 400);
        setResizable(false);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        
        java.net.URL gifUrl = getClass().getResource("/DonPolloGif.gif");
        if (gifUrl == null) {
            System.err.println("❌ GIF não encontrado.");
        } else {
            ImageIcon gifIcon = new ImageIcon(gifUrl);
            JLabel label = new JLabel(gifIcon);
            panel.add(label);
            panel.revalidate();
            panel.repaint();
        }
     
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/DonPolloAudio.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tela_Principal frame2 = new Tela_Principal();
                frame2.setVisible(true); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}