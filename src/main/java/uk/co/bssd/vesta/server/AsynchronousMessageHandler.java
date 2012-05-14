package uk.co.bssd.vesta.server;

public interface AsynchronousMessageHandler<REQ> {

	void onMessage(REQ message);
}