package com.carto.netty.factorial;

import io.netty.channel.*;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@ChannelHandler.Sharable
public class FactorialClientHandler extends SimpleChannelInboundHandler<BigInteger> {

    private ChannelHandlerContext ctx;
    private int receivedMessages;
    private int next = 1;
    final BlockingQueue<BigInteger> answer = new LinkedBlockingDeque<BigInteger>();

    public BigInteger getFactorial() {
        boolean interrupted = false;
        try {
            for (; ; ) {
                try {
                    return answer.take();
                } catch (InterruptedException ignore) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        sendNumbers();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, final BigInteger msg) throws Exception {
        receivedMessages++;
        if (receivedMessages == FactorialClient.COUNT) {
            ctx.channel().close().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    boolean offered = answer.offer(msg);
                    assert offered;
                }
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private void sendNumbers() {
        ChannelFuture future = null;
        for (int i = 0; i < 4096 && next <= FactorialClient.COUNT; i++) {
            future = ctx.write(next);
            next++;
        }
        if (next <= FactorialClient.COUNT) {
            assert future != null;
            future.addListener(numberSender);
        }
        ctx.flush();
    }

    private final ChannelFutureListener numberSender = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                sendNumbers();
            } else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };
}
