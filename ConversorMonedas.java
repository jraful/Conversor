import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

public class ConversorMonedas {

    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0;
        String menu = """
                **** Conversor de moneda****
                ***Escriba el número de la opción deseada ***
                1 - Dolar a peso Colombiano
                2 - Peso Colombiano a Dolar
                3 - Dolar a Real Brasileño
                4 - Real Brasileño a Dolar
                9 - Salir
                """;

        while (opcion != 9) {
            System.out.println(menu);
            Scanner teclado = new Scanner(System.in);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Indique la cantidad de dolares a convertir a pesos");
                    Scanner cantidad = new Scanner(System.in);
                    String cant = cantidad.next();
                    String direccion = "https://api.fastforex.io/convert?from=usd&to=cop&amount=" +cant+"&api_key=fde2d878b4-b874af6541-sch4rv";

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(direccion))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    System.out.println(response.body());

                    break;
                    case 2:
                        System.out.println("Indique la cantidad de pesos a convertir a dolares");
                        Scanner cantidad1 = new Scanner(System.in);
                        String cant1 = cantidad1.next();
                        String direccion1 = "https://api.fastforex.io/convert?from=cop&to=usd&amount=" +cant1+"&api_key=fde2d878b4-b874af6541-sch4rv";

                        HttpClient client1 = HttpClient.newHttpClient();
                        HttpRequest request1 = HttpRequest.newBuilder()
                                .uri(URI.create(direccion1))
                                .build();
                        HttpResponse<String> response1 = client1
                                .send(request1, HttpResponse.BodyHandlers.ofString());

                        System.out.println(response1.body());

                        break;
                    case 3:
                        System.out.println("Indique la cantidad de dolares a convertir a Reales Brasileño");
                        Scanner cantidad2 = new Scanner(System.in);
                        String cant2 = cantidad2.next();
                        String direccion2 = "https://api.fastforex.io/convert?from=usd&to=brl&amount=" +cant2+"&api_key=fde2d878b4-b874af6541-sch4rv";

                        HttpClient client2 = HttpClient.newHttpClient();
                        HttpRequest request2 = HttpRequest.newBuilder()
                                .uri(URI.create(direccion2))
                                .build();
                        HttpResponse<String> response2 = client2
                                .send(request2, HttpResponse.BodyHandlers.ofString());

                        System.out.println(response2.body());

                        break;
                case 4:
                    System.out.println("Indique la cantidad de Reales Brasileños a convertir a dolares");
                    Scanner cantidad3 = new Scanner(System.in);
                    String cant3 = cantidad3.next();
                    String direccion3 = "https://api.fastforex.io/convert?from=brl&to=usd&amount=" +cant3+"&api_key=fde2d878b4-b874af6541-sch4rv";

                    HttpClient client3 = HttpClient.newHttpClient();
                    HttpRequest request3 = HttpRequest.newBuilder()
                            .uri(URI.create(direccion3))
                            .build();
                    HttpResponse<String> response3 = client3
                            .send(request3, HttpResponse.BodyHandlers.ofString());

                    System.out.println(response3.body());

                    break;
                    case 9:
                        System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                        break;
                default:
                    System.out.println("Opción inválida");
                    break;






            }
        }


    }
}