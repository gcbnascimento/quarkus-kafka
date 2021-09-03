package br.gov.caixa.sidpn.api.swagger.contracts.data;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.caixa.sidpn.api.swagger.ResponseData;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractAmortizationScheduled;
import br.gov.caixa.sidpn.api.swagger.enums.EnumContractInstalmentPeriodicity;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale;
import br.gov.caixa.sidpn.api.util.ValueDeserializeScale4;
import br.gov.caixa.sidpn.resource.DefaultValueConstants;
import br.gov.caixa.sidpn.resource.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Conjunto de informações referentes à identificação da operação de crédito de
 * adiantamento a depositantes
 */
@Schema(description = "Conjunto de informações referentes à identificação da operação de crédito de adiantamento a depositantes")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseContractData implements ResponseData {

	@Schema(example = "1324926521496", required = true, description = "Número do contrato dado pela instituição contratante.")
	@JsonProperty("contractNumber")
	@JsonAlias("contractId")
	@NotNull
	@Size(max = 100)
	private String contractNumber;

	@Schema(example = "92792126019929279212650822221989319252576", required = true, description = "\"Número padronizado do contrato - IPOC (Identificação Padronizada da Operação de Crédito). Segundo DOC 3040, composta por: - **CNPJ da instituição:** 8 (oito) posições iniciais; - **Modalidade da operação:** 4 (quatro) posições; - **Tipo do cliente:** 1 (uma) posição( 1 = pessoa natural - CPF, 2= pessoa jurídica – CNPJ, 3 = pessoa física no exterior, 4 = pessoa jurídica no exterior, 5 = pessoa natural sem CPF e 6 = pessoa jurídica sem CNPJ); - **Código do cliente:** O número de posições varia conforme o tipo do cliente:   1. Para clientes pessoa física com CPF (tipo de cliente = 1), informar as 11 (onze) posições do CPF;   2. Para clientes pessoa jurídica com CNPJ (tipo de cliente = 2), informar as 8 (oito) posições iniciais do CNPJ;   3. Para os demais clientes (tipos de cliente 3, 4, 5 e 6), informar 14 (catorze) posições com complemento de zeros à esquerda se a identificação tiver tamanho inferior; - **Código do contrato:** 1 (uma) até 40 (quarenta) posições, sem complemento de caracteres.\" ")
	@NotNull
	@Size(max = 67)
	@JsonProperty("ipocCode")
	private String ipocCode;

	@Schema(example = "AD", required = true, description = "\"Denominação/Identificação do nome da Modalidade da Operação de Crédito divulgado ao cliente\" ")
	@NotNull
	@Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
	@Size(max = 140)
	@JsonProperty("productName")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String productName = "NA";

	@Schema(required = true, description = "")
	@NotNull
	@JsonProperty("productType")
	private ProductType productType;

	@Schema(required = true, description = "")
	@NotNull
	@JsonProperty("productSubType")
	private ProductSubType productSubType;

	@Schema(example = "2021-05-21T08:30Z", required = true, description = "Data de contratação da operação de crédito. Especificação RFC-3339")
	@NotNull
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
	@JsonProperty("contractDate")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String contractDate = DefaultValueConstants.DATE_DEFAULT;

	@Schema(example = "2021-05-21T08:30Z", description = "Data do Desembolso do valor contratado. Especificação RFC-3339")
	@JsonProperty("disbursementDate")
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
	private String disbursementDate;

	@Schema(example = "2021-05-21T08:30Z", required = true, description = "Data de liquidação da operação. [Restrição] Deve aceitar NA caso não seja retornado pela instituição. ")
	@JsonProperty("settlementDate")
	@NotNull
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$|^NA$")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String settlementDate = "NA";

	@Schema(example = "100000.04", required = true, description = "Valor contratado da operação. Expresso em valor monetário com até 4 casas decimais")
	@JsonProperty("contractAmount")
	// @Pattern(regexp="^-?\\d{1,15}\\.\\d{2,4}$")
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonDeserialize(using = ValueDeserializeScale.class)
	private BigDecimal contractAmount;

	@Schema(example = "BRL", required = true, description = "Moeda referente ao valor da garantia, segundo modelo ISO-4217. p.ex. 'BRL' Todos os valores monetários informados estão representados com a moeda vigente do Brasil")
	@NotNull
	@Pattern(regexp = "^(\\w{3}){1}$")
	@Size(max = 3)
	@JsonProperty("currency")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String currency = "BRL";

	@Schema(example = "2021-05-21T08:30Z", required = true, description = "Data de vencimento Final da operação. Especificação RFC-3339")
	@NotNull
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
	@JsonProperty("dueDate")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String dueDate = DefaultValueConstants.DATE_DEFAULT;

	@Schema(example = "SEMANAL", required = true, description = "\"Informação relativa à periodicidade regular das parcelas. (Vide Enum) sem periodicidade regular, semanal, quinzenal, mensal, bimestral, trimestral, semestral, anual\" ")
	@NotNull
	@JsonProperty("instalmentPeriodicity")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private EnumContractInstalmentPeriodicity instalmentPeriodicity = EnumContractInstalmentPeriodicity.SEM_PERIODICIDADE_REGULAR;

	@Schema(example = "Informações adicionais sobre periodicidade", required = true, description = "Campo obrigatório para complementar a informação relativa à periodicidade de pagamento regular quando tiver a opção OUTROS. [Restrição] Obrigatório para complementar a informação relativa da periodicidade de pagamento regular, quando selecionada o tipo ou subtipo OUTRO.  ")
	@JsonProperty("instalmentPeriodicityAdditionalInfo")
	@NotNull
	@Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
	@Size(max = 50)
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String instalmentPeriodicityAdditionalInfo = "NA";

	@Schema(example = "2021-05-21T08:30Z", required = true, description = "Data de vencimento primeira parcela do principal")
	@NotNull
	@Pattern(regexp = "^(\\d{4})-(1[0-2]|0?[1-9])-(3[01]|[12][0-9]|0?[1-9])$")
	@JsonProperty("firstInstalmentDueDate")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String firstInstalmentDueDate = DefaultValueConstants.DATE_DEFAULT;

	@Schema(example = "0.29", required = true, description = "CET – Custo Efetivo Total deve ser expresso na forma de taxa percentual anual e   incorpora todos os encargos e despesas incidentes nas operações de crédito (taxa de juro, mas também tarifas, tributos, seguros e outras despesas cobradas). O preenchimento deve respeitar as 4 casas decimais, mesmo que venham preenchidas com zeros (representação de porcentagem p.ex: 0.1500. Este valor representa 15%. O valor 1 representa 100%)")
	@JsonProperty("CET")
	@JsonDeserialize(using = ValueDeserializeScale4.class)
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private BigDecimal cet = new BigDecimal("0.0000");

	@Schema(example = "SAC", required = true, description = "\"Sistema de amortização (Vide Enum) - SAC (Sistema de Amortização Constante -   é aquele em que o valor da amortização permanece igual até o final. Os juros  cobrados sobre o parcelamento não entram nesta conta) - PRICE (Sistema Francês de Amortização - As parcelas são fixas do início ao fim do contrato. Ou seja, todas as parcelas terão o mesmo valor, desde a primeira até a última. Nos primeiros pagamentos, a maior parte do valor da prestação corresponde aos juros. Ao longo do tempo, a taxa de juros vai decrescendo. Como o valor da prestação é fixo, com o passar das parcelas, o valor de amortização vai aumentando) - SAM (Sociedade de arrendamento mercantil) - realiza arrendamento de bens móveis e imóveis adquiridos por ela, segundo as especificações da arrendatária (cliente), para fins de uso próprio desta. Assim, os contratantes deste serviço podem usufruir de determinado bem sem serem proprietários dele. As operações de arrendamento mercantil podem ser divididas em duas modalidades: leasing financeiro e leasing operacional. A diferença básica é que no leasing financeiro o prazo é usualmente maior e o arrendatário tem a possibilidade de adquirir o bem por um valor pré-estabelecido. Ao final do contrato, o arrendatário tem as opções de efetivar a aquisição do bem arrendado ou devolvê-lo. Ao final do leasing financeiro, em geral o cliente já terá pago a maior parte do valor do bem, não sendo a devolução, embora possível, financeiramente vantajosa) - SEM SISTEMA DE AMORTIZAÇÃO\" ")
	@NotNull
	@JsonProperty("amortizationScheduled")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private EnumContractAmortizationScheduled amortizationScheduled = EnumContractAmortizationScheduled.SEM_SISTEMA_AMORTIZACAO;

	@Schema(example = "NA", required = true, description = "Campo obrigatório para complementar a informação relativa à amortização quando selecionada a opção OUTROS. [Restrição] Obrigatório para complementar a informação relativa à amortização quando selecionada a opção OUTROS, para os demais casos informar \"NA\".      ")
	@JsonProperty("amortizationScheduledAdditionalInfo")
	@NotNull
	@Pattern(regexp = RegexConstants.REGEX_ONLY_STRINGS)
	@Size(max = 50)
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private String amortizationScheduledAdditionalInfo = "NA";

	@Schema(required = true, description = "")
	@Valid
	@JsonProperty("interestRates")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private List<ResponseContractDataInterestRates> interestRates = List
			.of(ResponseContractDataInterestRates.builder().build());

	@Schema(required = true, description = "Lista que traz a relação de tarifas pactuadas no contrato")
	@Valid
	@Size(min = 1)
	@JsonProperty("contractedFees")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private List<ResponseContractDataContractedFees> contractedFees = List
			.of(ResponseContractDataContractedFees.builder().build());

	@Schema(required = true, description = "Lista que traz os encargos pactuados no contrato")
	@Valid
	@Size(min = 1)
	@JsonProperty("contractedFinanceCharges")
	@JsonSetter(nulls = Nulls.SKIP)
	@Default
	private List<ResponseContractDataContractedFinancesCharges> contractedFinanceCharges = List
			.of(ResponseContractDataContractedFinancesCharges.builder().build());

	@Override
	public String getProductSubTypeString() {
		return getProductSubType().name();
	}

}
