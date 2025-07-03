import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Carrito {
    private List<Producto> catalogoProductos;
    private CarritoDeCompras miCarrito;
    private Scanner scanner;

    public Carrito() {
        catalogoProductos = new ArrayList<>();
        miCarrito = new CarritoDeCompras();
        scanner = new Scanner(System.in);
        inicializarProductos();
    }

    private void inicializarProductos() {
        catalogoProductos.add(new Producto(1, "Leche PIL", 12.50));
        catalogoProductos.add(new Producto(2, "Arroz Grano Oro 5kg", 35.00));
        catalogoProductos.add(new Producto(3, "Azúcar Guabirá 1kg", 8.90));
        catalogoProductos.add(new Producto(4, "Aceite Fino 900ml", 15.75));
        catalogoProductos.add(new Producto(5, "Pan de Molde BIMBO", 22.00));
        catalogoProductos.add(new Producto(6, "Carne Molida", 45.00)); // Precio por kg aproximado
        catalogoProductos.add(new Producto(7, "Jugo Del Valle 1L", 10.50));
        catalogoProductos.add(new Producto(8, "Detergente OMO 1kg", 28.00));
        catalogoProductos.add(new Producto(9, "Manzanas (kg)", 18.00));
        catalogoProductos.add(new Producto(10, "Huevos (docena)", 16.00));
    }

    public void verCatalogo() {
        System.out.println("\n======= Catálogo de Productos Hipermaxi =======");
        for (Producto p : catalogoProductos) {
            System.out.println(p);
        }
        System.out.println("==============================================");
    }

    public void mostrarMenu() {
        System.out.println("\n==========================================");
        System.out.println("        🛒 SISTEMA DE COMPRAS EN CONSOLA");
        System.out.println("==========================================");
        System.out.println("1. Ver catálogo de productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Finalizar compra");
        System.out.println("0. Salir");
        System.out.println("==========================================");
        System.out.print("Seleccione una opción: ");
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcionUsuario();
            switch (opcion) {
                case 1:
                    verCatalogo();
                    break;
                case 2:
                    agregarProductoAlCarrito();
                    break;
                case 3:
                    miCarrito.verCarrito();
                    break;
                case 4:
                    eliminarProductoDelCarrito();
                    break;
                case 5:
                    miCarrito.finalizarCompra();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema de compras de Hipermaxi! 👋");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private int obtenerOpcionUsuario() {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return opcion;
    }

    private void agregarProductoAlCarrito() {
        verCatalogo();
        System.out.print("Ingrese el CÓDIGO del producto que desea agregar: ");
        int codigoProducto = obtenerOpcionUsuario();

        Producto productoSeleccionado = buscarProductoPorCodigo(codigoProducto);

        if (productoSeleccionado != null) {
            miCarrito.agregarProducto(productoSeleccionado);
        } else {
            System.out.println("🚫 El código de producto no existe. Intente de nuevo.");
        }
    }

    private Producto buscarProductoPorCodigo(int codigo) {
        for (Producto p : catalogoProductos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private void eliminarProductoDelCarrito() {
        miCarrito.verCarrito();
        if (miCarrito.calcularTotal() == 0) {
            System.out.println("El carrito está vacío, no hay productos para eliminar.");
            return;
        }
        System.out.print("Ingrese el NÚMERO de línea del producto a eliminar (empezando desde 1): ");
        int indiceAEliminar = obtenerOpcionUsuario();
        miCarrito.eliminarProducto(indiceAEliminar - 1);
    }

    public static void main(String[] args) {
        Carrito sistema = new Carrito();
        sistema.ejecutar();
    }
}