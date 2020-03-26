/*
package end.s2.end.zip;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterOutputStream;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

*/
/**
 * @Description:
 * @Author: Fyh
 * @Date: 2020/3/24 9:44
 * <p>
 * 将字符串压缩后Base64
 * @param primStr
 * 待加压加密函数
 * @return 将压缩并Base64后的字符串进行解密解压
 * @param compressedStr
 * 待解密解压字符串
 * @return
 *//*

@Slf4j
public class ZipUtil {
    // 压缩字符串
    public static String compressData(String data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DeflaterOutputStream zos = new DeflaterOutputStream(bos);
            zos.write(data.getBytes());
            zos.close();
            return new String(getenBASE64inCodec(bos.toByteArray()));
        } catch (Exception ex) {

            log.error("压缩文本出现异常", ex);
            throw new RuntimeException("压缩文本出现异常");
        }
    }

    public static String getenBASE64inCodec(byte[] b) {
        if (b == null)
            return null;
        return new String((new Base64()).encode(b));
    }

    public static byte[] getdeBASE64inCodec(String s) {
        if (s == null)
            return null;
        return new Base64().decode(s.getBytes());
    }

    public static String decompressData(String encdata) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            InflaterOutputStream zos = new InflaterOutputStream(bos);
            zos.write(getdeBASE64inCodec(encdata));
            zos.close();
            return new String(bos.toByteArray());
        } catch (Exception ex) {
            log.error("还原压缩文本出现异常", ex);
            throw new RuntimeException("还原压缩文本出现异常");
        }
    }

    public final static String CHARSET = "utf-8";

    */
/**
 * 将字符串压缩后Base64
 *
 * @param primStr
 *            待加压加密函数
 * @return
 *//*

    public static String gzipString(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }
        ByteArrayOutputStream out = null;
        GZIPOutputStream gout = null;
        try {
            out = new ByteArrayOutputStream();
            gout = new GZIPOutputStream(out);
            gout.write(primStr.getBytes(CHARSET));
            gout.flush();
        } catch (IOException e) {
            log.error("对字符串进行加压加密操作失败：", e);
            return null;
        } finally {
            if (gout != null) {
                try {
                    gout.close();
                } catch (IOException e) {
                    log.error("对字符串进行加压加密操作，关闭gzip操作流失败：", e);
                }
            }
        }
        return getenBASE64inCodec(out.toByteArray());
    }

    */
/**
 * 将压缩并Base64后的字符串进行解密解压
 *
 * @param compressedStr
 *            待解密解压字符串
 * @return
 *//*

    public static final String ungzipString(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        GZIPInputStream gin = null;
        String decompressed = null;
        try {
            byte[] compressed = getdeBASE64inCodec(compressedStr);
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            gin = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = gin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString(CHARSET);
        } catch (IOException e) {
            log.error("对字符串进行解密解压操作失败：", e);
            decompressed = null;
        } finally {
            if (gin != null) {
                try {
                    gin.close();
                } catch (IOException e) {
                    log.error("对字符串进行解密解压操作，关闭压缩流失败：", e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("对字符串进行解密解压操作，关闭输入流失败：", e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("对字符串进行解密解压操作，关闭输出流失败：", e);
                }
            }
        }
        return decompressed;
    }
}
*/
