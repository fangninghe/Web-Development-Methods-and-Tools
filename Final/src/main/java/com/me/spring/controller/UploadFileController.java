package com.me.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.me.spring.dao.SellerUserDAO;
import com.me.spring.pojo.SellerUser;

@Controller
public class UploadFileController {

	@Autowired
	ServletContext context;

	public UploadFileController() {

	}

	@RequestMapping(value = "/uploadfile.htm", method = RequestMethod.POST)
	protected String uploadFileHandler(@RequestParam("name") String name, @RequestParam("photo") MultipartFile file,
			HttpServletRequest request) {

		if (!file.isEmpty()) {
			try {
				HttpSession session = request.getSession();
				SellerUser sellerUser = (SellerUser) session.getAttribute("sellerUser");
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				SellerUserDAO sellerUserDao = new SellerUserDAO();
				sellerUser.setPhotoName(serverFile.getAbsolutePath());
				sellerUserDao.create(sellerUser);
				request.setAttribute("upload", "upload");
				//return "sellerPage";
			} catch (Exception e) {
				request.setAttribute("fail", "fail");
				//return "sellerPage";
			}
		} else {
			request.setAttribute("fail", "fail");
		}
		return "sellerPage";

	}
}
