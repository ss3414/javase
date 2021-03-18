package library.untitled;

import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void test() throws SendMailException {
        OhMyEmail.config(OhMyEmail.SMTP_QQ(true), "3414523068@qq.com", "ubazjrnjmdccdbac"); /* 授权码而非密码 */
        OhMyEmail.subject("oh-my-email")
                .from("3414523068@qq.com")
                .to("2468776986@qq.com")
                .text("oh-my-email")
                .send();
    }

}
