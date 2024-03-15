import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class Hola extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Persona clasePersona;
    private Persona persona[] = new Persona[10];
    private int contador = 0;
    private JTextField txtBuscarPersona;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hola frame = new Hola();
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
    public Hola() {

    	clasePersona = new Persona(null, null, rootPaneCheckingEnabled, getTitle());
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNuevaPersona = new JMenu("Nueva Persona");
        menuBar.add(mnNuevaPersona);
        
        JMenuItem mntmHombre = new JMenuItem("Hombre");
        mnNuevaPersona.add(mntmHombre);
        
        JMenuItem mntmMujer = new JMenuItem("Mujer");
        mnNuevaPersona.add(mntmMujer);
        
        JMenu mnInfo = new JMenu("Mostrar Informacion");
        menuBar.add(mnInfo);
        
        JMenuItem mntmToda = new JMenuItem("Toda");
        mnInfo.add(mntmToda);
        
        JMenuItem mntmInfoHombre = new JMenuItem("Hombres");
        mnInfo.add(mntmInfoHombre);
        
        JMenuItem mntmInfoMujer = new JMenuItem("Mujeres");
        mnInfo.add(mntmInfoMujer);
        
        txtBuscarPersona = new JTextField();
        txtBuscarPersona.setText("Buscar persona");
        menuBar.add(txtBuscarPersona);
        txtBuscarPersona.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		buscar(txtBuscarPersona.getText());
        		
        	}
        });
        menuBar.add(btnNewButton);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 20, 114, 188);
        contentPane.add(scrollPane);
        
        JList list = new JList(persona);
        scrollPane.setViewportView(list);
        list.setValueIsAdjusting(true);

        mntmToda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion(false, true);
            }
        });
        
        mntmHombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearPersonasAutomaticamenteHombre(1);
            }
        });
        
        mntmMujer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	crearPersonasAutomaticamenteMujer(1);
            }
        });
        
        mntmInfoHombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion(true, false);
            }
        });
        
        mntmInfoMujer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion(false, false);
            }
        });

    }

    private void crearPersonasAutomaticamenteHombre(int cantidad) {
        String[] nombres = {"Juan", "Pedro", "Luis"};
        String[] apellidos = {"García", "Martínez", "López", "Fernández", "González"};
        String genero = "Hombre";

        for (int i = 0; i < cantidad; i++) {
            boolean esHombre = true;
            if (esHombre == true) {
                clasePersona.setGenero("Hombre");
            }
            String nombre = nombres[(int)(Math.random() * nombres.length)];
            String apellido = apellidos[(int)(Math.random() * apellidos.length)];
            persona[contador] = new Persona(nombre, apellido, esHombre, genero);
            contador++;
        }
    }

    private void crearPersonasAutomaticamenteMujer(int cantidad) {
        String[] nombres = {"María", "Ana", "Elena"};
        String[] apellidos = {"García", "Martínez", "López", "Fernández", "González"};
        String genero = "Mujer";

        for (int i = 0; i < cantidad; i++) {
            boolean esHombre = false;
            if (esHombre == false) {
                clasePersona.setGenero("Mujer");
            }
            String nombre = nombres[(int)(Math.random() * nombres.length)];
            String apellido = apellidos[(int)(Math.random() * apellidos.length)];
            persona[contador] = new Persona(nombre, apellido, esHombre, genero);
            contador++;
        }
    }



    private void mostrarInformacion(boolean esHombre, boolean todos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            if (persona[i] != null) {
                if (todos) {
                    sb.append("\nNombre: ").append(persona[i].getNombre()).append(", Apellido: ").append(persona[i].getApellido()).append("\n").append(", Genero: ").append(persona[i].getGenero()).append("\n---------------");
                } else { 
                    if (esHombre && persona[i].esHombre()) { 
                        sb.append("\nNombre: ").append(persona[i].getNombre()).append(", Apellido: ").append(persona[i].getApellido()).append("\n").append(", Genero: ").append(persona[i].getGenero()).append("\n---------------");
                    } else if (!esHombre && !persona[i].esHombre()) { 
                        sb.append("\nNombre: ").append(persona[i].getNombre()).append(", Apellido: ").append(persona[i].getApellido()).append("\n").append(", Genero: ").append(persona[i].getGenero()).append("\n---------------");
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void buscar(String nombre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            if (persona[i] != null) {
                System.out.println("Texto buscado: [" + txtBuscarPersona.getText() + "]");
                System.out.println("Nombre en el arreglo: [" + persona[i].getNombre() + "]");
                if (txtBuscarPersona.getText().trim().equalsIgnoreCase(persona[i].getNombre().trim())) {
                    sb.append("\nNombre: ").append(persona[i].getNombre()).append(", Apellido: ").append(persona[i].getApellido()).append("\n").append(", Genero: ").append(persona[i].getGenero()).append("\n---------------");
                }
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
}