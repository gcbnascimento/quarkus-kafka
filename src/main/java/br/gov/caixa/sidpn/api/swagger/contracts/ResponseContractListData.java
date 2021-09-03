package br.gov.caixa.sidpn.api.swagger.contracts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.caixa.sidpn.api.common.CommonProperties;
import br.gov.caixa.sidpn.api.swagger.ResponseCreditListData;
import br.gov.caixa.sidpn.api.swagger.enums.EnumUnarrangedAccountOverdraftProductType;
import br.gov.caixa.sidpn.api.swagger.enums.EnumUnarrangedAccountOverdraftSubProductType;
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
public class ResponseContractListData implements ResponseCreditListData {

    @Schema(example = "xcjklompowsa279212650822221989319aadrtjk", required = true, description = "Um identificador único e imutável usado para identificar o contrato de uma operação de crédito. Este identificador não tem significado para o tomador do crédito")
	@JsonProperty("contractId")
	@NotNull
	@Size(max = 100)
	private String contractId;

	@Schema(example = "Organização A", required = true, description = "Nome da Marca reportada pelo participante do Open Banking. O conceito a que se refere a 'marca' é em essência uma promessa da empresa em fornecer uma série específica de atributos, benefícios e serviços uniformes aos clientes")
	@JsonProperty("brandName")
	@Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
	@Size(max = 80)
    @NotNull
    @Default
	private String brandName = CommonProperties.BRAND_NAME.getValue();

	@Schema(example = "60500998000144", required = true, description = "Número completo do CNPJ da instituição responsável pelo Cadastro - o CNPJ corresponde ao número de inscrição no Cadastro de Pessoa Jurídica. Deve-se ter apenas os números do CNPJ, sem máscara")
	@JsonProperty("companyCnpj")
	@Pattern(regexp = "\\d{14}|^NA$")
	@Size(max = 14)
    @NotNull
    @Default
	private String companyCnpj = CommonProperties.COMPANY_CNPJ.getValue();

	@Schema(example = "ADIANTAMENTO_A_DEPOSITANTES", required = true, description = "")
	@JsonProperty("productType")
	@NotNull
	@Size(max = 27)
	private EnumUnarrangedAccountOverdraftProductType productType;

	@Schema(example = "ADIANTAMENTO_A_DEPOSITANTES", required = true, description = "")
	@JsonProperty("productSubType")
	@NotNull
	@Size(max = 27)
	private EnumUnarrangedAccountOverdraftSubProductType productSubType;

	@Schema(example = "92792126019929279212650822221989319252576", description = "Número padronizado do contrato - IPOC (Identificação Padronizada da Operação de Crédito).")
	@JsonProperty("ipocCode")
	@Pattern(regexp = "\\w\\W\\s]*")
	@Size(max = 67)
	private String ipocCode;

}
