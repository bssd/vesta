package uk.co.bssd.vesta;

public interface MessageFuture {

	void awaitUninterruptibly();
	
	boolean isSuccessful();
}