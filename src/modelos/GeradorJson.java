package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorJson {
    public void geradorDeJson(List<Endereco> enderecos) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(enderecos);
        // gerando o arquivo JSON
        try (FileWriter writer = new FileWriter("enderecos.json")){
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }
}
