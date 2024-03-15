public class Persona {
    
    private String nombres;
    private String apellidos;
    private boolean esHombre;
    private String genero;

    public Persona(String nombre, String apellido, boolean esHombre, String genero) {
        this.nombres = nombre;
        this.apellidos = apellido;
        this.esHombre = esHombre;
        this.genero = genero;
    }

    public String getNombre() {
        String[] listaNombres = nombres.split(" ");
        return listaNombres[(int) (Math.random() * listaNombres.length)];
    }

    public String getApellido() {
        String[] listaApellidos = apellidos.split(" ");
        return listaApellidos[(int) (Math.random() * listaApellidos.length)];
    }

    public boolean esHombre() {
        return esHombre;
    }

    public boolean esMujer() {
        return !esHombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
