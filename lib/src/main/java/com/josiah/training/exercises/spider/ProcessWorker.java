package com.josiah.training.exercises.spider;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/****************************************************************************
 * <b>Title:</b> ProcessWorker.java
 * <b>Project:</b> lib
 * <b>Description:</b> init spider process given params from config
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author Josiah Webb
 * @version 3.x
 * @since Oct 2, 2023
 * <b>updates:</b>
 *
 ****************************************************************************/

public class ProcessWorker {

    public void run() throws IOException {

        // gets new config worker and loads file
        AppConfig ac = new AppConfig();
        ac.loadConfig();
        // gets props from config
		String usr = AppConfig.getUsername();
		String pw = AppConfig.getPassword();
		String route = AppConfig.getOptionalRoute();
		int portNumber = Integer.parseInt(AppConfig.getPort());
		String host = AppConfig.getUrl();
        // encodes email and pw
        usr = URLEncoder.encode(usr, "UTF-8");
        pw = URLEncoder.encode(pw, "UTF-8");
        // string to aid in post request
        String reqInfo = "requestType=reqBuild&pmid=ADMIN_LOGIN&emailAddress=" + usr + "&password=" + pw +"&l=";
        // fetcher variable
        SocketConnection fetcher = null;

        // init task
//		if(email != null & pw != null) {
//			fetcher = new SocketConnection(host, portNum, route, email, pw);
//		} else {
//			fetcher = new SocketConnection(host, portNum);
//		}

//		if(isPrintToFile == "true") fetcher.writeAllPagesToFiles(fileType);

        fetcher = new SocketConnection(host, portNumber, route, usr, pw);
        fetcher.connRequest("post", reqInfo);
        fetcher.connRequest("get", null);
//        System.out.println(fetcher.getStringData());
        CreateFile printer = new CreateFile("html");
        printer.filePrinter("cacheStats", fetcher.getStringData());
    }

}
