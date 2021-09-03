package br.gov.caixa.sidpn.api.swagger.contracts.warranties;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.caixa.sidpn.api.swagger.Links;
import br.gov.caixa.sidpn.api.swagger.Meta;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ResponseWarranties   {
  @Schema(required = true, description = "Conjunto de informações referentes às garantias que avalizam a operação de crédito de adiantamento a depositantes")
  @JsonProperty("data")
  @NotNull
  @Default
  private List<WarrantiesData> data
    = List.of(WarrantiesData.builder().build());
  
  @Schema(required = true, description = "")
  @JsonProperty("links")
  @NotNull
  private Links links;

  @Schema(required = true, description = "")
  @JsonProperty("meta")
  @NotNull
  private Meta meta;
}