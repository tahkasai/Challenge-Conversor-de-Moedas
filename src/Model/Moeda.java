package Model;

import java.util.Map;

public class Moeda {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Moeda(RecordMoeda recordMoeda){
        this.base_code = recordMoeda.base_code();
        this.conversion_rates = recordMoeda.conversion_rates();
    }

    public double acharConversao(String moedaConvertida) {
        Double taxa = conversion_rates.get(moedaConvertida);
        if (taxa == null) {
            throw new IllegalArgumentException("Moeda não encontrada: " + moedaConvertida);
        }
        return taxa;
    }

}