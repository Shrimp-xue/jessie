package com.jessie.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * 
 * <p>描述: 附件下载工具类</p>
 * <p>创建人 : xueqiang </p>
 * <p>创建时间: 创建时间:2017年11月3日 上午11:34:42 </p>  
 * <p>版本: 1.0 </p>
 * <p>包名: com.chinacoal.apie.util </p>
 * <p>类名: FileUtils </p>
 */
public class FileUtils {
	
	public static void downLoadFile(String scopeDirName, String filename,HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		File f = new File(scopeDirName);
		if (!f.exists()) {
			response.sendError(404, "File not found!");
			return;
		}
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
		byte[] buf = new byte[1024];
		int len = 0;
		response.reset();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream; charset=utf-8"); 
		//new String(fileName.getBytes("gb2312"),"ISO-8859-1") 中文编码，防止乱码
		//filename用""引起来，防止火狐截断
		response.setHeader("Content-Disposition",
		"attachment; filename=\"" + new String(f.getName().getBytes("gb2312"),"ISO-8859-1") + "\"");

		//response.setContentType("application/x-msdownload");
		//response.setHeader("Content-Disposition", "attachment; filename=" + f.getName().trim());
		OutputStream out = response.getOutputStream();
		while ((len = br.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		br.close(); 
		out.flush();
		out.close();
	}
}
