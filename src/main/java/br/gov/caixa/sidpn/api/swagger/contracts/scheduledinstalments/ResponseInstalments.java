package br.gov.caixa.sidpn.api.swagger.contracts.scheduledinstalments;

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
public class ResponseInstalments {
  @Schema(required = true, description = "")
  @JsonProperty("data")
  @NotNull
  @Default
  private InstalmentsData data = InstalmentsData.builder().build();

  @Schema(required = true, description = "")
  @JsonProperty("links")
  @NotNull
  private Links links;

  @Schema(required = true, description = "")
  @JsonProperty("meta")
  @NotNull
  private Meta meta;
}