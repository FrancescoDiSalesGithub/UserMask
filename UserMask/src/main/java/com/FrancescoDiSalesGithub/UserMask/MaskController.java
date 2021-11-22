package com.FrancescoDiSalesGithub.UserMask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FrancescoDiSalesGithub.ModelMask.MaskModelRequest;

@RestController
public class MaskController 
{
	@Autowired
	private MaskService maskService;

	@PostMapping("/mask")
	public String doRequest(@RequestBody MaskModelRequest maskModelRequest,HttpServletRequest request) throws Exception
	{
		
		String output = maskService.mask(maskModelRequest,request);
		return output;
		
	}
	
}
