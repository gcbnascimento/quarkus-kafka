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
public class PaymentsDataOverParcelFee {
  @Schema(example = "reavaliação periódica do bem", required = true, description = "Denominação da Tarifa avulsa paga fora da parcela")
  @JsonProperty("feeName")
  @NotNull
  @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
  @Size(max=250)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String feeName = "NA";

  @Schema(example = "aval_bem", required = true, description = "Sigla identificadora da tarifa avulsa fora da parcela")
  @JsonProperty("feeCode")
  @NotNull
  @Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
  @Size(max=140)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String feeCode = "NA";

  @Schema(example = "100000.04", required = true, description = "Valor do pagamento do encargo pago fora da parcela. Expresso em valor monetário com até 4 casas decimais.")
  @JsonProperty("feeAmount")
  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonDeserialize(using = ValueDeserializeScale.class)
  private BigDecimal feeAmount;
}