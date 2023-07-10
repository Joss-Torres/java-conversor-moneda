
import javax.swing.JOptionPane;

public class ConversorMoneda {
	public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al Conversor de Moneda");

        boolean continuar = true;
        while (continuar) {
            double cantidad = obtenerCantidad();

            String monedaOrigen = obtenerMoneda("Selecciona la moneda de origen:");
            String monedaDestino = obtenerMoneda("Selecciona la moneda de destino:");

            double tasaConversion = obtenerTasaConversion(monedaOrigen, monedaDestino);
            if (tasaConversion != -1) {
                double cantidadConvertida = cantidad * tasaConversion;
                mostrarResultado(cantidadConvertida, monedaDestino);
            } else {
                mostrarError("No se encontró una tasa de conversión para las monedas ingresadas.");
            }

            int respuesta = mostrarPregunta("¿Deseas realizar otra conversión?");
            if (respuesta == JOptionPane.YES_OPTION) {
                continuar = true;
            } else {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
            }
        }
    }

    private static double obtenerCantidad() {
        String cantidadStr = JOptionPane.showInputDialog(null, "Ingresa la cantidad a convertir:");
        return Double.parseDouble(cantidadStr);
    }

    private static String obtenerMoneda(String mensaje) {
        String[] monedas = { "USD", "EUR", "GBP", "JPY", "MXN" };
        return (String) JOptionPane.showInputDialog(null, mensaje, "Moneda", JOptionPane.PLAIN_MESSAGE, null, monedas,
                monedas[0]);
    }

    private static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) {
        // Simulación de llamada a la API de cambio de moneda

        // Ejemplo ficticio de tasas de conversión
        double tasaConversion = -1;
        if (monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("EUR")) {
            tasaConversion = 0.85;
        } else if (monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("GBP")) {
            tasaConversion = 0.73;
        } else if (monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("JPY")) {
            tasaConversion = 110.30;
        } else if (monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("MXN")) {
            tasaConversion = 19.84;
        } else if (monedaOrigen.equalsIgnoreCase("EUR") && monedaDestino.equalsIgnoreCase("USD")) {
            tasaConversion = 1.18;
        } else if (monedaOrigen.equalsIgnoreCase("EUR") && monedaDestino.equalsIgnoreCase("GBP")) {
            tasaConversion = 0.85;
        } else if (monedaOrigen.equalsIgnoreCase("EUR") && monedaDestino.equalsIgnoreCase("JPY")) {
            tasaConversion = 129.81;
        } else if (monedaOrigen.equalsIgnoreCase("EUR") && monedaDestino.equalsIgnoreCase("MXN")) {
            tasaConversion = 23.48;
        } else if (monedaOrigen.equalsIgnoreCase("GBP") && monedaDestino.equalsIgnoreCase("USD")) {
            tasaConversion = 1.37;
        } else if (monedaOrigen.equalsIgnoreCase("GBP") && monedaDestino.equalsIgnoreCase("EUR")) {
            tasaConversion = 1.18;
        } else if (monedaOrigen.equalsIgnoreCase("GBP") && monedaDestino.equalsIgnoreCase("JPY")) {
            tasaConversion = 154.00;
        } else if (monedaOrigen.equalsIgnoreCase("GBP") && monedaDestino.equalsIgnoreCase("MXN")) {
            tasaConversion = 28.07;
        } else if (monedaOrigen.equalsIgnoreCase("JPY") && monedaDestino.equalsIgnoreCase("USD")) {
            tasaConversion = 0.0091;
        } else if (monedaOrigen.equalsIgnoreCase("JPY") && monedaDestino.equalsIgnoreCase("EUR")) {
            tasaConversion = 0.0077;
        } else if (monedaOrigen.equalsIgnoreCase("JPY") && monedaDestino.equalsIgnoreCase("GBP")) {
            tasaConversion = 0.0065;
        } else if (monedaOrigen.equalsIgnoreCase("JPY") && monedaDestino.equalsIgnoreCase("MXN")) {
            tasaConversion = 0.181;
        } else if (monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("USD")) {
            tasaConversion = 0.050;
        } else if (monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("EUR")) {
            tasaConversion = 0.043;
        } else if (monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("GBP")) {
            tasaConversion = 0.036;
        } else if (monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("JPY")) {
            tasaConversion = 5.51;
        }
        return tasaConversion;
    }

    private static void mostrarResultado(double cantidadConvertida, String monedaDestino) {
        JOptionPane.showMessageDialog(null, "El resultado de la conversión es: " + cantidadConvertida + " " + monedaDestino);
    }

    private static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static int mostrarPregunta(String pregunta) {
        return JOptionPane.showConfirmDialog(null, pregunta, "Pregunta", JOptionPane.YES_NO_OPTION);
    }
}
