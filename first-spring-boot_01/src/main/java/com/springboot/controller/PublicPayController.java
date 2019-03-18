package com.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.OrderItem;
import com.springboot.service.OrderItemService;
import com.springboot.service.OrderService;
import com.springboot.tools.PaymentUtil;

/**
 * 支付接口
 * 
 * @author hlx
 */
@RestController
@RequestMapping("/pay")
public class PublicPayController {

	@Value("${pay.keyValue}")
	String keyValue;

	@Value("${pay.url}")
	String payUrl;

	@Value("${pay_s_url}")
	String pay_success;

	@Value("${pay_f_url}")
	String pay_failure;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	// 会员名称: tiantest@126.com
	// 交易密码: 123123
	@RequestMapping(value = "", method = RequestMethod.GET)
	public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String p0_Cmd = "Buy", p1_MerId = "10001126856", p2_Order = request.getParameter("p2_Order"),
				p3_Amt = request.getParameter("p3_Amt"), p4_Cur = "CNY", p5_Pid = "", p6_Pcat = "", p7_Pdesc = "",
				p8_Url = "http://localhost:8080/pay/back?orderId=" + p2_Order, p9_SAF = "", pa_MP = "",
				pd_FrpId = request.getParameter("pd_FrpId"), pr_NeedResponse = "1";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		String url = payUrl + "?" + "&p0_Cmd=" + p0_Cmd + "&p1_MerId=" + p1_MerId + "&p2_Order=" + p2_Order + "&p3_Amt="
				+ p3_Amt + "&p4_Cur=" + p4_Cur + "&p5_Pid=" + p5_Pid + "&p6_Pcat=" + p6_Pcat + "&p7_Pdesc=" + p7_Pdesc
				+ "&p8_Url=" + p8_Url + "&p9_SAF=" + p9_SAF + "&pa_MP=" + pa_MP + "&pd_FrpId=" + pd_FrpId
				+ "&pr_NeedResponse=" + pr_NeedResponse + "&hmac=" + hmac;
		response.sendRedirect(url);
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public void returnPay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String r1_Code = request.getParameter("r1_Code");
		String orderId = request.getParameter("orderId");
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderId);
		// 支付成功
		if ("1".equals(r1_Code)) {
			map.put("status", "1"); // 未发货状态
			orderService.update(map);
			Map<String, Object> orderMap = new HashMap<>();
			orderMap.put("orderId", orderId);
			List<OrderItem> orderItemList = orderItemService.findList(orderMap);
			for (OrderItem orderItem : orderItemList) {
				orderItem.setStatus("1");
				// 更新订单详情状态
				orderItemService.update(orderItem);
			}
			response.sendRedirect(pay_success + "?orderId=" + orderId);
			// 支付失败
		} else {
			map.put("status", "0"); // 待付款状态
			orderService.update(map);
			response.sendRedirect(pay_failure);
		}
	}

}
