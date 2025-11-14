package service;
import domain.ItemCatalogo;
import domain.Cliente;
import domain.Orden;

public class LavanderiaService {
    public Orden crearOrden(Cliente cliente) {
        return new Orden(cliente);
    }
    
    public void agregarItem(Orden o, ItemCatalogo servicio, int cant) {
        o.agregarItem(servicio, cant);
    }
    
    public void setServicioExpres(Orden o, boolean expres) {
        o.setServicioExpres(expres);
    }
    
    public void confirmar(Orden o) {
        o.confirmar();
    }
    
    public String resumen(Orden o) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RESUMEN DE LA ORDEN ===\n");
        sb.append("Cliente: ").append(o.getCliente().nombre()).append(" | Tel: ").append(o.getCliente().telefono())
                .append("\n");
        sb.append("Estado: ").append(o.getEstado()).append("\n");
        sb.append("Servicio Expres: ").append(o.isServicioExpres() ? "SI" : "NO").append("\n");
        sb.append("---------------------------------------\n");
        for (var iterable_element : o.getItems()) {
            sb.append(String.format(
                    "%-15s x%-3d unit=%,6d  subtotal=%,7d\n",
                    iterable_element.getServicio(),
                    iterable_element.getCantidad(),
                    iterable_element.precioUnitarioAplicado(),
                    iterable_element.subtotal()));
        }
        sb.append("---------------------------------------\n");
        int bruto = o.totalBruto();
        int recargo = o.recargoExpres();
        int descuento = o.descuento();
        int total = o.totalFinal();
        sb.append(String.format("Total bruto:     %,9d\n", bruto));
        if (recargo > 0) {
            sb.append(String.format("Recargo expres:  %,9d\n", recargo));
        }
        if (descuento > 0) {
            sb.append(String.format("Descuento:       %,9d\n", descuento));
        }
        sb.append(String.format("Total final:     %,9d\n", total));
        return sb.toString();
    }
}