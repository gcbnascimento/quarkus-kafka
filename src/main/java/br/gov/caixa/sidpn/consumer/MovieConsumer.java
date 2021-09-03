package br.gov.caixa.sidpn.consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.caixa.sidpn.api.dto.impl.ContractDTO;

@ApplicationScoped
public class MovieConsumer {


	   @Inject
	   ObjectMapper mapper;

    @Incoming("movie-in")
    public void receive(ContractDTO dto) throws JsonProcessingException {
    	//var dtoFormatter = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
    	System.out.println("=================================================");
    	System.out.println("=================================================");
    	System.out.println("=================================================");
        System.out.println("Consumiu a seguinte mensagem: : "+dto);
        System.out.println("=================================================");
        System.out.println("=================================================");
        System.out.println("=================================================");
    }
}
