package uk.co.bssd.vesta.server;

import uk.co.bssd.vesta.message.SimpleRequest;
import uk.co.bssd.vesta.message.SimpleResponse;
import uk.co.bssd.vesta.server.SynchronousMessageHandler;

public class EchoSimpleRequestHandler implements SynchronousMessageHandler<SimpleRequest, SimpleResponse>{

	@Override
	public SimpleResponse onMessage(SimpleRequest request) {
		return new SimpleResponse(request.payload());
	}
}