package com.alaf.account.interceptors;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Provider
public class AccountInterceptor implements ContainerRequestFilter, ContainerResponseFilter { 

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		if (requestContext.getMethod().equals("GET")) {
            //requestContext.setMethod("POST");
			//log.info("ContainerRequestFilter......");
        }
        for (String key : requestContext.getHeaders().keySet()) {
            log.info("[Request Logging] {} : {}", new Object[] {key,  requestContext.getHeaders().get(key)});
        }
	}
	
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext crc1) throws IOException {
        if (requestContext.getMethod().equals("GET")) {
        	//log.info("ContainerResponseFilter......");
        	requestContext.getHeaders().add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
        	requestContext.getHeaders().add("Expires", "-1");
        }
        
        for (String key : crc1.getHeaders().keySet()) {
            log.info("[Response Logging] {} : {}", new Object[] {key,  crc1.getHeaders().get(key)});
        }
        
        log.info("[Response Logging] StatusCode: {}", crc1.getStatusInfo().getStatusCode());
    }
}
