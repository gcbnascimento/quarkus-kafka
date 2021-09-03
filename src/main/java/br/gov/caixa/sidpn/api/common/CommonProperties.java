package br.gov.caixa.sidpn.api.common;

import static org.apache.commons.lang3.math.NumberUtils.toInt;
import static org.eclipse.microprofile.config.ConfigProvider.getConfig;

import org.eclipse.microprofile.config.ConfigProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonProperties
{

      BRAND_NAME(getConfig().getValue("caixa.brandName", String.class)),
      COMPANY_CNPJ(getConfig().getValue("caixa.companyCnpj", String.class)),
      COMPE_CODE(getConfig().getValue("caixa.compeCode", String.class)),
      CURRENCY(getConfig().getValue("caixa.currency", String.class)),
      URL_TOKEN_SERVICO(getConfig().getValue("sso.url", String.class)),
      KEY_SERVICO(getConfig().getValue("sso.client_secret", String.class)),
      CLIENT_ID(getConfig().getValue("sso.client_id", String.class)),
      GRANT_TYPE(getConfig().getValue("sso.grant", String.class)),
      REDIS_EXPIRE_TIME(getConfig().getValue("redis.expire.time.segundos", String.class)),
      NUMBER_MONTHS_CONSIDERED_QUERY_COSMOS(getConfig().getValue("default.number.months.considered.query.cosmos", String.class)),
      DEFAULT_PAGE(ConfigProvider.getConfig().getValue("default.page", String.class))
      {

         @Override
         public Integer getValueInt()
         {
            return toInt(getValue());
         }
      },
      DEFAULT_PAGE_SIZE(ConfigProvider.getConfig().getValue("default.pageSize", String.class))
      {

         @Override
         public Integer getValueInt()
         {
            return toInt(getValue());
         }
      },

   ;

   private String value;

   public Integer getValueInt()
   {
      return null;
   }
}
