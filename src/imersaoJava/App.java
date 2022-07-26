package imersaoJava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		
		//fazer conexao HTTP e buscar os tops 250 filmes
		
		// String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		System.out.println(body);
		
		//extrair s� os dados que interessam - titulo, poster e classificacao
		
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		//exibir e manipular os dados
		 for (Map<String, String> filme : listaDeFilmes) {

			 System.out.println(filme.get("title"));
			 System.out.println(filme.get("image"));
			 System.out.println(filme.get("imDbRating"));
			 System.out.println();
			 
			 
//	            System.out.println("\u001b[32;1m \u001b[47;1m" + filme.get("title") + " " + "\u001b[m");
//
//
//	            System.out.println(filme.get("image"));
//	            String rate = filme.get("imDbRating");
//	            System.out.println("\u001b[45;1m" + "Classifica��o: " + rate + "\u001b[m");
//	            System.out.println("\u2B50".repeat(Math.max(0, Math.round(Float.parseFloat(rate)))));
//	            System.out.println();

	        }
		
		
	}

}
