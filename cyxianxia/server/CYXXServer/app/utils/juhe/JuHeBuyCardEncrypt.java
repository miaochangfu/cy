package utils.juhe;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
  
public class JuHeBuyCardEncrypt {
	
     /**
      * 解密
      * @param srcMsg 密文
      * @param password密码
      * @return解密后的明文
      */
    public static String decrypt(String srcMsg,String password){
        byte[] bb = Base64.decodeBase64(srcMsg.getBytes());
        try {
             // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] decryResult = cipher.doFinal(bb);
            return new String (decryResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 加密
     * @param srcMsg  待加密字符串
     * @param password        密码
     * @return   加密后的密文
     */
    public static String encrypt(String srcMsg, String password){
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 现在，获取数据并加密
            // 正式执行加密操作
            byte[] result =cipher.doFinal(srcMsg.getBytes());
          //Base64编码
            byte[] resultBase = Base64.encodeBase64(result, true);
            return new String(resultBase);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
