package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Orden {
    private final Cliente cliente;
    private final List<DetalleOrden> items = new ArrayList<>();
    private EstadoOrden estado = EstadoOrden.EN_CREACION;
    private boolean servicioExpres = false;
    
    public Orden(Cliente cliente) {
        this.cliente = Objects.requireNonNull(cliente, "cliente requerido");
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<DetalleOrden> getItems() {
        return items;
    }
    
    public EstadoOrden getEstado() {
        return estado;
    }
    
    public boolean isServicioExpres() {
        return servicioExpres;
    }
    
    public void setServicioExpres(boolean servicioExpres) {
        if (estado == EstadoOrden.CONFIRMADO) {
            throw new IllegalStateException("No se puede editar una orden CONFIRMADA");
        }
        this.servicioExpres = servicioExpres;
    }
    
    public void agregarItem(ItemCatalogo s, int cant) {
        if (estado == EstadoOrden.CONFIRMADO) {
            throw new IllegalStateException("No se puede editar una orden CONFIRMADA");
        }
        items.add(new DetalleOrden(s, cant));
    }
    
    public void confirmar() {
        if (items.isEmpty()) {
            throw new IllegalStateException("No se puede confirmar una orden vacia");
        }
        this.estado = EstadoOrden.CONFIRMADO;
    }
    
    public int totalBruto() {
        return items.stream().mapToInt(DetalleOrden::subtotal).sum();
    }
    
    public int recargoExpres() {
        if (!servicioExpres) {
            return 0;
        }
        return (int) Math.round(totalBruto() * 0.10);
    }
    
    public int totalConRecargo() {
        return totalBruto() + recargoExpres();
    }
    
    public int descuento() {
        int totalConRec = totalConRecargo();
        if (totalConRec > 60000) {
            return (int) Math.round(totalConRec * 0.05);
        }
        return 0;
    }
    
    public int totalFinal() {
        int totalConRec = totalConRecargo();
        int totalFinal = totalConRec - descuento();
        if (totalFinal < 0) {
            throw new IllegalStateException("Total no puede ser negativo");
        }
        return totalFinal;
    }
    
    @Override
    public String toString() {
        return "Orden{" + cliente + ", items=" + items.size() + ", estado=" + estado + "}";
    }
}