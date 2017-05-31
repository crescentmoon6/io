/**
 * @Title:   [Test1.java]
 * @Package: [io]
 * @author:  [YunGao] 
 * @CreateDate: [2017年5月31日 下午1:48:19]   
 * @UpdateUser: [YunGao]   
 * @UpdateDate: [2017年5月31日 下午1:48:19]   
 * @UpdateRemark: [说明本次修改内容]
 * @Description:  [TODO(用一句话描述该文件做什么)]
 * @version: [V1.0]
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {

	public static void printFile(File f, File df) throws IOException {

		if (!f.isDirectory()) {
			return;
		}

		File[] files = f.listFiles();

		BufferedReader br = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(df, true)));

		for (File file : files) {
			if (file.isDirectory()) {
				printFile(file, df);
			} else {
				if (file.getName().endsWith(".java") || file.getName().endsWith(".txt")) {
					System.out.println(file);
					try {
						br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
						while (br.readLine() != null) {
							bw.write(br.readLine());
							bw.flush();
						}
					}catch(IOException e){
						
					} finally {
						if (bw != null) {
							try {
								bw.close();
							} catch (IOException e) {
							}
						}
						if(br!=null){
							try{
								br.close();
							}catch(IOException e){
							}
						}
					}
				}
			}
		}

	}
	public static void main(String[] args) throws IOException{
		File file = new File("H:\\svn");
		File dFile = new File("H:\\DAC\\test1\\Test2.txt");
		printFile(file, dFile);


	}

}
