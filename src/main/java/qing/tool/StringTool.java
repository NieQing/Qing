package qing.tool;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 字符串工具类
 *
 * 
 * @since 1.0.0
 */
public final class StringTool {
	private final static Logger log = LoggerFactory.getLogger(StringTool.class);


	/**
	 * 把文件中的内容读到一个字符串中，编码使用VM的缺省编码。
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String readFileToString(String fileName) throws Exception {
		File file = new File(fileName);
		String content = FileUtils.readFileToString(file, Charset.defaultCharset());
		return content;
	}

	/**
	 * 写一个字符串到文件
	 * @param fileName
	 * @param data
	 * @throws IOException
	 */
	public static void writeStringToFile(String fileName, String data) throws IOException {
		File file = new File(fileName);
		FileUtils.writeStringToFile(file, data, Charset.defaultCharset());

	}

	/**
	 * 判断字符串在Trim后是否为空
	 */
	public static boolean IsTrimEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	/**
	 * 判断字符串在Trim后是否不为空
	 */
	public static boolean isNotTrimEmpty(String str) {
		return !IsTrimEmpty(str);
	}


}
