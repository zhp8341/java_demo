package com.demo.file;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2021/8/13
 * @time 17:35
 */

public class Main {

    final static String pattern_xin_2 = "output_data_202108112059562468.*";

    public static void main(String[] args) {
//        long size = FileUtils.sizeOfDirectory(new File("/Users/huipeizhu/"));
//        System.out.println("Size: " + size/1024/1024 + " M");

//        File file = new File("/Users/huipeizhu/sophon/delete");
//        if (file.isDirectory() && file.delete()) {
//            System.out.println("文件夹删除成功");
//        }

        getFileName("/Users/huipeizhu/sophon/water-drop-algo/data/10002/LMDB");


    }


    public static void getFileName(String path) {

        List<String> list = new ArrayList<String>();

        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {

                boolean isMatch = Pattern.matches(pattern_xin_2, fs.getName());
                if (isMatch) {
                    list.add(fs.getName());
                    System.out.println(fs.getName() + " [目录]");
                }

            } else {
                System.out.println(fs.getName() + " [非目录]");
            }
        }

        System.out.println(list.size());
    }
}
