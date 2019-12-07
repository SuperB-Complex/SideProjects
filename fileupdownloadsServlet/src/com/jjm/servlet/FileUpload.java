package com.jjm.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// fetch stream data from request
		InputStream fileSource = request.getInputStream();
		String tempFileName = "D:/tempDirection";
		// tempFile referring to this temp file
		// the reason we have this temp file here is that the uploaded file have some extra content which is not supposed to be seen
		File tempFile = new File(tempFileName);
		// outputSrteam is pointing at this temp file
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		byte[] bytes = new byte[1024];
		int n;
		while ((n = fileSource.read(bytes)) != -1) {
			outputStream.write(bytes, 0, n);
		}
		
		// close input and output stream
		outputStream.close();
		fileSource.close();
		
		// get the name of the uploading file
		RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
		randomFile.readLine();
		String str = randomFile.readLine();
		int beginIndex = str.lastIndexOf("\\") + 1;
		int endIndex = str.lastIndexOf("\"");
		String filename = str.substring(beginIndex, endIndex);
		System.out.println("filename:" + filename);
		
		
		// locate the start of the file
		randomFile.seek(0);
		long startPosition = 0;
		int i = 1;
		//starting get the content of the file and update the start point
		while(( n = randomFile.readByte()) != -1 && i <=4){
			if(n == '\n'){
				startPosition = randomFile.getFilePointer();
				i ++;
			}
		}
		startPosition = randomFile.getFilePointer() -1;
		// locate the end of the file 
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();
		int j = 1;
		while(endPosition >= 0 && j <= 2){
			endPosition--;
			randomFile.seek(endPosition);
			if(randomFile.readByte() == '\n'){
				j++;
			}
		}
		endPosition = endPosition -1;
				
		// set the path for the uploaded file
		String realPath = getServletContext().getRealPath("/") + "files";
		File fileupload = new File(realPath);
		if(!fileupload.exists()){
			fileupload.mkdir();
		}
		File saveFile = new File(realPath,filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
		// read the actual file from the starting point
		randomFile.seek(startPosition);
		while(startPosition < endPosition){
			randomAccessFile.write(randomFile.readByte());
			startPosition = randomFile.getFilePointer();
		}
		//close input and output stream and delete the temp file
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();
		
		request.setAttribute("feedback", "uploding successful");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/front.jsp");
		dispatcher.forward(request, response);
	}

}
