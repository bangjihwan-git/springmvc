package hello.springmvc.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestBodyStringController {
	
	@PostMapping(".request-body-string-v1")
	public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		log.info("messageBody={}", messageBody);
		
		response.getWriter().write("ok");
	}
	
	@PostMapping(".request-body-string-v2")
	public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		log.info("messageBody={}", messageBody);
		
		responseWriter.write("ok");
	}
	
//	@PostMapping(".request-body-string-v3")
//	public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
//		
//		String messageBody = httpEntity.getBody();
//		log.info("messageBody={}", messageBody);
//		
//		return new HttpEntity<>("ok");
//	}
	
	//HttpEntity 상속받은 것들
	@PostMapping(".request-body-string-v3")
	public HttpEntity<String> requestBodyStringV3(RequestEntity<String> httpEntity) throws IOException {
		
		String messageBody = httpEntity.getBody();
		log.info("messageBody={}", messageBody);
		return new ResponseEntity<>("ok", HttpStatus.CREATED);
	}
	
	@ResponseBody
	@PostMapping(".request-body-string-v4")
	public String requestBodyStringV4(@RequestBody String messageBody) throws IOException {
		log.info("messageBody={}", messageBody);
		return "ok";
	}
}
