import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Dos cajas con los cajeros mas sensuales
        Thread caja1 = new Thread(new Clientes("Iván", 1));
        Thread caja2 = new Thread(new Clientes("Alberto", 2));



        List<Thread> hilosClientes = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String nombreCliente = "Cliente " + i;
            int cajaAsignada = (i % 2) == 0 ? 2 : 1;  // se alternan las cajas al azar
            Thread cliente = new Thread(new Clientes(nombreCliente, cajaAsignada));
            hilosClientes.add(cliente);
        }

        for (Thread cliente : hilosClientes) {
            cliente.start();
        }


        for (Thread cliente : hilosClientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Se acabó.");
    }
}