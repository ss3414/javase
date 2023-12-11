package c07;

import c06.User2;
import javautil.common.Constant;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class C07_8 {

    @Test
    @SneakyThrows
    public void javax() {
        /* 对象转XML */
        JAXBContext context = JAXBContext.newInstance(User2.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        User2 user = new User2(1, "name", "pwd");
        marshaller.marshal(user, new FileOutputStream("C:/Users/Administrator/Desktop/test.xml"));

        /* XML转对象（禁用DTD/<!DOCTYPE foo SYSTEM "file:/dev/tty">） */
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        XMLReader xmlReader = factory.newSAXParser().getXMLReader();
        String xml = new String(Files.readAllBytes(Paths.get("C:/Users/Administrator/Desktop/test.xml")), StandardCharsets.UTF_8);
        InputSource inputSource = new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        SAXSource source = new SAXSource(xmlReader, inputSource);
        Unmarshaller unmarshaller = JAXBContext.newInstance(User2.class).createUnmarshaller();
        User2 user2 = (User2) unmarshaller.unmarshal(source);
        System.out.println(user2);
    }

    //    @Test
    public void lang() {
        System.out.printf("%s%s%n", "1", "2");
    }

    //    @Test
    public void math() {
        BigInteger bigInteger = new BigInteger("1234");
        System.out.println(bigInteger);

        BigDecimal bigDecimal = new BigDecimal("12.34");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.compareTo(new BigDecimal("0")));
    }

    //    @Test
    public void text() {
        System.out.println(new DecimalFormat("###,###0.00").format(0.11));
    }

    //    @Test
    @SneakyThrows
    public void util() {
        File file = new File("C:/Users/Administrator/Desktop/test.jpg");
        byte[] inputs = new byte[Math.toIntExact(file.length())];
        new FileInputStream(file).read(inputs);
        String str = Base64.getEncoder().encodeToString(inputs);
        System.out.println(str);

        OutputStream outputStream = new FileOutputStream("C:/Users/Administrator/Desktop/test2.jpg");
        outputStream.write(Base64.getDecoder().decode(str));
        outputStream.flush();
    }

    public static void util2() {
        List<String> input = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入列表，换行后按Ctrl+D结束：");
            while (true) {
                String line = scanner.nextLine();
                input.add(line);
            }
        } catch (NoSuchElementException e) {
            input.removeIf(element -> "".equals(element) || "\n".equals(element));
            List<String> output = input.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            output.forEach(System.out::println);
        }
    }

    class CustomTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("CustomTimerTask");
        }
    }

    //    @Test
    public void util3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        Date date = calendar.getTime();

        Timer timer = new Timer();
        timer.schedule(new CustomTimerTask(), date, Constant.ONE_DAY); /* 任务/时间/间隔 */
    }

    //    @Test
    public void util4() {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }

//    public static void main(String[] args) {
//        util2();
//    }

}
