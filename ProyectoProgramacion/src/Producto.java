// Producto.java
class Producto {
    private String nombre;
    private double precio;
    private int codigo;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%d. %-15s Bs. %.2f", codigo, nombre, precio);
    }
}