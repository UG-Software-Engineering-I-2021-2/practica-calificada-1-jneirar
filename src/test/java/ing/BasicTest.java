package ing;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class BasicTest {
    @Test()
    public void BasicTest() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("Libro 1", 2000, "Jorge", EstadoLibro.EN_BIBLIOTECA);
        Assert.assertEquals("Libro 1", libro1.getNombre());
        Assert.assertEquals(2000, libro1.getAnio());
        Assert.assertEquals("Jorge", libro1.getAutor());
        Assert.assertEquals(EstadoLibro.EN_BIBLIOTECA, libro1.getEstadoLibro());
        libro1.setNombre("Libro X");
        libro1.setAnio(1900);
        libro1.setAutor("Jorge 2");
        libro1.setEstadoLibro(EstadoLibro.RESERVADA);
        Assert.assertEquals("Libro X", libro1.getNombre());
        Assert.assertEquals(1900, libro1.getAnio());
        Assert.assertEquals("Jorge 2", libro1.getAutor());
        Assert.assertEquals(EstadoLibro.RESERVADA, libro1.getEstadoLibro());

        Copia copia1_libro1 = new Copia(libro1, 1, EstadoLibro.EN_BIBLIOTECA);
        Assert.assertEquals(1, copia1_libro1.getId());
        Assert.assertEquals(EstadoLibro.EN_BIBLIOTECA, copia1_libro1.getEstadoCopia());
        copia1_libro1.setId(2);
        copia1_libro1.setEstadoCopia(EstadoLibro.RESERVADA);
        Assert.assertEquals(2, copia1_libro1.getId());
        Assert.assertEquals(EstadoLibro.RESERVADA, copia1_libro1.getEstadoCopia());

        Lector lector2 = new Lector("Juan", "16/01/1955");
        Assert.assertEquals("Juan", lector2.getNombre());
        Assert.assertEquals("16/01/1955", lector2.getFechaNacimiento());
        lector2.setNombre("Juan 2");
        lector2.setFechaNacimiento("16/01/1956");
        Assert.assertEquals("Juan 2", lector2.getNombre());
        Assert.assertEquals("16/01/1956", lector2.getFechaNacimiento());
    }
}
