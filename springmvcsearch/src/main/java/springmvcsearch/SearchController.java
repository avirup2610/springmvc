package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	
	@ModelAttribute
	public void common(Model m)
	{
		m.addAttribute("Header", "Google search");
	}
	
	@RequestMapping("/search")
	public String search()
	{
		
		System.out.println("this is first handler");
		return "search";
	}
	
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public RedirectView handelForm(@RequestParam("search") String Search,BindingResult result) {
		
		String url="https://google.com/search?q="+Search;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		
		return redirectView;
	}
	
	
	//PathVariable
	@RequestMapping("/book/{userid}/{username}")
	public String getUserDetail(@PathVariable("userid") int userid, @PathVariable("username") String username)
	{
		System.out.println("using path variable"+userid);
		System.out.println("name is"+ username);
		return "successful";
	}
	
	
    //This method will throw error, because during process it is trying to take out length of null
	@RequestMapping("/handle")
	public String handle()
	{
		String s=null;
		System.out.println(s.length());
		return "successful";
	}
	
	//Handling exception in Spring mvc
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({NullPointerException.class})
	public String handleException()
	{
		return "exception_page";
	}
	
	//Handling every exception
	@ExceptionHandler(value=Exception.class)
	public String handleEveryException()
	{
		return "exception_page";
	}

}
