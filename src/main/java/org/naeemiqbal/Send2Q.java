package org.naeemiqbal;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Send2Q {

	Logger LOG = Logger.getLogger(Send2Q.class.getName());

	@GetMapping(path = "/send2q")
	String send(String message) {
		return "Work in progress";
	}
	/*
	 * @GetMapping(path = "/listq") String list(String message) { AmazonSQS sqs =
	 * AmazonSQSClientBuilder.defaultClient(); ListQueuesResult lq_result =
	 * sqs.listQueues(); StringBuilder str = new StringBuilder(); //
	 * System.out.println("Your SQS Queue URLs:"); for (String url :
	 * lq_result.getQueueUrls()) { str.append(url).append("\n"); } return
	 * str.toString(); }
	 */

/*	@SqsListener("https://sqs.us-east-2.amazonaws.com/039859352486/MyQueue")
	public void listen(String message) {
		LOG.info("!!!! received message " + message);
	}*/
}
