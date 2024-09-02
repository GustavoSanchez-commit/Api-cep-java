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
        System.out.println("Qual o seu CEP?");
        String cep = ler.next();
        
        ler.close();
        
        ApiService apiService = new ApiService();
        
        try {
            EnderecoDto enderecoDto = apiService.getEndereco(cep);
            System.out.println("Olá, " + nome + " você mora na " + enderecoDto.getLogradouro()+"?");
        } catch (IOException ex) {
            throw new RuntimeException();
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }
}
