import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    ConsultaMoneda consultaMoneda = new ConsultaMoneda();
    Scanner teclado = new Scanner(System.in);
    int opcion = 0;

    String divisaOrigen;
    String divisaDestino;
    double cantidad;

    System.out.println("******************");
    System.out.println("¡Bienvenido/a al conversor de monedas!");
    System.out.println("******************\n");

    String menu = """
          1 ---> Lista de divisas (LATAM)
          2 ---> Conversión de monedas
          9 ---> Salir
          """;

    while (opcion != 9) {
      System.out.println("Seleccione el número de la operación que desee realizar:");
      System.out.println(menu);
      opcion = teclado.nextInt();

      switch (opcion) {
        case 1:
          String codigosLatam = """
              Argentina === ARS
              Brasil === BRL
              Chile === CLP
              Colombia === COP
              México === MXN
              Nicaragua === NIO
              Paraguay === PYG
              Perú === PEN
              Uruguay === UYU\n
              Para una lista más detallada, consulte la página https://www.exchangerate-api.com/docs/supported-currencies\n
              """;
          System.out.println(codigosLatam);
          break;
        case 2:
          System.out.println("Escriba la clave de la divisa de origen");
          divisaOrigen = teclado.next().toUpperCase();

          if (divisaOrigen.length() != 3) {
            System.out.println("La clave debe tener solo tres caracteres");
            System.out.println("Escriba la clave de la divisa de origen");
            divisaOrigen = teclado.next().toUpperCase();
          }

          System.out.println("Escriba la clave de la divisa destino");
          divisaDestino = teclado.next().toUpperCase();

          if (divisaDestino.length() != 3) {
            System.out.println("La clave debe tener solo tres caracteres\n");
            System.out.println("Escriba la clave de la divisa destino");
            divisaDestino = teclado.next().toUpperCase();
          }

          System.out.println("Ingrese la cantidad a convertir");
          cantidad = teclado.nextDouble();

          Moneda moneda = consultaMoneda.buscaMoneda(divisaOrigen, divisaDestino, cantidad);

          System.out.println("Su resultado es: " + cantidad + " " + divisaOrigen + " son " + moneda.conversion_result() + " " + divisaDestino + "\n");
          break;
        case 9:
          System.out.println("******************");
          System.out.println("¡Gracias por usar el conversor de monedas! Vuelva pronto :D");
          System.out.println("******************\n");
          break;
        default:
          System.out.println("Opción no válida. Intente otra vez\n");
      }
    }
  }
}

/*
    try {
      String codigoBase = "USD";
      String codigoDestino = "MXN";
      double cantidad = 100;

      Moneda moneda = consultaMoneda.buscaMoneda(codigoBase, codigoDestino, cantidad);
      System.out.println(moneda);
      System.out.println("Resultado de la conversión de " + cantidad + " " + codigoBase + " a " + codigoDestino + ": " + moneda.conversion_result());
    } catch(RuntimeException e) {
      System.out.println(e.getMessage());
    }
*/