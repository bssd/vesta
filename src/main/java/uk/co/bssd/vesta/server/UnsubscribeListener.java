package uk.co.bssd.vesta.server;

import java.net.SocketAddress;

public interface UnsubscribeListener {

	void onUnsubscribe(SocketAddress clientAddress, String channelName);
}