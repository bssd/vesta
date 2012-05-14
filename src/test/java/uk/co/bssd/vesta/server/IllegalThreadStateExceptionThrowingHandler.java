package uk.co.bssd.vesta.server;

import java.io.Serializable;

import uk.co.bssd.vesta.server.SynchronousMessageHandler;

public class IllegalThreadStateExceptionThrowingHandler implements SynchronousMessageHandler<Serializable, Serializable>{

	@Override
	public Serializable onMessage(Serializable message) {
		throw new IllegalThreadStateException();
	}
}