package principal;

import modelos.ConsultarCEP;
import modelos.Endereco;
import modelos.GeradorJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsultarCEP consultar = new ConsultarCEP();
        List<Endereco> enderecos = new ArrayList<>();
        String buscarcep = "";

        // Menu
        while (!buscarcep.equalsIgnoreCase("sair")) {
            System.out.println("Digite o CEP, ou 'sair' para finalizar: ");
            buscarcep = scanner.nextLine();
            if (buscarcep.equalsIgnoreCase("sair")){
                break;
            }

            try {
                // Chamando a função para buscar o CEP
                Endereco resultado = consultar.buscarEnderecoPorCEP(buscarcep);
                System.out.println(resultado);
                // Adicionando o endereço na lista
                enderecos.add(resultado);

            } catch (RuntimeException e) {
                System.out.println("Erro ao buscar o CEP: " + e.getMessage());
            }
        }

        // Geração do arquivo JSON com todos os endereços
        if (!enderecos.isEmpty()) {
            GeradorJson gerador = new GeradorJson();
            gerador.geradorDeJson(enderecos); // Gera o JSON com todos os endereços
            System.out.println("Arquivo JSON gerado com sucesso!");
        } else {
            System.out.println("Nenhum CEP válido foi inserido.");
        }
    }
}
