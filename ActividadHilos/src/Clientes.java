import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Clientes implements Runnable {
    private String nombre;
    private List<String> carrito;
    private int cajaNumero;

    public Clientes(String nombre, int cajaNumero) {
        this.nombre = nombre;
        this.cajaNumero = cajaNumero;
        this.carrito = new ArrayList<>();
        generarCarrito();
    }

    //se crea el array de los productos
    private void generarCarrito() {
        String[] productosDisponibles = {"Satisfyer", "Condones", "Libro de salud mental", "Soga", "Carne de kebab" , "Berenjenas", "Lubricante", "Chocobon", "Donetes", "Cerveza", "Cartuchos de escopeta", "Vaper", "Papel higienico", "Arepas" , "Lata de Monster"};
        Random random = new Random();
        int numProductos = random.nextInt(5) + 1; //el carrito llenara hasta 5 productos

        for (int i = 0; i < 5; i++) {
            carrito.add(productosDisponibles[random.nextInt(productosDisponibles.length)]);
        }
    }

    @Override
    public void run() {
        for (String producto : carrito) {
            mostrarProducto(producto);
        }
    }

    //tiempo para escanear los productos
    private void mostrarProducto(String producto) {
        try {
            double tiempoProceso = 0.5 + Math.random();  // establecer tiempo y pasar a milisegundos
            Thread.sleep((long) (tiempoProceso * 1000));
            System.out.printf("[Caja %d] %s, Producto: %s - Tiempo de proceso: %.2f segundos\n",
                    cajaNumero, nombre, producto, tiempoProceso);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}