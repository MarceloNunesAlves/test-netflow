package br.com.flexvision.processor;

import java.util.Random;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.flexvision.dto.Flow;

@Component
public class InfluxNative implements Processor {
	private static final transient Logger LOG = LoggerFactory.getLogger(InfluxNative.class);

	public void process(Exchange exchange) throws Exception {
		String json = (String) exchange.getIn().getBody();
		LOG.debug(json);
		
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder inserts = new StringBuilder("");
		
		for(String strFlow : json.split("\n")) {
			Flow flow = mapper.readValue(strFlow, Flow.class);
			
			inserts.append("flow")
					.append(",nextHop=").append(flow.getNextHop())
					.append(",srcPort=").append(flow.getSrcPort())
					.append(",output=").append(flow.getOutput())
					.append(",dstPort=").append(flow.getDstPort())
					.append(",prot=").append(flow.getProt())
					.append(",tos=").append(flow.getTos())
					.append(",tcpFlags=").append(flow.getTcpFlags())
					.append(",dstAs=").append(flow.getDstAs())
					.append(",dstMask=").append(flow.getDstMask())
					.append(",version=").append(flow.getVersion())
					.append(",input=").append(flow.getInput())
					.append(",srcAddr=").append(flow.getSrcAddr())
					.append(",dstAddr=").append(flow.getDstAddr())
					.append(",srcMask=").append(flow.getSrcMask())
					.append(",srcAs=").append(flow.getSrcAs())										
					.append(" dPkts=").append(flow.getdPkts())
					.append(",count=").append(flow.getdPkts())
					.append(",dOctets=").append(flow.getdPkts())
					.append(" ").append(flow.getEpochTime().toEpochMilli()).append("000000").append("\n");
		}

		exchange.getIn().setHeader("CamelHttpMethod", "POST");
		exchange.getIn().setBody(inserts.toString());

		LOG.debug("Dados "+inserts);
	}
	
	public int randomInt(int valueMax){
		Random gerador = new Random();
        return gerador.nextInt(valueMax);
	}

}
