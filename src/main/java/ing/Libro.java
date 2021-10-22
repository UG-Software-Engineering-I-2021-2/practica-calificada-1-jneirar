package ing;

public class Libro {
    String nombre;
    int anio;
    String autor;
    //Uso de int solo para comparar
    int fechaPrestamo;
    EstadoLibro estadoLibro;

    public Libro(String nombre, int anio, String autor, EstadoLibro estadoLibro) {
        this.nombre = nombre;
        this.anio = anio;
        this.autor = autor;
        this.estadoLibro = estadoLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(int fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(EstadoLibro estadoLibro) {
        this.estadoLibro = estadoLibro;
    }
}
