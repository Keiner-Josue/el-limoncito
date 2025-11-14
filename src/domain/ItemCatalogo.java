package domain;

public enum ItemCatalogo {
    CAMISA(4000, 3500),
    PANTALON(6000, 5000),
    CHAQUETA(9000, 7500);
    
    private final int precio;
    private final int precioVolumen;
    
    ItemCatalogo(int precio, int precioVolumen){
        this.precio = precio;
        this.precioVolumen = precioVolumen;
    }
    
    public int getPrecio() {
        return precio;
    }
    
    public int getPrecioVolumen() {
        return precioVolumen;
    }
}