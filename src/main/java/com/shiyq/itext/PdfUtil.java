/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.itext;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.shiyq.poi.HSSFTest.setList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class PdfUtil {

    public static final String DEST = "d:/temp/发卡记录-2016-5-4.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createPdf(DEST);
    }

    public static void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        //正文字体大小
        int fontsize = 10;
        FontSelector selector = getSelector(fontsize);
        String title = "2016年5月发卡记录";
        //标题字体大小
        int titleFontSize = 20;
        //创建标题
        addTile(document, title, titleFontSize);
        String describe = "--创建时间：2016-5-4 12:23:23 创建人：石永强";
        //创建副标题，说明
        addDescribe(document, describe, selector);
        String[] head = {"卡号", "卡类型", "车牌号", "持卡人姓名", "卡上余额", "开始时间", "截止时间", "月卡延期金额", "发卡时间", "发卡人工号", "发卡人姓名"};
        String[] code = {"card_no", "card_type", "plate", "owner_name", "blance", "start_time", "end_time", "month_money", "spread_time", "spread_emp_no", "spread_emp_name"};
        List<Map<String, Object>> list = setList();
        PdfPTable table = new PdfPTable(head.length + 1);
        //创建表头
        createTableHead(table, head, selector);
        //创建表内容
        createTableContent(table, list, code, selector);
        document.add(table);
        document.close();
    }

    public static FontSelector getSelector(int fontsize) {
        FontSelector selector = new FontSelector();
        selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, fontsize));
        selector.addFont(FontFactory.getFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, fontsize));
        return selector;
    }

    private static PdfPTable createTableHead(PdfPTable table, String[] head, FontSelector selector) {
        Phrase str = selector.process("编号");
        table.addCell(str);
        for (int i = 0; i < head.length; i++) {
            str = selector.process(head[i]);
            table.addCell(str);
        }
        return table;
    }

    private static PdfPTable createTableContent(PdfPTable table, List<Map<String, Object>> list, String[] code, FontSelector selector) {

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            createTableCell(table, map, code, selector, i);
        }
        return table;
    }

    private static PdfPTable createTableCell(PdfPTable table, Map<String, Object> map, String[] code, FontSelector selector, int index) {
        Phrase str = selector.process(String.valueOf(index + 1));
        table.addCell(str);
        for (int i = 0; i < code.length; i++) {
            str = selector.process((String) map.get(code[i]));
            table.addCell(str);
        }
        return table;
    }

    private static void addTile(Document document, String title, int titleFontSize) throws DocumentException {
        FontSelector titleSelector = getSelector(titleFontSize);
        Paragraph titleP = new Paragraph(titleSelector.process(title));
        titleP.setAlignment(Element.ALIGN_CENTER);
        document.add(titleP);
        document.add(Chunk.NEWLINE);
    }

    private static void addDescribe(Document document, String describe, FontSelector selector) throws DocumentException {
        Paragraph descP = new Paragraph(selector.process(describe));
        descP.setAlignment(Element.ALIGN_JUSTIFIED);
        descP.setIndentationLeft(document.getPageSize().getRight() * 3 / 7);
        document.add(descP);
        document.add(Chunk.NEWLINE);
    }

}
