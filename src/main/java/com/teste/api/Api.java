package com.teste.api;

import com.teste.api.dto.EnderecoDto;
import com.teste.api.services.ApiService;
import java.io.IOException;
import java.util.Scanner;

public class Api {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Qual o seu nome?");
        String nome = ler.next();

        while (true) {
            System.out.println("Qual o seu CEP?");
            String cep = ler.next();

            ApiService apiService = new ApiService();

            try {
                EnderecoDto enderecoDto = apiService.getEndereco(cep);

                if (enderecoDto.getLogradouro() == null || enderecoDto.getLogradouro().isEmpty()) {
                    System.out.println("CEP informado incorreto. Tente novamente.");
                } else {
                    System.out.println("Olá, " + nome + ", você mora na " + enderecoDto.getLogradouro() + "? [sim/nao]");
                    String escolha = ler.next();

                    if (!escolha.equalsIgnoreCase("sim")) {
                        System.out.println("CEP informado incorreto.");
                    } else {
                        System.out.println("CEP confirmado.");
                        break; // Encerra o loop caso a resposta seja "sim"
                    }
                }
            } catch (IOException | InterruptedException ex) {
                System.out.println("Erro ao buscar o endereço. Tente novamente.");
            }
        }

        ler.close(); // Fecha o Scanner para liberar recursos
    }
}
