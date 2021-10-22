package ing;

import java.util.ArrayList;
import java.util.List;

public class Lector {
    String nombre;
    String fechaNacimiento;
    List<Libro> librosSuscritos;

    public Lector(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        librosSuscritos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void update(Libro libro){
        if(librosSuscritos.contains(libro)){
            //notificación de que el libro suscrito está disponible, dirigirse a tienda
        }
    }
    public void addLibroSuscrito(Libro libro){
        if(!librosSuscritos.contains(libro)){
            librosSuscritos.add(libro);
        }
    }
}
