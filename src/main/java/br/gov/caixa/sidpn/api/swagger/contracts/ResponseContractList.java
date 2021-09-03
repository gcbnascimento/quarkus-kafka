package br.gov.caixa.sidpn.api.swagger.contracts;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.gov.caixa.sidpn.api.swagger.Links;
import br.gov.caixa.sidpn.api.swagger.Meta;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class ResponseContractList {

    @Schema(required = true, description = "Conjunto de informações de contratos de adiantamento a depositantes mantidos pelo cliente na instituição transmissora e para os quais ele tenha fornecido consentimento")
    @JsonProperty("data")
    @NotNull
    @Size(min = 1)
    private List<ResponseContractListData> data;

    @Schema(required = true, description = "Referências para outros recursos da API requisitada")
    @JsonProperty("links")
    @NotNull
    private Links links;

    @Schema(required = true, description = "Meta informações referente a API requisitada")
    @JsonProperty("meta")
    @NotNull
    private Meta meta;

}
