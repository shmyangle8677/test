package xyl.home;

import java.io.*;
import xyl.filter.FileFilterImp;

/**
 * 取得txt文件内容的函数
 */
public class RedueFile {
    public static void main(String[] args) {
        String path="F:\\execute\\02-GSYH\\DATA";
        File file = new File(path);
        if(!file.isDirectory()){
            System.out.println("无此目录");
            return;
        }

        String[] list = file.list(new FileFilterImp(".TXT"));
        for(String filename:list){
            System.out.println(filename+"："+readLine_LineNumberReader(path+"\\"+filename));
        }
        //System.out.println("文件行数readLine："+readLine(path));
        //System.out.println("文件行数readLine_LineNumberReader："+readLine_LineNumberReader(path));
    }


    public static String readLine(String path){
        long index=0;
        long startdate = System.currentTimeMillis();
        long enddate = 0;
        try {
            RandomAccessFile file = new RandomAccessFile(new File(path),"r");
            while (file.readLine()!=null){
                index++;
            }
            enddate = System.currentTimeMillis();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index+"("+(enddate-startdate)/1000+"秒)";
    }

    /**
     * LineNumberReader 单就读行而言，100万行数据的统计在毫秒之间
     * @param path
     * @return
     */
    public static String readLine_LineNumberReader(String path){
        long index = 0;
        long startdate = System.currentTimeMillis();
        long enddate = 0;
        try {
            FileReader file = new FileReader(path);
            LineNumberReader lineNumberReader = new LineNumberReader(file);
            lineNumberReader.skip(Long.MAX_VALUE);
            index = lineNumberReader.getLineNumber();
            enddate = System.currentTimeMillis();
            lineNumberReader.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return index+"("+(enddate-startdate)/1000+"秒)";
    }
}
