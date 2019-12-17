package com.jjm.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("servletPath:"+request.getServletPath());
		System.out.println("contextPath:"+request.getContextPath());
		System.out.println("contextPath2:"+request.getServletContext().getContextPath());
		System.out.println("pageInfo:"+request.getPathInfo());
		System.out.println("uri:"+request.getRequestURI());
		System.out.println("url:"+request.getRequestURL());
		System.out.println("realPath:"+request.getServletContext().getRealPath("/"));
		
		// get the path for downloading files
		String path = getServletContext().getRealPath("/") + "files/";
		String filename = request.getParameter("filename");
		File file = new File(path + filename);
		if(file.exists()){
			// set corresponding content type
			response.setContentType("application/x-msdownload");
			// set information in the head
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
			InputStream inputStream = new FileInputStream(file);
			ServletOutputStream ouputStream = response.getOutputStream();
			byte bytes[] = new byte[1024];
			int n ;
			while((n = inputStream.read(bytes)) != -1){
				ouputStream.write(bytes,0,n);
			}
			
			//close input and output stream
			ouputStream.close();
			inputStream.close();
		}else{
			
			request.setAttribute("feedback", "file not exist.Error!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/01.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
