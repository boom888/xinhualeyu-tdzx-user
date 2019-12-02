package com.tdzx.user.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
public class WXBizDataCrypt {
    public static String decrypt(String encryptedData, String iv, String sessionKey) throws Exception{
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] keyByte = decoder.decode(sessionKey);
        byte[] encryptedDataByte = decoder.decode(encryptedData);
        byte[] ivByte = decoder.decode(iv);

//这边导入 bouncycastle Maven包
/*
    <dependency>
     <groupId>org.bouncycastle</groupId>
     <artifactId>bcprov-ext-jdk16</artifactId>
     <version>1.46</version>
     <type>jar</type>
     <scope>compile</scope>
    </dependency>
*/
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
        SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
        AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
        parameters.init(new IvParameterSpec(ivByte));
        //设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, spec,parameters);

        byte[] resultByte = cipher.doFinal(encryptedDataByte);

        String result = null;
        if (null != resultByte && resultByte.length > 0) {
            result = new String(resultByte, "UTF-8");
        }
        // 返回前，可以对比appId
        return result;
    }
}
