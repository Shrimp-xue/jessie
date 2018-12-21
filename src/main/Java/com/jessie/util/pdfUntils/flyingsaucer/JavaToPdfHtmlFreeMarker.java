package com.jessie.util.pdfUntils.flyingsaucer;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.jessie.util.PathUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdfHtmlFreeMarker {

    //private static final String DEST = "target/HelloWorld_CN_HTML_FREEMARKER_FS.pdf";
    private static final String DEST = "/apie/pdf/" + "双创网站信息发布申请单" + getYearMonthDay() + ".pdf";
    private static final String HTML = "/pdf/template_freemarker_fs.html";
    private static final String FONT = "/pdf/simhei.ttf";
    private static final String LOGO_PATH = "file://" + PathUtil.getCurrentPath() + "/pdf/logo.png";

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

    public static void main(String[] args) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        Map<String, Object> data = new HashMap();
        data.put("title", "鲁家宁");
        String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data, HTML);
        JavaToPdfHtmlFreeMarker.createPdf(content, DEST);
    }

    /**
     * 创建人: xueqiang
     * 创建时间: 2018年2月6日 下午2:31:44
     * 描述 : 导出pdf
     * 包名: com.jessie.util.pdfUntils.flyingsaucer
     * 类名: JavaToPdfHtmlFreeMarker.java
     * 方法名: exprotPDF
     *
     * @param request
     * @param response
     * @param resultArticle
     * @param resultTestAudit
     * @param resultNewSiteName
     * @throws Exception void
     * @throws
     */
//    public static void exprotPDF(HttpServletRequest request, HttpServletResponse response, List<Article> resultArticle, List<TestAudit> resultTestAudit, List<String> resultNewSiteName) throws Exception {
//        Map<String, Object> data = new HashMap();
//        data.put("resultArticle", resultArticle);
//        data.put("resultTestAudit", resultTestAudit);
//        data.put("resultNewSiteName", resultNewSiteName);
//        String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data, HTML);
//        String file = request.getSession().getServletContext().getRealPath("") + DEST;
//        JavaToPdfHtmlFreeMarker.createPdf(content, file);
//        String attchName = "测试";
//        FileUtils.downLoadFile(file, attchName, request, response);
//        File f = new File(file);
//        if (f.exists()) {
//            f.delete();
//        }
//    }

    /**
     * 创建人: xueqiang
     * 创建时间: 2018年2月6日 下午2:31:56
     * 描述 : freemarker渲染html
     * 包名: com.jessie.util.pdfUntils.flyingsaucer
     * 类名: JavaToPdfHtmlFreeMarker.java
     * 方法名: freeMarkerRender
     *
     * @param data
     * @param htmlTmp
     * @return String
     * @throws
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

    /**
     * 创建人: xueqiang
     * 创建时间: 2018年2月6日 下午2:32:05
     * 描述 : 生成PDF模板
     * 包名: com.jessie.util.pdfUntils.flyingsaucer
     * 类名: JavaToPdfHtmlFreeMarker.java
     * 方法名: createPdf
     *
     * @param content
     * @param dest
     * @throws IOException
     * @throws DocumentException
     * @throws com.lowagie.text.DocumentException void
     * @throws
     */
    public static void createPdf(String content, String dest) throws IOException, DocumentException, com.lowagie.text.DocumentException {
        ITextRenderer render = new ITextRenderer();
        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解析html生成pdf
        render.setDocumentFromString(content);
        //解决图片相对路径的问题
        render.getSharedContext().setBaseURL(LOGO_PATH);
        render.layout();
        render.createPDF(new FileOutputStream(dest));
    }

    /**
     * 创建人: xueqiang
     * 创建时间: 2018年2月6日 下午2:32:21
     * 描述 : 生成年月日
     * 包名: com.jessie.util.pdfUntils.flyingsaucer
     * 类名: JavaToPdfHtmlFreeMarker.java
     * 方法名: getYearMonthDay
     *
     * @return String
     * @throws
     */
    public static String getYearMonthDay() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) + "日";
    }
}
