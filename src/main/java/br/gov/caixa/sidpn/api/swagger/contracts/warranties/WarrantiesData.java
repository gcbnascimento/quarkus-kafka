package br.gov.caixa.sidpn.api.swagger.contracts.warranties;

import java.math.BigDecimal;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import br.gov.caixa.sidpn.api.swagger.enums.EnumWarrantySubType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumWarrantyType;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description="Conjunto de informações referentes às garantias que avalizam a operação de crédito contratada")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WarrantiesData {
  @Schema(example = "BRL", required = true, description = "Moeda referente ao valor da garantia, segundo modelo ISO-4217. p.ex. 'BRL'. Todos os valores monetários informados estão representados com a moeda vigente do Brasil")
  @JsonProperty("currency")
  @Pattern(regexp="^(\\w{3}){1}$")
  @Size(max=3)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private String currency = "BRL";

  @Schema(example = "CESSAO_DIREITOS_CREDITORIOS", required = true, description = "Denominação/Identificação do tipo da garantia que avaliza a Modalidade da Operação de Crédito contratada  (Doc 3040, Anexo 12)")
  @JsonProperty("warrantyType")
  @Size(max=40)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private EnumWarrantyType warrantyType = EnumWarrantyType.SEM_TIPO_GARANTIA;

  @Schema(example = "NOTAS_PROMISSORIAS_OUTROS_DIREITOS_CREDITO", required = true, description = "Denominação/Identificação do sub tipo da garantia que avaliza a Modalidade da Operação de Crédito contratada (Doc 3040, Anexo 12)")
  @JsonProperty("warrantySubType")
  @Size(max=100)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private EnumWarrantySubType warrantySubType = EnumWarrantySubType.OUTROS;

  @Schema(example = "100000.04", description = "Valor original da garantia. Valor monetário, expresso com até 4 casas decimais.")
  @JsonProperty("warrantyAmount")
  @JsonDeserialize(using = ValueDeserializeScale.class)
  @Pattern(regexp = "^-?\\d{1,15}\\.\\d{2,4}$")
  @Size(max=20)
  @JsonSetter(nulls = Nulls.SKIP)
  @Default
  private BigDecimal warrantyAmount = new BigDecimal("0.00");
}