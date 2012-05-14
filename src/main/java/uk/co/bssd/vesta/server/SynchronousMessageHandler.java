package uk.co.bssd.vesta.server;

public interface SynchronousMessageHandler<REQ, RESP> {

	RESP onMessage(REQ message);
}