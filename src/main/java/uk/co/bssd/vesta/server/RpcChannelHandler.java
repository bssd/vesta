package uk.co.bssd.vesta.server;

import java.io.Serializable;
import java.util.concurrent.Executors;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import uk.co.bssd.vesta.message.AsynchronousRequest;
import uk.co.bssd.vesta.message.SynchronousRequest;

public class RpcChannelHandler extends SimpleChannelUpstreamHandler {

	private final AsynchronousMessageDispatcher asynchronousMessageDispatcher;
	private final SynchronousMessageDispatcher synchronousMessageDispatcher;

	public RpcChannelHandler() {
		this.asynchronousMessageDispatcher = new AsynchronousMessageDispatcher(
				Executors.newFixedThreadPool(1));
		this.synchronousMessageDispatcher = new SynchronousMessageDispatcher(
				Executors.newFixedThreadPool(1));
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		Object message = e.getMessage();

		if (message instanceof AsynchronousRequest) {
			this.asynchronousMessageDispatcher
					.dispatch((AsynchronousRequest) message);
		} else if (message instanceof SynchronousRequest) {
			this.synchronousMessageDispatcher.dispatch(
					(SynchronousRequest) message, e.getChannel());
		} else {
			ctx.sendUpstream(e);
		}
	}

	public void registerAsynchronousMessageHandler(
			Class<? extends Serializable> clazz,
			AsynchronousMessageHandler<? extends Serializable> handler) {
		this.asynchronousMessageDispatcher.registerHandler(clazz, handler);
	}

	public void registerSynchronousMessageHandler(
			Class<? extends Serializable> clazz,
			SynchronousMessageHandler<? extends Serializable, ? extends Serializable> handler) {
		this.synchronousMessageDispatcher.registerHandler(clazz, handler);
	}
}