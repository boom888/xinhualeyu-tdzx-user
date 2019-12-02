package com.tdzx.user.utils;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.GeneralSecurityException;

public class AESUtil implements Serializable {

    /**
     * AES加密
     * 
     * @param content
     * @return
     * @throws Exception
     */
    public static String encrypt(String content) throws Exception {

        Cipher cipher = Cipher.getInstance(KeyConfig.fullAlg);
        IvParameterSpec iv = new IvParameterSpec(initIv(KeyConfig.fullAlg));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES"), iv);

        byte[] encryptBytes = cipher.doFinal(content.getBytes(KeyConfig.input_charset));
        return new String(Base64.encodeBase64(encryptBytes));
    }

    /**
     * 初始向量的方法, 全部为0. 这里的写法适合于其它算法,针对AES算法的话,IV值一定是128位的(16字节).
     *
     * @param fullAlg
     * @return
     * @throws GeneralSecurityException
     */
    private static byte[] initIv(String fullAlg) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(fullAlg);
        int blockSize = cipher.getBlockSize();
        byte[] iv = new byte[blockSize];
        for (int i = 0; i < blockSize; ++i) {
            iv[i] = 0;
        }
        return iv;
    }

    /**
     * AES解密
     * 
     * @param content 密文
     * @return 原文
     * @throws
     */
    public static String stringDecrypt(String content) throws Exception {

        // 反序列化AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES");

        // 128bit全零的IV向量
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initIv(KeyConfig.fullAlg));

        // 初始化加密器并加密
        Cipher deCipher = Cipher.getInstance(KeyConfig.fullAlg);
        deCipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        byte[] encryptedBytes = Base64.decodeBase64(content.getBytes());
        byte[] bytes = deCipher.doFinal(encryptedBytes);
        return new String(bytes);

    }

    /**
     * AES解密
     * 
     * @param content 密文
     * @return 原文
     * @throws
     */
    public static String integerDecrypt(String content) throws Exception {

        // 反序列化AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES");

        // 128bit全零的IV向量
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initIv(KeyConfig.fullAlg));

        // 初始化加密器并加密
        Cipher deCipher = Cipher.getInstance(KeyConfig.fullAlg);
        deCipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        byte[] encryptedBytes = Base64.decodeBase64(content);
        byte[] bytes = deCipher.doFinal(encryptedBytes);
        return String.valueOf(new String(bytes));

    }

    /**
     * AES double加密
     * 
     * @param content
     * @return
     * @throws Exception
     */
    public static String doubleEncrypt(Double content) throws Exception {

        Cipher cipher = Cipher.getInstance(KeyConfig.fullAlg);
        IvParameterSpec iv = new IvParameterSpec(initIv(KeyConfig.fullAlg));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES"), iv);

        byte[] encryptBytes = cipher.doFinal(content.toString().getBytes(KeyConfig.input_charset));
        return new String(Base64.encodeBase64(encryptBytes));
    }

    public static String integerEncrypt(Integer content) throws Exception {

        Cipher cipher = Cipher.getInstance(KeyConfig.fullAlg);
        IvParameterSpec iv = new IvParameterSpec(initIv(KeyConfig.fullAlg));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES"), iv);

        byte[] encryptBytes = cipher.doFinal(content.toString().getBytes(KeyConfig.input_charset));
        return new String(Base64.encodeBase64(encryptBytes));
    }

    /**
     * AES解密
     * 
     * @param content 密文
     * @return 原文
     * @throws
     */
    public static Double doubleDecrypt(String content) throws Exception {

        // 反序列化AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(KeyConfig.ChildrenAESKey.getBytes()), "AES");

        // 128bit全零的IV向量
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initIv(KeyConfig.fullAlg));

        // 初始化加密器并加密
        Cipher deCipher = Cipher.getInstance(KeyConfig.fullAlg);
        deCipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        byte[] encryptedBytes = Base64.decodeBase64(content);
        byte[] bytes = deCipher.doFinal(encryptedBytes);
        return Double.valueOf(new String(bytes).toString());

    }

    /**
     * 将二进制转换成16进制
     * 
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(AESUtil.integerDecrypt("LYjtPcuFvFLcnXIRfgHdYA=="));
        System.out.println(AESUtil.encrypt("123"));
    }
}
