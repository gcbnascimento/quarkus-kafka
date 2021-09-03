package br.gov.caixa.sidpn.api.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ValueDeserializeScale4 extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
    	if(p.currentToken().isNumeric()) {
    		BigDecimal value = p.getDecimalValue();
	        return value.setScale(4, RoundingMode.HALF_EVEN);
        }else {
        	return BigDecimal.ZERO;
        }
    	
    }
}
