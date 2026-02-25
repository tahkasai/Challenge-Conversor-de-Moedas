package Model;

import java.util.Map;

public record RecordMoeda(
        String base_code,
        Map<String, Double> conversion_rates
) {}
