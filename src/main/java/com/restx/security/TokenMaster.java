package com.restx.security;

import com.restx.data.datatabs.AppUser;
import com.restx.data.datatabs.AuthToken;
import com.restx.data.repo.AuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by wailm.yousif on 3/27/17.
 */
public class TokenMaster
{
    private static final String SECRET = "ObxSvj#k!W3+s";

    @Autowired
    private AuthTokenRepo authTokenRepo;

    private String generateNonce()
    {
        Random rand = new Random();
        int min = 1001;
        int max = 9999;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return String.valueOf(randomNum);
    }


    public String genreateToken(AppUser appUser)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        String dateString = dateFormat.format(cal.getTime());
        String clearToken = String.format("%s:%s:%s:%s:%s",
                dateString, SECRET, generateNonce(), appUser.getId());

        AES aes = new AES();
        String tokenString = aes.aesEncrypt(clearToken);

        AuthToken authToken = new AuthToken(tokenString, new Date(), 0,
                new Date(), appUser);
        authTokenRepo.save(authToken);

        return tokenString;
    }


    /**
     * Returns null if token is invalid
     */
    public Long validateTokenAndGetUserId(String encryptedToken)
    {
        Long userId = null;
        try
        {
            AES aes = new AES();
            String decrypted = aes.aesDecrypt(encryptedToken);

            StringTokenizer st = new StringTokenizer(decrypted, ":");
            String dateString = st.nextToken();
            String secret = st.nextToken();

            if(secret.equals(SECRET))
            {
                st.nextToken();
                userId = Long.parseLong(st.nextToken());
            }
        }
        catch(Exception e)
        {
            System.out.println("Token validation exception: " + e.getMessage() +
                ", AuthToken=" + encryptedToken);
        }

        return userId;
    }

}
