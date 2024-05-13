package hello.springmvc.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {
	// @Slf4j 롬복으로 대체
	//private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";
		log.trace("trace log={}", name);
		log.debug("debug log={}", name);
		log.info("info log={}", name);
		log.warn("warn log={}", name);
		log.error("error log={}", name);
		return "ok";
	}
}
