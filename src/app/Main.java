package app;
import domain.ItemCatalogo;
import domain.Cliente;
import service.LavanderiaService;

public class Main {
    public static void main(String[] args) {
        var service = new LavanderiaService();
        var cliente = new Cliente("Malu", "3122525785");
        var orden = service.crearOrden(cliente);
        service.agregarItem(orden, ItemCatalogo.CAMISA, 6);
        service.agregarItem(orden, ItemCatalogo.PANTALON, 5);
        service.agregarItem(orden, ItemCatalogo.CHAQUETA, 2);
        service.setServicioExpres(orden, true);
        System.out.println(service.resumen(orden));
        // CONFIRMAR
        service.confirmar(orden);
        System.out.println("Orden confirmada: " + orden.getEstado());
    }
}