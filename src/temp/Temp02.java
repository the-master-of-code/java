package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Temp02 {
    //https://www.cnblogs.com/mufengforward/p/9485425.html
    private static final String TEMP_DIR = "D:\\unZipTemp";

    public Temp02(String filepath) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipEntry zipEntry ;
        try {
            while(( zipEntry = zipInputStream.getNextEntry())!=null){
                zipEntry.getName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createDirectory(String outputDir,String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))){//子目录不为空
            file = new File(outputDir + "/" + subDir);
//            file = new File(outputDir + "\\" + subDir);
        }
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file.mkdirs();
            System.out.println("文件夹创建完成");
        }else {
            System.out.println("文件夹已存在");
        }
    }



    public void makeDir(String path){

    }
    private void unZip(String filepath,String outputpath) {

    }

    public static void main(String[] args){
        createDirectory(TEMP_DIR,null);
    }
}
