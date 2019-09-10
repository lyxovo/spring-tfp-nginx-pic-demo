package cn.ssm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.ssm.utils.FtpUtil;

/**
 * 上传图片测试，仅仅是使用到该Controller和jsp页面，还有一个工具类。其他都没有用到，除了依赖.
 * @author wachs
 */
@Controller
public class PicController {
	//这些常量可以写到配置文件中，使用@value获取。
	private final static String serverUrl="192.168.84.129";//nginx服务器的访问地址
	private final static Integer port=21;//ftp服务器端口
	private final static String root="ftpuser";//ftp用户名
	private final static String password="ftpuser";//ftp密码
	private final static String updateServerUrlParent="/home/ftpuser/www";//基础路径，对应nginx配置
	private final static String updateServerUrlChildren="/images/2020/01/01/";//自定义路径，主要用于分类和避免名称重复
	@RequestMapping("/upload")
	public String updatePic(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		try {  
			InputStream in = file.getInputStream();//获取上传的文件流
			String originalFilename =System.currentTimeMillis()+file.getOriginalFilename();//上传的文件名称
	        boolean flag = FtpUtil.uploadFile(serverUrl, port, root, password, updateServerUrlParent,updateServerUrlChildren,originalFilename, in);  
	        if(flag) {
	        	//把url返回到页面回显。
	        	model.addAttribute("fileUrl", "http://"+serverUrl+updateServerUrlChildren+originalFilename);
	        }
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();//如果开启事务，这里是要回滚的  
	    }  
      return "showpic";
	}

	
	@RequestMapping("/download")
	public String downloadPic() throws Exception {
		try {  
		    boolean flag = FtpUtil.downloadFile("192.168.84.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images/2020/01/01/", "1568103649818Koala.jpg", "D:\\testpic\\");  
	    } catch (Exception e) {  
	        e.printStackTrace();
	    }  
      return "success";
	}
}
