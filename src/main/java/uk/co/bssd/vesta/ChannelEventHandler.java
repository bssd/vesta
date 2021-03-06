package uk.co.bssd.vesta;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.group.ChannelGroup;

public class ChannelEventHandler extends SimpleChannelUpstreamHandler {

	private final ChannelGroup channelGroup;

	public ChannelEventHandler(ChannelGroup channelGroup) {
		this.channelGroup = channelGroup;
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		Channel channel = ctx.getChannel();
		this.channelGroup.add(channel);
	}
}