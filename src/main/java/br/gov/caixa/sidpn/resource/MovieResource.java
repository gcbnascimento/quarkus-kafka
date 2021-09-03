package br.gov.caixa.sidpn.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gov.caixa.sidpn.api.dto.impl.ContractDTO;
import br.gov.caixa.sidpn.producer.MovieProducer;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @Inject
    MovieProducer producer;

    @POST
    public Response send(ContractDTO dto) {
        producer.sendMovieToKafka(dto);
        // Return an 202 - Accepted response.
        System.out.println("Mensagem enviada: " + dto.toString());
        return Response.accepted().build();
    }
}	
