package ing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    List<Lector> lectoresSuscritos;
    //Guarda lectores y libros o copas prestados
    HashMap<Lector, List<Libro>> lectorLibro;
    //Guarda los que aun no devuelven
    HashMap<Lector, Integer> castigados;
    //Multa pendiente si ya devolvieron
    HashMap<Lector, Integer> multas;

    Biblioteca(){
        lectoresSuscritos = new ArrayList<>();
        lectorLibro = new HashMap<>();
        castigados = new HashMap<>();
        multas = new HashMap<>();
    }

    public void subscribir(Lector lector, Libro libro){
        lector.addLibroSuscrito(libro);
        lectoresSuscritos.add(lector);
    }
    public void desubscribir(Lector lector){
        if(lectoresSuscritos.contains(lector)){
            lectoresSuscritos.remove((lector));
        }
    }
    public void notificar(Libro libro){
        for(Lector lector : lectoresSuscritos){
            lector.update(libro);
        }
    }

    public String prestarLibro(Libro libro, Lector lector){
        String res;
        if(libro.getEstadoLibro() == EstadoLibro.EN_BIBLIOTECA){
            if(lectorLibro.containsKey(lector)){
                //Ya tiene algun libro o copia
                if(lectorLibro.get(lector).size() == 3){
                    res = "No se puede prestar por tener más de 3 libros o copias";
                }else if(castigados.containsKey(lector) || multas.containsKey(lector)){
                    res = "Lector castigado";
                }else{
                    //3 representa la fecha de prestamo
                    libro.setFechaPrestamo(3);
                    List<Libro> lista = lectorLibro.get(lector);
                    lista.add(libro);
                    lectorLibro.put(lector, lista);
                    res = "Prestando libro";
                }
            }else{
                //3 representa la fecha de prestamo
                libro.setFechaPrestamo(3);
                List<Libro> lista = new ArrayList<>();
                lista.add(libro);
                lectorLibro.put(lector, lista);
                res = "Prestando libro";
            }
        }else{
            res = "No se puede prestar libro";
        }
        return res;
    }
    public String prestarCopia(Copia copia, Lector lector){
        String res;
        if(copia.getEstadoLibro() == EstadoLibro.EN_BIBLIOTECA){
            if(lectorLibro.containsKey(lector)){
                //Ya tiene algun libro o copia
                if(lectorLibro.get(lector).size() == 3){
                    res = "No se puede prestar por tener más de 3 libros o copias";
                }else{
                    //3 representa la fecha de prestamo
                    copia.setFechaPrestamo(3);
                    List<Libro> lista = lectorLibro.get(lector);
                    lista.add(copia);
                    lectorLibro.put(lector, lista);
                    res = "Prestando copia";
                }
            }else{
                //3 representa la fecha de prestamo
                copia.setFechaPrestamo(3);
                List<Libro> lista = new ArrayList<>();
                lista.add(copia);
                lectorLibro.put(lector, lista);
                res = "Prestando copia";
            }
        }else{
            res = "No se puede prestar copia";
        }
        return res;
    }

    String devolverLibro(Libro libro, Lector lector){
        List<Libro> libros = lectorLibro.get(lector);
        libros.remove(libro);
        lectorLibro.put(lector, libros);
        //Si está castigado, quitar castigo y pasar a multa
        if(castigados.containsKey(lector)){
            multas.put(lector, castigados.get(lector));
            castigados.remove(lector);
        }
        return "Libro devuelto";
    }

    String devolverCopia(Copia copia, Lector lector){
        List<Libro> libros = lectorLibro.get(lector);
        libros.remove(copia);
        lectorLibro.put(lector, libros);
        //Si está castigado, quitar castigo y pasar a multa
        if(castigados.containsKey(lector)){
            multas.put(lector, castigados.get(lector));
            castigados.remove(lector);
        }
        return "Copia devuelta";
    }

    //Función que cada día actualiza el estado de los libros prestados
    public void updateEveryHour(){
        for(Map.Entry<Lector,List<Libro>> entrie : lectorLibro.entrySet()){
            Lector lector = entrie.getKey();
            for(Libro libro : lectorLibro.get(lector)){
                //4 representa la fecha actual
                if(libro.getFechaPrestamo() > 4){
                    if(castigados.containsKey(lector)){
                        castigados.put(lector, castigados.get(lector) + 2);
                    }else{
                        castigados.put(lector, 2);
                        libro.setEstadoLibro(EstadoLibro.CON_RETRASO);
                    }
                }
            }
        }
        for(Map.Entry<Lector,Integer> entrie : multas.entrySet()){
            Lector lector = entrie.getKey();
            if(multas.get(lector) == 2){
                multas.remove(lector);
            }
            multas.put(lector, multas.get(lector) - 2);
        }

    }
}
