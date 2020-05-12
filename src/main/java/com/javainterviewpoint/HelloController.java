package com.javainterviewpoint;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class HelloController
{
	@Autowired
	DocumentDao documentDAO ;
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	 public static String uploadDirectory = "C:\\Users\\Vasudev\\Desktop\\changedfiles";
	 @GetMapping({"/", "/documentmgmt.htm"})
	 public ModelAndView showWelcomePage(HttpServletRequest request)
	 {
		 ModelAndView model = new ModelAndView("hello", "hello", new Document());
		 List<Document> DocumentList = documentDAO.getDocumentList();
		 System.out.println(DocumentList);
		 model.addObject("documentList",DocumentList);
		 model.addObject("document", new Document());
		 return model;
	 }
	 
	 
	 @GetMapping({"/uploaddoc"})
	 public ModelAndView showUploadPage(HttpServletRequest request)
	 {
		 ModelAndView model = new ModelAndView("uploadstatusview", "uploadstatusview", new Document());

		 Map<String, String> filetypeMap = documentDAO.getFileTypeMap();
		 model.addObject("filetypeMap", filetypeMap);
		 return model;
	 }
	 
	 @GetMapping({"/login.htm"})
	 public ModelAndView login(HttpServletRequest request)
	 {
		 ModelAndView model = new ModelAndView("login");

		 return model;
	 }
	 
	 @RequestMapping(value = "/uploadpdf.htm", method = RequestMethod.POST)
		public @ResponseBody ModelAndView uploadFile3(HttpServletRequest request,@RequestParam("files") MultipartFile[] files,@ModelAttribute("document") Document document) throws Exception {
		 ModelAndView model = new ModelAndView("uploadstatusview", "uploadstatusview", new Document());
		 
		 StringBuilder fileNames = new StringBuilder();

		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			     fileNames.append(file.getOriginalFilename()+" ");
			     String filetype = request.getParameter("hiddenFiletype");
				 System.out.println("filetype"+filetype);
			  try {
				Files.write(fileNameAndPath, file.getBytes());
				 List<Document> DocumentList = documentDAO.getDocumentList();
		         String fileNameWOExtenion= file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
                 Document doc=documentDAO.getDocumentDetailsByLocation(fileNameWOExtenion); 
                 documentDAO.updateDocumentDetails(doc,filetype);
				 model.addObject("documentList", DocumentList);
			} catch (IOException e) {
				e.printStackTrace();
			}
				 Map<String, String> filetypeMap = documentDAO.getFileTypeMap();
				 model.addObject("filetypeMap", filetypeMap);
			  model.addObject("msg", "Successfully uploaded file "+fileNames.toString());
			 
		}
		  return model;
	 }
	 
	 @GetMapping({"/processAfterUpload"})
	 public ModelAndView processAfterUpload(HttpServletRequest request)
	 {
		 ModelAndView model = new ModelAndView("uploadstatusview", "uploadstatusview", new Document());
		 List<Document> DocumentList = documentDAO.getDocumentList();
		 Map<String, String> filetypeMap = documentDAO.getFileTypeMap();
		  model.addObject("filetypeMap", filetypeMap);
         model.addObject("documentList", DocumentList);
		 return model;
	 }
	 @GetMapping("/uploadFiles.htm")
	  public ModelAndView upload(HttpServletRequest request , @RequestParam("files") MultipartFile[] files) {
		 ModelAndView model = new ModelAndView("uploadstatusview");
		 System.out.println("test");
		  StringBuilder fileNames = new StringBuilder();
		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
				 String filetype = request.getParameter("filetype");
				 System.out.println("filetype"+filetype);
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  model.addObject("msg", "Successfully uploaded files "+fileNames.toString());
		  return model;
	  }
		//@RequestMapping(value="/logout.htm", method = {RequestMethod.GET})

	/*
	 * public String logoutPage(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); if (auth != null) {
	 * new SecurityContextLogoutHandler().logout(request, response, auth); } return
	 * "redirect:/login.htm?logout";
	
		} */
		@RequestMapping(value="/deletefiles.htm",method = { RequestMethod.GET})
		public @ResponseBody ModelAndView publishParentContent(HttpServletRequest request) {
			ModelAndView model = new ModelAndView("hello");
			String checkedList = request.getParameter("checkedValues");
			List<String> checkedArraylist = Stream.of(checkedList.split(","))
					.collect(Collectors.toCollection(ArrayList::new));
			 for(String checkedId : checkedArraylist) { 
				 System.out.println(checkedId);
				 Document documentDetails=documentDAO.getDocumentDetails(checkedId);
				 File folder=new File(uploadDirectory);
					if(folder.exists() && folder.isDirectory()){

						for (File f : folder.listFiles()) {
							System.out.println("'"+f.getName()+"' deleted successfully");
					 if(f.getAbsolutePath().equals(documentDetails.getLocation())){ 
						 f.delete();
						 System.out.println("'"+f.getName()+"' deleted successfully");
					 }else{ System.out.println(
							 "Fail to delete '"+f.getName()+"'"); }
					  }
					}
			 documentDAO.deleteFile(checkedId); 		 
			 }
			 List<Document> DocumentList = documentDAO.getDocumentList();
				System.out.println(DocumentList);
				model.addObject("documentList", DocumentList);
				model.addObject("document", new Document());
			 return model;
		}
		
		
		
		@RequestMapping(value="/file/{fileName:.+}",method = { RequestMethod.GET})
		 @ResponseBody
		
		public void downloadPDFResource(@PathVariable("fileName") String fileName,HttpServletRequest request, HttpServletResponse response
				) throws IOException {
			String EXTERNAL_FILE_PATH = "C:/Users/Vasudev/Desktop/changedfiles/";
		/*
		 * String downloadFileId = request.getParameter("id"); Document
		 * documentDetails=documentDAO.getDocumentDetails(downloadFileId); File file =
		 * new File(documentDetails.getLocation()); String fileName=file.getName();
		 */
			File file = new File(EXTERNAL_FILE_PATH + fileName);
			if (file.exists()) {

				//get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);

				/**
				 * In a regular HTTP response, the Content-Disposition response header is a
				 * header indicating if the content is expected to be displayed inline in the
				 * browser, that is, as a Web page or as part of a Web page, or as an
				 * attachment, that is downloaded and saved locally.
				 * 
				 */

				/**
				 * Here we have mentioned it to show inline
				 */
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				 //Here we have mentioned it to show as attachment
				// response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
		}

		}
		   
