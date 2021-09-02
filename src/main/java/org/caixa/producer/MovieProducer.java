package org.caixa.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.caixa.domain.Movie;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class MovieProducer {

    @Inject @Channel("movie-out")
    Emitter<Movie> emitter;

    public void sendMovieToKafka(Movie movie) {
        emitter.send(movie);
    }
}