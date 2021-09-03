package br.gov.caixa.sidpn.api.swagger.contracts.data;

import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.gov.caixa.sidpn.api.swagger.Links;
import br.gov.caixa.sidpn.api.swagger.Meta;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ResponseUnarrangedAccountOverdraftContract
 */
@Builder
@Getter
@Setter
@ToString
public class ResponseContract
{

   @Schema(required = true, description = "")
   @NotNull
   @JsonProperty("data")
   private ResponseContractData data;

   @Schema(required = true, description = "")
   @NotNull
   @JsonProperty("links")
   private Links links;

   @Schema(required = true, description = "")
   @NotNull
   @JsonProperty("meta")
   private Meta meta;
   
}
