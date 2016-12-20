package qing.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author NieQing
 * 
 */
public class FileTool {
	private static final Logger log = LoggerFactory.getLogger(FileTool.class);
	
	/**
	 * Description: 创建一个由path指定的目录,如果该目录存在，则不会创建
	 * @param path 文件目录
	 * @return 创建或者已经存在，返回true,否则返回false
	 */
	public static boolean createDir(String path) {
		try {
			File file = new File(path);
			if (!file.exists() && !file.isDirectory()) {
				if (file.mkdirs()) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			log.error("createDir" + path + "fail", e);
			return false;
		}
	}
	
	/**
	 * 获取文件后缀名
	 * @param originalFilename
	 * @return
	 */
	public static String getSuffix(String originalFilename){
		return originalFilename.substring(originalFilename.lastIndexOf(".")+1);
	}

}
