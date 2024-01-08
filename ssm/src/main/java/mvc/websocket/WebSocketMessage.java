package mvc.websocket;

import lombok.SneakyThrows;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class WebSocketMessage extends MessageInbound {

    @Override
    @SneakyThrows
    protected void onOpen(WsOutbound outbound) {
        outbound.writeTextMessage(CharBuffer.wrap("WebSocket"));
    }

    @Override
    protected void onBinaryMessage(ByteBuffer byteBuffer) {

    }

    @Override
    protected void onTextMessage(CharBuffer charBuffer) {

    }

}
