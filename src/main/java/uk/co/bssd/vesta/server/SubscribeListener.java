package uk.co.bssd.vesta.server;

import java.net.SocketAddress;

public interface SubscribeListener {

	void onSubscribe(SocketAddress clientAddress, String channelName);
}