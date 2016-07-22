package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.Stack;
import com.video.Utility;

/**
 * Servlet implementation class VideoInfo
 */
@WebServlet("/VideoInfo")
public class VideoInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String url=request.getParameter("url");
		  System.out.println(url);
		  final Logger log = Logger.getLogger(Stack.class.getCanonicalName());
		  try {
			
			Utility ut = new Utility();
			ut.setupLogging();
			
			log.fine("Starting");
			String videoId = "9mdJV5-eias";
			String outdir = "F:\\youtubjar";
			int format = 18; // http://en.wikipedia.org/wiki/YouTube#Quality_and_codecs
			String encoding = "UTF-8";
			String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13";
			File outputDir = new File(outdir);
			String extension = ut.getExtension(format);

			ut.play(videoId, format, encoding, userAgent, outputDir, extension);

		} catch (Throwable t) {
			t.printStackTrace();
		}
		log.fine("Finished");
		 
	}

}
