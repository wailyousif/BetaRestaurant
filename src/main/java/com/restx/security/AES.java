package com.restx.security;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by wailm.yousif on 3/27/17.
 */
public class AES
{
    private static final String SHARED_KEY = "Z4mQ#3f5*vnW8<@5j7v?_-1P=]cLo,&B";
    private static final String INIT_VECTOR = "M-%aYq?Nd+cKi>Hp@t<ix9|E;g4A$h0[";


    public String aesEncrypt(String value)
    {
        try
        {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(SHARED_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }


    public String aesDecrypt(String base64Encrypted)
    {
        try
        {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(SHARED_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(base64Encrypted));

            return new String(original);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}
