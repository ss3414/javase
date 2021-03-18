package javautil.untitled;

import java.io.UnsupportedEncodingException;

public class Encode {

    /* fixme UTF-8编码也会被识别为GBK编码 */
    public static String getEncoding(String str) {
        try {
            String[] charsetArray = new String[]{"ASCII", "GBK", "ISO-8859-1", "UTF-8"};
            for (String charset : charsetArray) {
                if (str.equals(new String(str.getBytes(charset), charset))) {
                    return charset;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convert2utf8(String input, String charset) {
        String output = "";
        try {
            output = new String(input.getBytes(charset), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return output;
    }

}
