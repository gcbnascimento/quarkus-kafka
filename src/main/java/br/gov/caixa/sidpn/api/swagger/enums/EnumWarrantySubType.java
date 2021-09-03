
package br.gov.caixa.sidpn.api.swagger.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumWarrantySubType
{

        ACOES_DEBENTURES("ACOES_DEBENTURES"),
        APLICACOES_FINANCEIRAS_RENDA_FIXA("APLICACOES_FINANCEIRAS_RENDA_FIXA"),
        APLICACOES_FINANCEIRAS_RENDA_VARIAVEL("APLICACOES_FINANCEIRAS_RENDA_VARIAVEL"),
        APOLICES_CREDITO_EXPORTACAO("APOLICES_CREDITO_EXPORTACAO"),
        CCR_CONVENIO_CREDITOS_RECIPROCOS("CCR_CONVENIO _CREDITOS_RECIPROCOS"),
        CHEQUES("CHEQUES"),
        CIVIL("CIVIL"),
        DIREITOS_SOBRE_ALUGUEIS("DIREITOS_SOBRE_ALUGUEIS"),
        DEPOSITOS_A_VISTA_A_PRAZO_POUPANCA_OURO_TITULOS_PUBLICOS_FEDERAIS_ART_36("DEPOSITOS_A_VISTA_A_PRAZO_POUPANCA_OURO_TITULOS_PUBLICOS_FEDERAIS_ART_36"),
        DEPOSITO_TITULOS_EMITIDOS_ENTIDADES_ART_23("DEPOSITO_TITULOS_EMITIDOS_ENTIDADES_ART_23"),
        DUPLICATAS("DUPLICATAS"),
        EMD_ENTIDADES_MULTILATERAIS_DESENVOLVIMENTO_ART_37("EMD_ENTIDADES_MULTILATERAIS_DESENVOLVIMENTO_ART_37"),
        EQUIPAMENTOS_FATURA_CARTAO_CREDITO("EQUIPAMENTOS FATURA_CARTAO_CREDITO"),
        ESTADUAL_OU_DISTRITAL("ESTADUAL_OU_DISTRITAL"),
        FATURA_CARTAO_CREDITO("FATURA_CARTAO_CREDITO"),
        FEDERAL("FEDERAL"),
        FCVS_FUNDO_COMPENSACAO_VARIACOES_SALARIAIS("FCVS_FUNDO_COMPENSACAO_VARIACOES_SALARIAIS"),
        FGI_FUNDO_GARANTIDOR_INVESTIMENTOS("FGI_FUNDO_GARANTIDOR_INVESTIMENTOS"),
        FGPC_FUNDO_GARANTIA_PROMOCAO_COMPETIT("FGPC_FUNDO_GARANTIA_PROMOCAO_COMPETIT"),
        FGTS_FUNDO_GARANTIA_TEMPO_SERVICO("FGTS_FUNDO_GARANTIA_TEMPO_SERVICO"),
        FUNDO_GARANTIDOR_AVAL("FUNDO_GARANTIDOR_AVAL"),
        GARANTIA_PRESTADA_FGPC_LEI_9531_ART_37("GARANTIA_PRESTADA_FGPC_LEI_9531_ART_37"),
        GARANTIA_PRESTADA_FUNDOS_QUAISQUER_OUTROS_MECANISMOS_COBERTURA_RISCO_CREDITO_ART_37("GARANTIA_PRESTADA_FUNDOS_QUAISQUER_OUTROS_MECANISMOS_COBERTURA_RISCO_CREDITO_ART_37"),
        GARANTIA_PRESTADA_TESOURO_NACIONAL_OU_BACEN_ART_37_BENS_DIREITOS_INTEGRANTES_PATRIMONIO_AFETACAO("GARANTIA_PRESTADA_TESOURO_NACIONAL_OU_BACEN_ART_37_BENS_DIREITOS_INTEGRANTES_PATRIMONIO_AFETACAO"),
        IMOVEIS("IMOVEIS"),
        IMOVEIS_RESIDENCIAIS("IMOVEIS_RESIDENCIAIS"),
        MITIGADORAS("MITIGADORAS"),
        MUNICIPAL("MUNICIPAL"),
        NAO_MITIGADORAS("NAO_MITIGADORAS"),
        NOTAS_PROMISSORIAS_OUTROS_DIREITOS_CREDITO("NOTAS_PROMISSORIAS_OUTROS_DIREITOS_CREDITO"),
        OUTRAS("OUTRAS"),
        OUTROS("OUTROS"),
        OUTROS_BENS("OUTROS_BENS"),
        OUTROS_GRAUS("OUTROS_GRAUS"),
        OUTROS_IMOVEIS("OUTROS_IMOVEIS"),
        OUTROS_SEGUROS_ASSEMELHADOS_OUTROS_BENS("OUTROS_SEGUROS_ASSEMELHADOS OUTROS_BENS"),
        PESSOA_FISICA("PESSOA_FISICA"),
        PESSOA_FISICA_EXTERIOR("PESSOA_FISICA_EXTERIOR"),
        PESSOA_JURIDICA("PESSOA_JURIDICA"),
        PESSOA_JURIDICA_EXTERIOR("PESSOA_JURIDICA_EXTERIOR"),
        PRIMEIRO_GRAU_BENS_DIREITOS_INTEGRANTES_PATRIMONIO_AFETACAO("PRIMEIRO_GRAU_BENS_DIREITOS_INTEGRANTES_PATRIMONIO_AFETACAO"),
        PRIMEIRO_GRAU_IMOVEIS_RESIDENCIAIS("PRIMEIRO_GRAU_IMOVEIS_RESIDENCIAIS"),
        PRIMEIRO_GRAU_OUTROS("PRIMEIRO_GRAU_OUTROS"),
        PRODUTOS_AGROPECUARIOS_COM_WARRANT("PRODUTOS_AGROPECUARIOS_COM_WARRANT"),
        PRODUTOS_AGROPECUARIOS_SEM_WARRANT("PRODUTOS_AGROPECUARIOS_SEM_WARRANT"),
        SBCE_SOCIEDADE_BRASILEIRA_CREDITO_EXPORTA_O("SBCE_SOCIEDADE_BRASILEIRA_CREDITO_EXPORTAÇÃO"),
        SEGURO_RURAL("SEGURO_RURAL"),
        TRIBUTOS_RECEITAS_ORCAMENTARIAS("TRIBUTOS_RECEITAS_ORCAMENTARIAS"),
        VEICULOS("VEICULOS"),
        VEICULOS_AUTOMOTORES("VEICULOS_AUTOMOTORES");

    private String value;

    @Override
    @JsonValue
    public String toString()
    {
        return value;
    }

    @JsonCreator
    public static EnumWarrantySubType fromValue(String text)
    {
        for (EnumWarrantySubType b : EnumWarrantySubType.values())
        {
            if (b.value.equals(text))
            {
                return b;
            }
        }
        return null;
    }
}