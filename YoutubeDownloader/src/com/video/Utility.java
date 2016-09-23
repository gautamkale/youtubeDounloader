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
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
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

public class Utility {
	public String newline = System.getProperty("line.separator");
	List<Map<String, String>> urlParam = new ArrayList<Map<String, String>>();
	private final Level defaultLogLevelSelf = Level.FINER;
	private final Level defaultLogLevel = Level.WARNING;
	private final Logger rootlog = Logger.getLogger("");
	private final String scheme = "http";
	private final String host = "www.youtube.com";
	private final Pattern commaPattern = Pattern.compile(",");
	private final Pattern pipePattern = Pattern.compile("&");
	private final char[] ILLEGAL_FILENAME_CHARACTERS = { '/', '\n', '\r', '\t',
			'\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
	final Logger log = Logger.getLogger(Stack.class.getCanonicalName());

	public void usage(String error) {
		if (error != null) {
			System.err.println("Error: " + error);
		}
		System.err
				.println("usage: JavaYoutubeDownload VIDEO_ID DESTINATION_DIRECTORY");
		System.exit(-1);
	}

	public String getExtension(int format) {
		// TODO
		return "mp4";
	}

	public String getVideoId(String url) {
		// TODO
		String[] urlParam = null;
		Map<String, String> paramMap = new HashMap<String, String>();
		String urlP = url.substring(url.indexOf("?") + 1);
		urlParam = urlP.split("=");
		for (int i = 0; i < urlParam.length; i++) {
			paramMap.put(urlParam[i], urlParam[i++]);
		}
		return paramMap.get("v");
	}

	public List<TreeMap<String,String>> play(String videoId, int format, String encoding,
			String userAgent, File outputdir, String extension)
			throws Throwable {
		log.fine("Retrieving " + videoId);
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		List<TreeMap<String, String>> urlParamList = new ArrayList<TreeMap<String, String>>();
		qparams.add(new BasicNameValuePair("video_id", videoId));
		qparams.add(new BasicNameValuePair("fmt", "" + format));
		URI uri = getUri("get_video_info", qparams);

		CookieStore cookieStore = new BasicCookieStore();
		HttpContext localContext = new BasicHttpContext();
		localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(uri);
		httpget.setHeader("User-Agent", userAgent);

		log.finer("Executing " + uri);
		HttpResponse response = httpclient.execute(httpget, localContext);
		HttpEntity entity = response.getEntity();
		if (entity != null && response.getStatusLine().getStatusCode() == 200) {
			InputStream instream = entity.getContent();
			String videoInfo = getStringFromInputStream(encoding, instream);
			if (videoInfo != null && videoInfo.length() > 0) {
				List<NameValuePair> infoMap = new ArrayList<NameValuePair>();
				URLEncodedUtils
						.parse(infoMap, new Scanner(videoInfo), encoding);
				String token = null;
				String downloadUrl = null;
				String filename = videoId;

				for (NameValuePair pair : infoMap) {
					String key = pair.getName();
					String val = pair.getValue();
					log.finest(key + "=" + val);
					if (key.equals("token")) {
						token = val;
					} else if (key.equals("title")) {
						filename = val;
					} else if (key.equals("url_encoded_fmt_stream_map")) {
						String[] formats = commaPattern.split(val);
						for (String fmt : formats) {
							String[] fmtPieces = fmt.split("&");
							TreeMap<String, String> getVideoParam = new TreeMap<String, String>();
							for (String urlStr : fmtPieces) {
								String[] keyString = urlStr.split("=");

								getVideoParam.put(keyString[0],
										java.net.URLDecoder.decode(
												keyString[1], "UTF-8"));
								urlParamList.add(getVideoParam);
								

							}
							/*
							 * System.out.println(urlVal); for(Map<String,
							 * String> videoParam :urlVal){
							 * Iterator<Entry<String,String>> iterator =
							 * videoParam.entrySet().iterator(); while
							 * (iterator.hasNext()) { Map.Entry<String,String>
							 * entry = (Map.Entry<String,String>)
							 * iterator.next();
							 * System.out.println(entry.getKey() + " :" +
							 * entry.getValue());
							 * if(entry.getKey().equals("url")) { String result
							 * = java.net.URLDecoder.decode(entry.getValue(),
							 * "UTF-8"); //System.out.println(result);
							 * //downloadUrl=result; } } }
							 */
						}
					}
				}

				/*filename = cleanFilename(filename);

				File outputfile = new File(outputdir, filename);

				if (downloadUrl != null) {
					downloadWithHttpClient(userAgent, downloadUrl, outputfile);
				}*/
			}
		}
		return urlParamList;
	}
	public List<TreeMap<String, String>> removeDublicat(List<TreeMap<String, String>> urlParam2)
	{	
		
		for(int i=0;i <urlParam2.size();i++)
		{int count=0;
			for(int j=0;j< urlParam2.size();j++)
			{
				Set key1=urlParam2.get(i).keySet();
				Set key2=urlParam2.get(i).keySet();
				if(urlParam2.get(i).get("url").equals(urlParam2.get(j).get("url")))
				{
					count++;
					
				}
				
			}
			System.out.println(i+"             "+urlParam2.get(i).get("url")+"url    value of i"+count);
		}
		
		return urlParam2;
		
	}
	public void downloadWithHttpClient(String userAgent, String downloadUrl,
			File outputfile) throws Throwable {
		HttpGet httpget2 = new HttpGet(downloadUrl);
		httpget2.setHeader("User-Agent", userAgent);

		log.finer("Executing " + httpget2.getURI());
		HttpClient httpclient2 = new DefaultHttpClient();
		HttpResponse response2 = httpclient2.execute(httpget2);
		HttpEntity entity2 = response2.getEntity();
		if (entity2 != null && response2.getStatusLine().getStatusCode() == 200) {
			long length = entity2.getContentLength();
			InputStream instream2 = entity2.getContent();
			log.finer("Writing " + length + " bytes to " + outputfile);
			if (outputfile.exists()) {
				outputfile.delete();
			}
			FileOutputStream outstream = new FileOutputStream(outputfile);
			try {
				byte[] buffer = new byte[2048];
				int count = -1;
				while ((count = instream2.read(buffer)) != -1) {
					outstream.write(buffer, 0, count);
				}
				outstream.flush();
			} finally {
				outstream.close();
			}
		}
	}

	public String cleanFilename(String filename) {
		for (char c : ILLEGAL_FILENAME_CHARACTERS) {
			filename = filename.replace(c, '_');
		}
		return filename;
	}

	public URI getUri(String path, List<NameValuePair> qparams)
			throws URISyntaxException {
		URI uri = URIUtils.createURI(scheme, host, -1, "/" + path,
				URLEncodedUtils.format(qparams, "UTF-8"), null);
		return uri;
	}

	public void setupLogging() {
		changeFormatter(new Formatter() {
			@Override
			public String format(LogRecord arg0) {
				return arg0.getMessage() + newline;
			}
		});
		explicitlySetAllLogging(Level.FINER);
	}

	public void changeFormatter(Formatter formatter) {
		Handler[] handlers = rootlog.getHandlers();
		for (Handler handler : handlers) {
			handler.setFormatter(formatter);
		}
	}

	public void explicitlySetAllLogging(Level level) {
		rootlog.setLevel(Level.ALL);
		for (Handler handler : rootlog.getHandlers()) {
			handler.setLevel(defaultLogLevelSelf);
		}
		log.setLevel(level);
		rootlog.setLevel(defaultLogLevel);
	}

	public String getStringFromInputStream(String encoding, InputStream instream)
			throws UnsupportedEncodingException, IOException {
		Writer writer = new StringWriter();

		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(instream,
					encoding));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} finally {
			instream.close();
		}
		String result = writer.toString();
		return result;
	}

}
