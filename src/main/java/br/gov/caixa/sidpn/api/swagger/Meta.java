package br.gov.caixa.sidpn.api.swagger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@Schema(description = "Meta informações referente a API requisitada.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-03-16T09:23:23.706207-03:00[America/Recife]")
public class Meta {
	@Schema(example = "1", required = true, description = "Número total de registros no resultado")
	@JsonProperty("totalRecords")
	@NotNull
	private Integer totalRecords;

	@Schema(example = "1", required = true, description = "Número total de páginas no resultado")
	@JsonProperty("totalPages")
	@NotNull
	private Integer totalPages;

	@Schema(example = "2020-07-21T08:30:00Z", required = true,
            description = "Data e hora da consulta, conforme especificação RFC-3339, formato UTC.")
	@JsonProperty("requestDateTime")
	@NotNull
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])T(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)Z$")
	@Size(max = 20)
	private String requestDateTime;

}
