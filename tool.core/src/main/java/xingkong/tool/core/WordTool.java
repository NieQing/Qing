package xingkong.tool.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WordTool {
	
	public static void printTableH(String fileName) throws FileNotFoundException, IOException {
		HWPFDocument document = new HWPFDocument(new FileInputStream(fileName));
		Range range = document.getRange();
		TableIterator talbleIter = new TableIterator(range);
		// 获取所有表格
		
		while (talbleIter.hasNext()) {
		    // 获取表格的行
		    Table table = (Table)talbleIter.next();
		    for (int i=0; i<table.numRows(); i++) {
		        // 获取表格的每个单元格
		        TableRow tr = table.getRow(i);
		        for (int j=0; j<tr.numCells();j++) {
		             // 获取单元格的内容
		            TableCell cell = tr.getCell(j); 
		            String text = "";
		        	for(int k=0;k<cell.numParagraphs();k++)
		        	{
		        		Paragraph para = cell.getParagraph(k);
		        		text+=para.text().trim()+" ";
		        	}
		            System.out.print(text + " ");
		        }
		        System.out.println();
		    }
		    break;
		}
	}
	
	public static void printTable(String fileName) throws FileNotFoundException, IOException {
		XWPFDocument document = new XWPFDocument(new FileInputStream(fileName));
		// 获取所有表格
		List<XWPFTable> tables = document.getTables();
		for (XWPFTable table : tables) {
		    // 获取表格的行
		    List<XWPFTableRow> rows = table.getRows();
		    for (XWPFTableRow row : rows) {
		        // 获取表格的每个单元格
		        List<XWPFTableCell> tableCells = row.getTableCells();
		        for (XWPFTableCell cell : tableCells) {
		             // 获取单元格的内容
		             String text = cell.getText();
		             System.out.print(text + " ");
		        }
		        System.out.println();
		    }
		    break;
		}
	}
	
	
	public static void main(String[] args) {
		try {
			printTableH("E:\\test2.doc");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
