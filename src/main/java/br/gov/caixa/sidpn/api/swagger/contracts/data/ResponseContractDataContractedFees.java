package br.gov.caixa.sidpn.api.swagger.contracts.data;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.caixa.sidpn.api.swagger.enums.EnumContractFeeCharge;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractFeeChargeType;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale;
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
 * ResponseUnarrangedAccountOverdraftContractDataContractedFees
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseContractDataContractedFees
{

   @Schema(example = "Excesso em Conta", required = true, description = "Denominação da Tarifa pactuada")
   @NotNull
   @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
   @Size(max = 140)
   @JsonProperty("feeName")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private String feeName = "NA";

   @Schema(example = "EXCESSO_CONTA", required = true, description = "Sigla identificadora da tarifa pactuada")
   @NotNull
   @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
   @Size(max = 140)
   @JsonProperty("feeCode")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private String feeCode = "NA";

   @Schema(example = "UNICA", required = true, description = "Tipo de cobrança para a tarifa pactuada no contrato.")
   @NotNull
   @JsonProperty("feeChargeType")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractFeeChargeType feeChargeType = EnumContractFeeChargeType.UNICA;

   @Schema(example = "MINIMO", required = true, description = "\"Forma de cobrança relativa a tarifa pactuada no contrato. (Vide Enum) - Mínimo - Máximo - Fixo - Percentual\" ")
   @NotNull
   @JsonProperty("feeCharge")
   @JsonSetter(nulls = Nulls.SKIP)
   @Default
   private EnumContractFeeCharge feeCharge = EnumContractFeeCharge.FIXO;

   @Schema(example = "100000.04", required = true,
            description = "\"Valor monetário da tarifa pactuada no contrato. Preenchimento obrigatório quando a forma de cobrança for: Mínimo, Máximo ou Fixo\" ")
   //@Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
   @JsonProperty("feeAmount")
   @JsonInclude(JsonInclude.Include.ALWAYS)
   @JsonDeserialize(using = ValueDeserializeScale.class)
   private BigDecimal feeAmount;

   @Schema(example = "50", required = true,
            description = "É o valor da tarifa em percentual pactuada no contrato. Deve-se informar 4 casas decimais, mesmo que preenchidas com zeros. Exemplo: 0.2000")
   @JsonProperty("feeRate")
   @JsonInclude(JsonInclude.Include.ALWAYS)
   @JsonDeserialize(using = ValueDeserializeScale4.class)
   private BigDecimal feeRate;

}
