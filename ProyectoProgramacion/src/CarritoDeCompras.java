// CarritoDeCompras.java
import java.util.ArrayList;
import java.util.List;

class CarritoDeCompras {
    private List<Producto> productosEnCarrito;

    public CarritoDeCompras() {
        this.productosEnCarrito = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productosEnCarrito.add(producto);
            System.out.println("✅ '" + producto.getNombre() + "' agregado al carrito.");
        }
    }

    public void verCarrito() {
        if (productosEnCarrito.isEmpty()) {
            System.out.println("🛒 El carrito está vacío.");
            return;
        }
        System.out.println("\n--- Productos en tu Carrito ---");
        for (Producto p : productosEnCarrito) {
            System.out.println("- " + p.getNombre() + " (Bs. " + String.format("%.2f", p.getPrecio()) + ")");
        }
        System.out.println("-----------------------------");
        System.out.println("💰 Total acumulado: Bs. " + String.format("%.2f", calcularTotal()));
        System.out.println("-----------------------------");
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productosEnCarrito) {
            total += p.getPrecio();
        }
        return total;
    }

    public void vaciarCarrito() {
        productosEnCarrito.clear();
    }

    public void finalizarCompra() {
        if (productosEnCarrito.isEmpty()) {
            System.out.println("El carrito está vacío. No hay nada que comprar.");
            return;
        }
        System.out.println("\n--- Finalizando Compra ---");
        System.out.println("Tu total a pagar es: Bs. " + String.format("%.2f", calcularTotal()));
        System.out.println("¡Gracias por tu compra en Hipermaxi!");
        vaciarCarrito();
        System.out.println("El carrito ha sido vaciado.");
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productosEnCarrito.size()) {
            Producto productoEliminado = productosEnCarrito.remove(index);
            System.out.println("❌ '" + productoEliminado.getNombre() + "' eliminado del carrito.");
        } else {
            System.out.println("Índice de producto no válido para eliminar.");
        }
    }
}