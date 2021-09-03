package br.gov.caixa.sidpn.api.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ValueDeserializeScale extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
    	if(p.currentToken().isNumeric()) {
    		BigDecimal value = p.getDecimalValue();
	        return value.setScale(getScale(value), RoundingMode.HALF_EVEN);
        }else {
        	return BigDecimal.ZERO;
        }
    	
    }
    private int getScale(BigDecimal value) {    	
        if (value.scale() < 2)
            return 2;
        else if (value.scale() > 4)
            return 4;
        else
            return value.scale();
    }
}