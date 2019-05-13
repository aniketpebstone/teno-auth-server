package com.teno;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
	
//@WebFilter(urlPatterns="/create-user")
@Component
@Order(1)
public class OtpFilter extends OncePerRequestFilter {

	private static final String OTP_HEADER="otp";
	private static final String PHONE_HEADER="phone";
	
	@Override
	public void destroy() {
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
try {
            
            System.out.println("================================== In OTP filter ===================================");
    		
            
//            HttpServletRequest request=(HttpServletRequest)req;
//            HttpServletResponse response=(HttpServletResponse)resp;
            
            int otp=Integer.parseInt(request.getHeader(OTP_HEADER));
            int phone=Integer.parseInt(request.getHeader(PHONE_HEADER));
            
            if(otp==1234 && phone==1234512345)
            {
            	chain.doFilter(request, response);
            }
            throw new RuntimeException("Invalid OTP/Phone");
        } catch(Exception e) {            
            throw new RuntimeException(e);
        }

	
		
	}
	@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return !path.startsWith("/create-user");
    }

}
