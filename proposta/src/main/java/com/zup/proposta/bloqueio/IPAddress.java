package com.zup.proposta.bloqueio;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class IPAddress {

    public static String getClientIp(HttpServletRequest req){

        String remoteAddr = "";

        if(req != null){
            remoteAddr = req.getHeader("X-FORWARDED-FOR");
            if(remoteAddr == null || "".equals(remoteAddr)){
                remoteAddr = req.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

}
