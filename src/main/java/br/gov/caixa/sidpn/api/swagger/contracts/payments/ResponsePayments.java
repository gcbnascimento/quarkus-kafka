package br.gov.caixa.sidpn.api.swagger.contracts.payments;

import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.gov.caixa.sidpn.api.swagger.Links;
import br.gov.caixa.sidpn.api.swagger.Meta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePayments   {
  @Schema(required = true, description = "")
  @JsonProperty("data")
  @NotNull
  private PaymentsData data;
  
  @Schema(required = true, description = "")
  @JsonProperty("links")
  @NotNull
  private Links links;

  @Schema(required = true, description = "")
  @JsonProperty("meta")
  @NotNull
  private Meta meta;
}