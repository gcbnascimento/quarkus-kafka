package br.gov.caixa.sidpn.api.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class JsonUtil {
    @Inject ObjectMapper mapper;

    public <T> Optional<T> toObject(JsonObject json, Class<T> deserializador) {
        return toObject(json.toString(), deserializador);
    }
    
    public <T> Optional<T> toObject(String json, Class<T> deserializador) {
        try {
            return Optional.ofNullable(mapper.readValue(json, deserializador));
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
    
  
    
    public Optional<JsonNode> parseJsonNode(byte[] content) {
        Objects.requireNonNull(content, "Deve ser informado conteudo para realizar a desserialização.");
        try {
            return Optional.ofNullable(mapper.readTree(content));
        }
        catch (IOException e) {
            return Optional.empty();
        }
    }
    
    public JsonNode parseJsonNodeOrDefault(byte[] content) {
        JsonNode json = null;
        try {
            json = parseJsonNode(content).filter(node -> !node.isMissingNode()).orElse(mapper.readTree("{}"));
        }
        catch (JsonProcessingException e) {
        	log.error(e.getMessage(), e);
        }
        return json;
    }
}
