import javax.swing.*;
import java.awt.event.*;

public class Hola_parte_2 extends JFrame {
    
    private JList<String> listaDatos;
    private String[] opciones = {"Pato", "Loro", "Perro", "Cuervo"};
    private JLabel etiquetaSeleccion;

    public Hola_parte_2() {
        setTitle("Ejemplo de Selección de Lista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        etiquetaSeleccion = new JLabel("Seleccione una opción:");
        panel.add(etiquetaSeleccion);
        
        listaDatos = new JList<>(opciones);
        listaDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaDatos);
        panel.add(scrollPane);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = listaDatos.getSelectedValue();
                if (seleccion != null) {
                    JOptionPane.showMessageDialog(Hola_parte_2.this, "Ha seleccionado: " + seleccion);
                } else {
                    JOptionPane.showMessageDialog(Hola_parte_2.this, "Por favor, seleccione una opción", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnAceptar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Hola_parte_2 ventana = new Hola_parte_2();
                ventana.setVisible(true);
            }
        });
    }
}
