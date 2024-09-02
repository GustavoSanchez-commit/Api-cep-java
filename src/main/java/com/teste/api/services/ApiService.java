package com.teste.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.api.dto.EnderecoDto;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ApiService {
    EnderecoDto enderecoDto = new EnderecoDto();
    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException{
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(),EnderecoDto.class); 
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        return enderecoDto;
    }
}
