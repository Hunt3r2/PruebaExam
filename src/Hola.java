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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;

public class Hola extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Persona clasePersona;
    private Persona persona[] = new Persona[10];
    private int contador = 0;
    private JTextField txtBuscarPersona;
    private JTextField textField;
    private JTextField textField_1;
    private ButtonGroup grupoRadio;
    private JRadioButton rdbtnH;
    private JRadioButton rdbtnM;

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
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(153, 180, 209), null), "Crear persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 45, 150, 180);
        contentPane.add(panel);
        panel.setVisible(false);
        
        textField = new JTextField();
        panel.add(textField);
        textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        panel.add(textField_1);
        textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Apellido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        textField_1.setColumns(10);
        
        rdbtnH = new JRadioButton("Hombre");
        panel.add(rdbtnH);
        
        rdbtnM = new JRadioButton("Mujer");
        panel.add(rdbtnM);
        
        grupoRadio = new ButtonGroup();
        grupoRadio.add(rdbtnH);
        grupoRadio.add(rdbtnM);
        
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearPersonaAMano();
            }
        });
        panel.add(btnCrear);

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
        
        JButton btnNewButton_1 = new JButton("Mostrar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btnNewButton_1.getText() == "Mostrar") {
                    panel.setVisible(true);
                    btnNewButton_1.setText("Ocultar");
                }else {
                    panel.setVisible(false);
                    btnNewButton_1.setText("Mostrar");
                }
                
                
                
            }
        });
        btnNewButton_1.setBounds(10, 11, 150, 23);
        contentPane.add(btnNewButton_1);

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
    
    public void crearPersonaAMano() {
        String nombre = textField.getText();
        String apellido = textField_1.getText();
        String genero = "";

        if (rdbtnH.isSelected()) {
            genero = "Hombre";
        } else if (rdbtnM.isSelected()) {
            genero = "Mujer";
        }

        persona[contador] = new Persona(nombre, apellido, genero.equals("Hombre"), genero);
        contador++;
    }
}
