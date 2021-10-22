package ing;

import org.junit.Assert;
import org.junit.Test;

public class BibliotecaTest {

    @Test()
    public void BibliotecaTest(){
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("Libro 1", 2000, "Jorge", EstadoLibro.EN_BIBLIOTECA);
        Libro libro2 = new Libro("Libro 2", 1995, "Juan", EstadoLibro.EN_BIBLIOTECA);
        Libro libro3 = new Libro("Libro 3", 2005, "Pedro", EstadoLibro.EN_BIBLIOTECA);
        Copia copia1_libro1 = new Copia(libro1, 1, EstadoLibro.EN_BIBLIOTECA);
        Copia copia2_libro1 = new Copia(libro1, 2, EstadoLibro.EN_BIBLIOTECA);
        Copia copia3_libro1 = new Copia(libro1, 3, EstadoLibro.EN_REPARACION);
        Copia copia1_libro2 = new Copia(libro2, 1, EstadoLibro.PRESTADA);
        Copia copia2_libro2 = new Copia(libro2, 2, EstadoLibro.CON_RETRASO);
        //lIBRO 3 es nuevo y no tiene copias

        Lector lector1 = new Lector("Jorge", "15/05/2000");
        Lector lector2 = new Lector("Juan", "16/01/1955");
        Lector lector3 = new Lector("Tmp", "...");


        Assert.assertEquals("Prestando copia", biblioteca.prestarCopia(copia2_libro1, lector2));
        Assert.assertEquals("Prestando copia", biblioteca.prestarCopia(copia3_libro1, lector2));
        Assert.assertEquals("Prestando copia", biblioteca.prestarCopia(copia1_libro2, lector1));
        Assert.assertEquals("Prestando copia", biblioteca.prestarCopia(copia2_libro2, lector3));


        biblioteca.subscribir(lector1, libro2);
        biblioteca.subscribir(lector2, libro3);
        biblioteca.subscribir(lector3, libro2);

        biblioteca.notificar(libro3);

        Assert.assertEquals("Prestando libro", biblioteca.prestarLibro(libro3, lector2));

        biblioteca.desubscribir(lector2);
        biblioteca.notificar(libro2);

        Assert.assertEquals("No se puede prestar por tener más de 3 libros o copias", biblioteca.prestarCopia(copia1_libro1, lector2));
        Assert.assertEquals("Prestando libro", biblioteca.prestarLibro(libro2, lector1));

        Assert.assertEquals("Libro devuelto", biblioteca.devolverLibro(libro3, lector2));
        Assert.assertEquals("Copia devuelta", biblioteca.devolverCopia(copia1_libro2, lector1));


        biblioteca.updateEveryHour();
        Assert.assertTrue(true);


    }
}
