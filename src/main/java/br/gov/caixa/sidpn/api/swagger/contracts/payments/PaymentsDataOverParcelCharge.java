package br.gov.caixa.sidpn.api.swagger.contracts.payments;

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

import br.gov.caixa.sidpn.api.swagger.enums.EnumChargeType;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale;
import br.gov.caixa.sidpn.resource.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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
public class PaymentsDataOverParcelCharge {
  @Schema(example = "JUROS_REMUNERATORIOS_POR_ATRASO", required = true, description = "Tipo de encargo pago fora da parcela")
  @JsonProperty("chargeType")
  @NotNull
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private EnumChargeType chargeType = EnumChargeType.SEM_ENCARGO;
  
  @Schema(example = "Informações Adicionais", required = true, description = "Campo de preenchimento obrigatório se selecionada a opção 'OUTROS' em Tipo de encargo pago fora da parcela")
  @JsonProperty("chargeAdditionalInfo")
  @NotNull
  @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
  @Size(max=140)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String chargeAdditionalInfo = "NA";

  @Schema(example = "100000.04", description = "Valor do pagamento do encargo pago fora da parcela. Expresso em valor monetário com até 4 casas decimais.")
  @JsonProperty("chargeAmount")
  //@Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonDeserialize(using = ValueDeserializeScale.class)
  private BigDecimal chargeAmount;
}
