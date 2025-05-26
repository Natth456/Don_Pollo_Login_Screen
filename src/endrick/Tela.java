package endrick;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Tela() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField user = new TextField();
		user.setBounds(10, 76, 289, 22);
		contentPane.add(user);
		user.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(309, 11, 115, 239);
		contentPane.add(panel);
		
		
		Button button = new Button("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 166, 83, 61);
		contentPane.add(button);
		try {
		BufferedImage donPollo2 = ImageIO.read(getClass().getResourceAsStream("/DonPolloImagem.jpg"));
		Image scaledImage = donPollo2.getScaledInstance(panel.getWidth(),panel.getHeight(),donPollo2.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(scaledImage));
		panel.add(label);
		} catch (IOException e) {
			
		}
		
		
		Button button_1 = new Button("CADASTRAR");
		button_1.setBounds(214, 166, 85, 61);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showConfirmDialog(null,"YuhUH",null,2,JOptionPane.PLAIN_MESSAGE);
            }
        });
		Button button_2 = new Button("LIGANGU");
		button_2.setBounds(113, 166, 85, 61);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("Don Pollo Logging Screen Deluxe Edition Battle Pass Fortnite");
		lblNewLabel.setBounds(10, 11, 289, 14);
		contentPane.add(lblNewLabel);
		
		Label label_1 = new Label("Usuário");
		label_1.setBounds(10, 48, 62, 22);
		contentPane.add(label_1);
		
		TextField senha = new TextField();
		senha.setBounds(10, 127, 289, 22);
		contentPane.add(senha);
		
		Label label_2 = new Label("Senha");
		label_2.setBounds(10, 104, 62, 22);
		contentPane.add(label_2);
		
		
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String user1 = user.getText();
        		String senha1 = senha.getText();
            	if(user1.equals("sigma") & senha1.equals("alta"))  {
            		JOptionPane.showConfirmDialog(null,"Logged as " + user.getText(),null,2,JOptionPane.PLAIN_MESSAGE);
               		Tela_Principal entrada = null;
					try {
						entrada = new Tela_Principal();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		entrada.setVisible(true); 
                 	}
            	else {
            	
            		JOptionPane.showConfirmDialog(null,"Senha ou Usuário não identificados",null,2,JOptionPane.PLAIN_MESSAGE);
            	}
            }
        });
	}
}

