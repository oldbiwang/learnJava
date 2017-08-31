package com.wrp.io;

import java.io.IOException;
import java.io.File;

public class FileTest {
	public static void main(String[] args) throws IOException {
		//以当前路径来创建一个 File 对象
		File file = new File(".");

		//直接获取文件名，输出一点
		System.out.println(file.getName());

		//获取相对路径的父路径可能出错，下面代码输出 null 
		System.out.println(file.getParent());

		//获取绝对路径
		System.out.println(file.getAbsoluteFile());

		//获取上一级路径
		System.out.println(file.getAbsoluteFile().getParent());

		//在当前路径下创建一个临时文件
		File tmpFile = File.createTempFile("aaa", ".txt", file);

		//指定当 JVM 退出时删除该文件
		tmpFile.deleteOnExit();

		//以系统当前时间作为新文件名来创建新文件
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile 对象是否存在：" + newFile.exists());

		//以指定 newFile 对象来创建一个文件
		newFile.createNewFile();
		System.out.println("newFile 对象是否存在：" + newFile.exists());
		System.out.println(newFile.getAbsoluteFile());
		System.out.println(file.getAbsolutePath());
		System.out.println(newFile.getName());

		//重命名文件
		File aaa = new File(file.getAbsolutePath() + "aaa");
		aaa.createNewFile();
		aaa.deleteOnExit();
		System.out.println(newFile.renameTo(aaa));
		System.out.println(newFile.getName());

		 File oldName = new File("D:/program.txt");
	 	 File newName = new File("D:/java.txt");
      	 newName.deleteOnExit();

      	oldName.createNewFile();
      	newName.createNewFile();
      	 System.out.println("oldName 对象是否存在：" + oldName.exists());
      	 System.out.println("newName 对象是否存在：" + newName.exists());
      	 if(oldName.renameTo(newName)) {
        	System.out.println("renamed");
     	 } else {
     	 	System.out.println("Error");
         }


		//以指定 newFile 对象来创建一个目录，因为 newFile 已经存在
		//所以下面方法返回 false ，即无法创建该目录
		//System.out.println(newFile.mkdir());

		//使用 list() 方法列出当前路径下的所有文件和路径
	/*	String[] fileList = file.list();
		System.out.println("====当前路径下所有文件和路径如下====");
		for(String fileName : fileList) {
			System.out.println(fileName);
		}

		//listRoots() 静态方法列出所有的磁盘根目录
		File[] roots = File.listRoots();
		System.out.println("====系统所有根路径如下====");
		for(File root : roots) {
			System.out.println(root);
			String[] fileList1 = root.list();
			System.out.println("====当前根路径下所有文件和路径如下====");
			
			if(root.list() != null) {
				for(String fileName1 : fileList1) {
					System.out.println(fileName1);
				}
			}
		}
	*/
	}
}