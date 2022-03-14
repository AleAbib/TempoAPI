package tempo.util;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import tempo.controller.CidadeController;
import tempo.model.Cidade;

public class PrevisaoUtil {

	private String uri;
	private CidadeController cidadeController = new CidadeController();

	public PrevisaoUtil(Cidade cidade) {
		System.out.println(cidade.getNome());
		uri = "https://api.hgbrasil.com/weather?key=01c9075b&array_limit=5&locale=pt&fields=only_results,"
				+ "city_name,date,description,temp,currently,forecast,weekday,max,min,date&city_name=" + cidade.getNome();
		System.out.println(uri);
		getAPINome(cidade);
//		getAPITemp(cidade);
//		getAPIDate(cidade);
//		getAPIDesc(cidade);
		cidadeController.atualizar(cidade);
		
	}

	public void getAPINome(Cidade cidade) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String nome = doc.getElementsByTagName("city_name").item(0).getTextContent();
			System.out.println(nome);
			//cidade.setNome(nome);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public void getAPITemp(Cidade cidade) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String temp = doc.getElementsByTagName("temp").item(0).getTextContent();
			int tempInt = Integer.parseInt(temp);
			
			cidade.setTemperatura(tempInt);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void getAPIDate(Cidade cidade) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String date = doc.getElementsByTagName("date").item(0).getTextContent();
			
			cidade.setData(date);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void getAPIDesc (Cidade cidade) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String descricao = doc.getElementsByTagName("descricao").item(0).getTextContent();
			
			cidade.setDescricao(descricao);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
