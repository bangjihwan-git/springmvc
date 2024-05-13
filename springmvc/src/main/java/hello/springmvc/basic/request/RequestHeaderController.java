package hello.springmvc.basic.request;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequestHeaderController {
	
	//https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/arguments.html 참고
	@RequestMapping("/headers")
	public String header(HttpServletRequest request,
						 HttpServletResponse response,
						 HttpMethod httpMethod,
						 Locale locale,
						 @RequestHeader MultiValueMap<String, String> headerMap,
						 @RequestHeader("host") String host,
						 @CookieValue(value = "myCookie", required = false) String cookie
						 ){
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("locale={}", locale);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", cookie);
		return "ok";
	}
}
