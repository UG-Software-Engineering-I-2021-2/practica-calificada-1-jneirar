package ing;

public class Copia extends Libro{
    int id;
    EstadoLibro estadoCopia;

    public Copia(Libro libro, int id, EstadoLibro estadoCopia) {
        super(libro.getNombre(), libro.getAnio(), libro.getAutor(), libro.getEstadoLibro());
        this.id = id;
        this.estadoCopia = estadoCopia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstadoCopia(EstadoLibro estadoCopia){
        this.estadoCopia = estadoCopia;
    }
    public EstadoLibro getEstadoCopia(){
        return this.estadoCopia;
    }
}
