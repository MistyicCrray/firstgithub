package com.springboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tools.PaymentUtil;

/**
 * 支付接口
 * 
 * @author hlx
 * @date 2018年12月19日
 */
@RestController
@RequestMapping("/pay")
public class PublicPayController {

	@Value("${pay.keyValue}")
	String keyValue;
	@Value("${pay.url}")
	String payUrl;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String 	p0_Cmd="Buy",
				p1_MerId="10001126856",
				p2_Order=request.getParameter("p2_Order"),
				p3_Amt=request.getParameter("p3_Amt"),
				p4_Cur="CNY",
				p5_Pid="",
				p6_Pcat="",
				p7_Pdesc="",
				p8_Url="",
				p9_SAF="",
				pa_MP="",
				pd_FrpId=request.getParameter("pd_FrpId"),
				pr_NeedResponse="1";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		String url = payUrl + "?"+
		"&p0_Cmd="+p0_Cmd+
		"&p1_MerId="+p1_MerId+
		"&p2_Order="+p2_Order+
		"&p3_Amt="+p3_Amt+
		"&p4_Cur="+p4_Cur+
		"&p5_Pid="+p5_Pid+
		"&p6_Pcat="+p6_Pcat+
		"&p7_Pdesc="+p7_Pdesc+
		"&p8_Url="+p8_Url+
		"&p9_SAF="+p9_SAF+
		"&pa_MP="+pa_MP+
		"&pd_FrpId="+pd_FrpId+
		"&pr_NeedResponse="+pr_NeedResponse+
		"&hmac="+hmac;
		response.sendRedirect(url);
	}

}
