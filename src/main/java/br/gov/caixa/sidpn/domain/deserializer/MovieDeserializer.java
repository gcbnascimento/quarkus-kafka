package br.gov.caixa.sidpn.domain.deserializer;

import br.gov.caixa.sidpn.api.dto.impl.ContractDTO;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class MovieDeserializer extends ObjectMapperDeserializer<ContractDTO> {
    public MovieDeserializer() {
        super(ContractDTO.class);
    }
}
