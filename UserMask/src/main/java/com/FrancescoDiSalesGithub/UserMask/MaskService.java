package com.FrancescoDiSalesGithub.UserMask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.FrancescoDiSalesGithub.ModelMask.MaskModelRequest;

@Service
public class MaskService 
{

	
	public String mask(MaskModelRequest maskModelRequest, HttpServletRequest request) throws Exception
	{
			RestTemplate requestTemplate = new RestTemplate();
			HttpHeaders httpHeaders = new HttpHeaders();
			
			if(maskModelRequest.getUrl() == null)
				throw new Exception("Url is empty");
			
			if(maskModelRequest.getUserAgent() == null)
				throw new Exception("User agent not found");
			
			HttpMethod restTemplateMethod;
			
			if(request.getMethod().equals("GET"))
				restTemplateMethod=HttpMethod.GET;
			if(request.getMethod().equals("POST"))
				restTemplateMethod=HttpMethod.POST;
			else
				throw new Exception("Http method not supported by the program");
			
			httpHeaders.add("User-agent",maskModelRequest.getUserAgent());
			HttpEntity<Object> httpEntity = new HttpEntity<>("",httpHeaders);
			
			ResponseEntity<String> response = requestTemplate.exchange(maskModelRequest.getUrl(), restTemplateMethod, httpEntity,String.class);
			
			return response.getBody();
	
	}

}
