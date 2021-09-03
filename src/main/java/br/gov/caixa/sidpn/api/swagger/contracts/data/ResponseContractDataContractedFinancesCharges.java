package br.gov.caixa.sidpn.api.swagger.contracts.data;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.caixa.sidpn.api.swagger.enums.EnumChargeType;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale4;
import br.gov.caixa.sidpn.resource.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ResponseUnarrangedAccountOverdraftContractDataContractedFinancesCharges
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseContractDataContractedFinancesCharges
{

   @Schema(example = "JUROS_REMUNERATORIOS_POR_ATRASO", required = true, description = "Tipo de encargo pactuado no contrato.")
   @NotNull
   @JsonProperty("chargeType")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumChargeType chargeType = EnumChargeType.SEM_ENCARGO;

   @Schema(description = "Campo de preenchimento obrigatório se selecionada a opção 'OUTROS' em Tipo de encargo pactuado no contrato")
   @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
   @JsonProperty("chargeAdditionalInfo")
   private String chargeAdditionalInfo;

   public String getChargeAdditionalInfo() {
      if ((chargeAdditionalInfo == null || chargeAdditionalInfo.isEmpty()) &&
              (getChargeType().isOthers())) {
         chargeAdditionalInfo = "NA";
      }
      return chargeAdditionalInfo;
   }

   @Schema(example = "0.07", description = "Representa o valor do encargo em percentual pactuado no contrato. Exemplo: 0.0210 (=2.1%). Deve-se preencher as 4 casas decimais obrigatoriamente. ")
   @JsonProperty("chargeRate")
   @JsonDeserialize(using = ValueDeserializeScale4.class)
   private BigDecimal chargeRate;
   
}
