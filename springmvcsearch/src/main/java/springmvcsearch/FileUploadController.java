package springmvcsearch;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/upload")
	public String upload()
	{
		return "fileform";
	}
	
	@RequestMapping(path="/upload" , method = RequestMethod.POST)
	public String uploading(@RequestParam("file") CommonsMultipartFile file,HttpSession s)
	{
		System.out.println("uploading");
		System.out.println(file.getSize());
		System.out.println(file.getStorageDescription());
		System.out.println(file.getContentType());
		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/")+file.getOriginalFilename();
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("file uploaded");
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("uploaded");
		}
		return "successful";
	}

}
