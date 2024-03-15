import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hola_parte_3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String nombres[] = {"Sadako", "Samara", "Rachel", "Aidan", "Yoichi", "Ring"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hola_parte_3 frame = new Hola_parte_3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hola_parte_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarInfo();
			}
		});
		btnNewButton.setBounds(165, 117, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	
	public void mostrarInfo() {
	StringBuilder a = new StringBuilder();
	for (int i = 0; i < 6;i++) {
		a.append("Nombre: ").append(nombres[i]).append("\n");
	}
		JOptionPane.showMessageDialog(this, a.toString(), "Información", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}
}
