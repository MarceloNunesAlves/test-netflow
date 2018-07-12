package br.com.flexvision.processor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.flexvision.dto.Flow;

@Component
public class GenerateMessage implements Processor {

	/***************
	nextHop			srcPort	output	dstPort	prot	importDate				dPkts	tos	tcpFlags	dstAs	dstMask	count	version	dOctets	input	srcAddr			dstAddr			srcMask	srcAs
	10.10.33.117	55105	9		26170	6		2018-07-04 03:03:49.615	1		0	16			0		20		30		5		41		2		10.31.19.132	10.30.33.239	20		0
	10.10.34.69		26147	1		20440	6		2018-07-04 03:03:47.339	12		0	27			0		20		30		5		9315	2		10.41.17.154	10.5.17.238		20		0
	10.10.34.69		19051	1		63484	6		2018-07-04 03:03:47.339	12		0	27			0		20		30		5		9315	2		10.41.17.152	10.0.17.207		20		0
	10.10.32.149	54385	3		445		6		2018-07-04 03:03:49.638	1		72	2			0		0		30		5		52		2		10.72.31.3		161.6.223.7		20		0
	10.10.34.69		55650	1		389		17		2018-07-04 03:03:47.339	1		40	16			0		20		30		5		237		2		10.41.17.85		10.0.17.34		20		0
	10.10.32.5		80		2		58559	6		2018-07-04 03:03:47.349	1		0	16			0		20		30		5		52		3		10.0.28.187		10.60.19.56		20		0
	10.10.32.149	54391	3		445		6		2018-07-04 03:03:49.638	1		72	2			0		0		30		5		52		2		10.72.31.3		1.189.61.16		20		0
	10.0.224.26		51083	3		389		17		2018-07-04 03:03:47.349	1		48	16			0		20		30		5		235		2		10.63.17.1		10.0.17.3		20		0
	10.10.32.149	54410	3		445		6		2018-07-04 03:03:49.638	1		0	2			0		0		30		5		52		2		10.72.31.3		16.202.95.41	20		0
	0.0.0.0			62973	0		161		17		2018-07-04 03:03:47.358	1		0	16			0		32		14		5		121		3		10.97.201.234	100.124.76.246	8		65004
	***************/
	
	public void process(Exchange exchange) throws Exception {
		int count_seg = Integer.valueOf((String) exchange.getIn().getHeader("COUNT_FOR_SEG"));
		
		List<Flow> listFlow = new ArrayList<Flow>();
		for(int i=0;i<count_seg;i++) {
			Flow flow = new Flow();
			flow.setNextHop("10.10."+String.valueOf(randomInt(255))+"."+String.valueOf(randomInt(255)));
			flow.setSrcPort(randomInt(49999));
			flow.setOutput(randomInt(99));
			flow.setEpochTime(Instant.now());
			flow.setdPkts(randomInt(999));
			flow.setTos(randomInt(999));
			flow.setTcpFlags(randomInt(999));
			flow.setDstAs(randomInt(999));
			flow.setDstMask(randomInt(999));
			flow.setCount(randomInt(999));
			flow.setVersion(randomInt(10));
			flow.setdOctets(randomInt(999));
			flow.setInput(randomInt(999));
			flow.setSrcAddr("10."+String.valueOf(randomInt(255))+"."+String.valueOf(randomInt(255))+"."+String.valueOf(randomInt(255)));
			flow.setDstAddr("10."+String.valueOf(randomInt(255))+"."+String.valueOf(randomInt(255))+"."+String.valueOf(randomInt(255)));
			flow.setSrcMask(randomInt(999));
			flow.setSrcAs(randomInt(999));
			listFlow.add(flow);
		}
		
		//Monta a lista de nodes em Json
		StringBuilder body = new StringBuilder();
		ObjectMapper mapper = new ObjectMapper();
		for(Flow f : listFlow) {
			body.append(mapper.writeValueAsString(f));
			body.append("\n");
		}
		exchange.getIn().setBody(body);	
	}
	
	public int randomInt(int valueMax){
		Random gerador = new Random();
        return gerador.nextInt(valueMax);
	}

}
