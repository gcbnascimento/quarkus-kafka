package br.gov.caixa.sidpn.api.swagger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@Schema(description = "Referências para outros recusos da API requisitada.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-03-16T09:23:23.706207-03:00[America/Recife]")
public class Links {
	@Schema(example = "https://api.banco.com.br/open-banking/<api>/v1/<resource>", required = true, description = "URI completo que gerou a resposta atual.")
	@JsonProperty("self")
	@NotNull
	@Size(max = 2048)
	private String self;
	@Schema(example = "https://api.banco.com.br/open-banking/<api>/v1/<resource>", description = "URI da primeira página que originou essa lista de resultados. Restrição - Obrigatório quando não for a primeira página da resposta")
	@JsonProperty("first")
	@Size(max = 2048)
	private String first;
	@Schema(description = "URI da página anterior dessa lista de resultados. Restrição -  Obrigatório quando não for a primeira página da resposta")
	@JsonProperty("prev")
	@Size(max = 2048)
	private String prev;
	@Schema(description = "URI da próxima página dessa lista de resultados. Restrição - Obrigatório quando não for a última página da resposta")
	@JsonProperty("next")
	@Size(max = 2048)
	private String next;
	@Schema(example = "https://api.banco.com.br/open-banking/<api>/v1/<resource>", description = "URI da última página dessa lista de resultados. Restrição - Obrigatório quando não for a última página da resposta")
	@JsonProperty("last")
	@Size(max = 2048)
	private String last;

}
