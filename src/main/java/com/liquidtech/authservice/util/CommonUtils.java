/**
 * CommonUtils - Auto-generated class
 *
 * @Author: @RahulBudhiraja
 * @Created: 7/1/2025
 */

package com.liquidtech.authservice.util;

import java.util.Base64;

public class CommonUtils {

    public static String Base64decoder(String request){
        String response;
      Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodedBytes =decoder.decode(request);
            response=decodedBytes.toString();
        return response;
    }
}
