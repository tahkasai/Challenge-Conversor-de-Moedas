package Service;

import Client.ClientMoeda;
import Model.Moeda;
import Model.RecordMoeda;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class ServiceMoeda {
    private final ClientMoeda client = new ClientMoeda();
    private final Gson gson = new Gson();

    public void converteMoeda(String moedaBase, String moedaConvetida, double valor){
        try {
            String json = client.buscarMoeda(moedaBase);

            RecordMoeda recordMoeda = gson.fromJson(json, RecordMoeda.class);

            Moeda moeda = new Moeda(recordMoeda);
            double valorConvetido = moeda.acharConversao(moedaConvetida);
            double resultado = valor * valorConvetido;

            System.out.println("\n***********************************************");
            System.out.println(valor+"["+moedaBase+"] corresponde ao valor final de "+resultado+"["+moedaConvetida+"]");
            System.out.println("***********************************************\n");

        } catch (IOException e) {
            throw new RuntimeException("Erro ao buscar dados da API", e);
        }
        catch (JsonSyntaxException | InterruptedException e) {
            throw new RuntimeException("Erro ao converter JSON", e);
        }
    }
}
