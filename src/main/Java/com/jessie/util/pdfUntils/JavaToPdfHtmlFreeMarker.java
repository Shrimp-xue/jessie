package com.jessie.util.pdfUntils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.jessie.util.PathUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdfHtmlFreeMarker {

    private static final String DEST = "/apie/pdf/" + DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd") + ".pdf";
    private static final String HTML = "/pdf/template_freemarker.html";
    //private static final String HTML = "/apie/template/template_freemarker.html";
    private static final String FONT = "/pdf/simhei.ttf";

    private static Configuration freemarkerCfg = null;

    static {
        freemarkerCfg = new Configuration();
        //freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(PathUtil.getCurrentPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void exprotPDF(List<Article> result,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Map<String,Object> data = new HashMap();
////		List newList = new ArrayList<>();
////		newList.add("标题1");
////		newList.add("标题1");
////	    data.put("resultList",newList);
//		data.put("title","鲁家宁2222");
//		String file = request.getSession().getServletContext().getRealPath("") + DEST;
//		//String file1 = request.getSession().getServletContext().getRealPath("") + HTML;
//	    String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data, HTML);
//		JavaToPdfHtmlFreeMarker.createPdf(content,file);
//		String attchName = "测试";
//		FileUtils.downLoadFile(file , attchName, request, response);
//		File f = new File(file);
//		if(f.exists())
//		    f.delete();
//	}

    public static void createPdf(String content, String dest) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(FONT);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(content.getBytes()), null, Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();

    }

    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

//    public static void main(String[] args) throws IOException, DocumentException {
//    	Map<String,Object> data = new HashMap();
//    	// data.put("name","鲁家宁111");
//    	data.put("title","鲁家宁2222");
//    	String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data,HTML);
//    	JavaToPdfHtmlFreeMarker.createPdf(content,DEST);
//    }
}
