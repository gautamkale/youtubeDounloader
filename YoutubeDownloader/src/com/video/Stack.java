package com.video;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class Stack {



 public static void main(String[] args) {
  /*if (args == null || args.length == 0) {
   usage("Missing video id. Extract from http://www.youtube.com/watch?v=VIDEO_ID");
  }*/
	  final Logger log = Logger.getLogger(Stack.class.getCanonicalName());
  try {
	  Utility ut=new Utility();
	  ut.setupLogging();

   log.fine("Starting");
   String videoId = "9mdJV5-eias";
   String outdir = "F:\\youtubjar";
   // TODO Ghetto command line parsing
   /*if (args.length == 1) {
    videoId = args[0];
   } else if (args.length == 2) {
    videoId = args[0];
    outdir = args[1];
   }*/

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

/**
 * <pre>
 * Exploded results from get_video_info:
 * 
 * fexp=90...
 * allow_embed=1
 * fmt_stream_map=35|http://v9.lscache8...
 * fmt_url_map=35|http://v9.lscache8...
 * allow_ratings=1
 * keywords=Stefan Molyneux,Luke Bessey,anarchy,stateless society,giant stone cow,the story of our unenslavement,market anarchy,voluntaryism,anarcho capitalism
 * track_embed=0
 * fmt_list=35/854x480/9/0/115,34/640x360/9/0/115,18/640x360/9/0/115,5/320x240/7/0/0
 * author=lukebessey
 * muted=0
 * length_seconds=390
 * plid=AA...
 * ftoken=null
 * status=ok
 * watermark=http://s.ytimg.com/yt/swf/logo-vfl_bP6ud.swf,http://s.ytimg.com/yt/swf/hdlogo-vfloR6wva.swf
 * timestamp=12...
 * has_cc=False
 * fmt_map=35/854x480/9/0/115,34/640x360/9/0/115,18/640x360/9/0/115,5/320x240/7/0/0
 * leanback_module=http://s.ytimg.com/yt/swfbin/leanback_module-vflJYyeZN.swf
 * hl=en_US
 * endscreen_module=http://s.ytimg.com/yt/swfbin/endscreen-vflk19iTq.swf
 * vq=auto
 * avg_rating=5.0
 * video_id=S6IZP3yRJ9I
 * token=vPpcFNh...
 * thumbnail_url=http://i4.ytimg.com/vi/S6IZP3yRJ9I/default.jpg
 * title=The Story of Our Unenslavement - Animated
 * </pre>
 */
