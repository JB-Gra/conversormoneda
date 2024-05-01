import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
  public Moneda buscaMoneda(String codigoBase, String codigoDestino, double cantidadAConvertir) {
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9aee1a5c942de583eb24651a/pair/" + codigoBase + "/" + codigoDestino + "/" + cantidadAConvertir);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(direccion)
        .build();

    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());
      return new Gson().fromJson(response.body(), Moneda.class);
    } catch (Exception e) {
      throw new RuntimeException("No encontré ningún dato");
    }
  }
}
