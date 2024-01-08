package mvc.websocket;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.*;

@ServerEndpoint("/log")
public class LogWebSocket {

    private PipedReader pipedReader;
    private Writer writer;

    @OnOpen
    public void OnOpen(Session session) {
        try {
            Logger logger = Logger.getRootLogger();
            Appender appender = logger.getAppender("writer");
            pipedReader = new PipedReader();
            writer = new PipedWriter(pipedReader);
            ((WriterAppender) appender).setWriter(writer);

            BufferedReader bufferedReader = new BufferedReader(pipedReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                session.getBasicRemote().sendText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void OnClose() {
        try {
            pipedReader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
