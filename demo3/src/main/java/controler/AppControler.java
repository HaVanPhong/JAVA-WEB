package controler;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControler {
	@RequestMapping("/hehe")
	public String home () {
		return "hello anh em";
	}

}
