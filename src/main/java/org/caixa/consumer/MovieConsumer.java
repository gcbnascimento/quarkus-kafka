package org.caixa.consumer;

import javax.enterprise.context.ApplicationScoped;

import org.caixa.domain.Movie;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class MovieConsumer {

    private final Logger logger = Logger.getLogger(MovieConsumer.class);

    @Incoming("movie-in")
    public void receive(Movie movie) {
        System.out.println("Got a movie: "+movie.getTitle()+" - "+ movie.getYear());
    }
}
