package domain;
import java.util.Objects;

public class DetalleOrden {
    private final ItemCatalogo servicio;
    private final int cantidad;
    
    public DetalleOrden(ItemCatalogo servicio, int cantidad) {
        this.servicio = Objects.requireNonNull(servicio, "servicio requerido");
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad debe ser > 0");
        this.cantidad = cantidad;
    }
    
    public ItemCatalogo getServicio() {
        return servicio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public int precioUnitarioAplicado(){
        return (cantidad >= 5) ? servicio.getPrecioVolumen() : servicio.getPrecio();
    }
    
    public int subtotal(){
        return precioUnitarioAplicado() * cantidad;
    }
    
    @Override
    public String toString() {
        return "%s x%d (unit=%,d) subtotal=%,d".formatted(servicio.name(), cantidad, precioUnitarioAplicado(), subtotal());
    }
}