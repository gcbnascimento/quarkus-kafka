package br.gov.caixa.sidpn.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import br.gov.caixa.sidpn.api.dto.impl.ContractDTO;

@ApplicationScoped
public class MovieProducer {

    @Inject @Channel("movie-out")
    Emitter<ContractDTO> emitter;

    public void sendMovieToKafka(ContractDTO dto) {
        emitter.send(dto);
    }
}