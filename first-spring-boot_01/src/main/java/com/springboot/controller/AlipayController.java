package com.springboot.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.springboot.entity.OrderItem;
import com.springboot.service.OrderItemService;
import com.springboot.service.OrderService;

/**
 * 支付宝支付Controller
 * 
 */
@RestController
@RequestMapping("/alipay")
public class AlipayController {

	// 获取配置文件的信息
	// 用户APPid
	@Value("${alipay.appId}")
	String app_id;

	// 私钥
	@Value("${alipay.merchantPrivateKey}")
	String private_key;

	// 同步返回地址
	@Value("${alipay.notifyUrl}")
	String notify_url;

	// 异步返回地址
	@Value("${alipay.returnUrl}")
	String return_url;

	// 支付网端
	@Value("${alipay.gatewayUrl}")
	String url;

	// 编码格式
	@Value("${alipay.charset}")
	String charset;

	// 传输格式
	@Value("${alipay.format}")
	String format;

	// 公钥
	@Value("${alipay.alipayPublicKey}")
	String public_key;

	// 签名方式
	@Value("${alipay.signType}")
	String signtype;

	// 支付成功地址
	@Value("${pay_s_url}")
	String pay_success;

	// 支付失败地址
	@Value("${pay_f_url}")
	String pay_failure;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	/**
	 * 支付请求
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public void pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 模拟从前台传来的数据
		String orderNo = request.getParameter("orderId"); // 获取订单号
		String totalAmount = request.getParameter("payment"); // 支付总金额
		String subject = request.getParameter("subject"); // 订单名称
		String body = "reading"; // 商品描述
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key,
				signtype);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(return_url);
		alipayRequest.setNotifyUrl(notify_url);

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderNo + "\"," + "\"total_amount\":\"" + totalAmount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		// 输出
		response.getWriter().println(result);
	}

	/**
	 * 同步跳转
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/returnUrl")
	public void returnUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		Map<String, Object> map = new HashMap<>();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr);
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no"));

			map.put("status", "1"); // 未发货状态
			orderService.update(map);

			Map<String, Object> orderMap = new HashMap<>();
			orderMap.put("orderId", out_trade_no);
			List<OrderItem> orderItemList = orderItemService.findList(orderMap);
			// 支付成功时修改订单状态
			for (OrderItem orderItem : orderItemList) {
				orderItem.setStatus("1");
				// 更新订单详情状态
				orderItemService.update(orderItem);
			}
			response.sendRedirect(pay_success + "?orderId=" + out_trade_no);
		} else {
			// 支付失败
			// 待付款状态
			map.put("status", "0");
			orderService.update(map);
			response.sendRedirect(pay_failure);
		}
	}

	/**
	 * 支付宝服务器异步通知
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/notifyUrl")
	public void notifyUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		Map<String, Object> map = new HashMap<>();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr);
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

		if (signVerified) { // 验证成功 更新订单信息
			System.out.println("异步通知成功");
			// 商户订单号
			String out_trade_no = request.getParameter("out_trade_no");
			// 交易状态
			String trade_status = request.getParameter("trade_status");
			// 修改数据库
			
			map.put("status", "1"); // 未发货状态
			orderService.update(map);

			Map<String, Object> orderMap = new HashMap<>();
			orderMap.put("orderId", out_trade_no);
			List<OrderItem> orderItemList = orderItemService.findList(orderMap);
			// 支付成功时修改订单状态
			for (OrderItem orderItem : orderItemList) {
				orderItem.setStatus("1");
				// 更新订单详情状态
				orderItemService.update(orderItem);
			}
			response.sendRedirect(pay_success + "?orderId=" + out_trade_no);
		} else {
			System.out.println("异步通知失败");
			response.sendRedirect(pay_failure);
		}
	}

}
