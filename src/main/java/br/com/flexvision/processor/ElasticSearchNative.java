package br.com.flexvision.processor;

import java.util.Random;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchNative implements Processor {
	private static final transient Logger LOG = LoggerFactory.getLogger(ElasticSearchNative.class);

	public void process(Exchange exchange) throws Exception {
		String json = (String) exchange.getIn().getBody();
		LOG.debug(json);
		StringBuilder inserts = new StringBuilder("");
		
		for(String strFlow : json.split("\n")) {
			inserts.append("{ \"index\":{} }\n");
			inserts.append(strFlow).append("\n");
		}

		exchange.getIn().setHeader("CamelHttpMethod", "POST");
		exchange.getIn().setHeader("Content-Type", "application/x-ndjson");
		exchange.getIn().setBody(inserts.toString());

		LOG.debug("Dados "+inserts);
	}
	
	public int randomInt(int valueMax){
		Random gerador = new Random();
        return gerador.nextInt(valueMax);
	}

}
