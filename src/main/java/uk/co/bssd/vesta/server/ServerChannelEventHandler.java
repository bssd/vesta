package uk.co.bssd.vesta.server;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.group.ChannelGroup;

import uk.co.bssd.vesta.ChannelEventHandler;

public class ServerChannelEventHandler extends ChannelEventHandler {

	private final ChannelSubscriptions channelSubscriptions;
	
	public ServerChannelEventHandler(ChannelGroup channelGroup, ChannelSubscriptions subscriptions) {
		super(channelGroup);
		this.channelSubscriptions = subscriptions;
	}
	
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		Channel channel = e.getChannel();
		this.channelSubscriptions.unsubscribeAll(channel);
		super.channelDisconnected(ctx, e);
	}
}