package library.untitled;

import io.github.biezhi.ome.OhMyEmail;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class EmailDemo {

    @Test
    @SneakyThrows
    public void test() {
        OhMyEmail.config(OhMyEmail.SMTP_QQ(true), "", ""); /* 授权码而非密码 */
        OhMyEmail.subject("oh-my-email")
                .from("")
                .to("")
                .text("oh-my-email")
                .send();
    }

}
