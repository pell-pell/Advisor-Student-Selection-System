package com.selection.controller;
import com.selection.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传kong'zhi'c1
 */
@Controller
@RequestMapping("/api/upload")
public class UploadController {

    private String UPLOAD_WINDOW="D:/image/";
    private String UPLOAD_LINUX="/home/image/";


    /***
     * 上传文件
     * @param files
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploads")
    @ResponseBody
    public Result uploads(@RequestParam("files") MultipartFile files, HttpServletRequest request){
        try {
            byte[] bytes = files.getBytes();
            String UPLOAD_FOLDER;
            //若当前系统是window系统
            if(System.getProperty("os.name").toLowerCase().contains("windows")) {
                UPLOAD_FOLDER = UPLOAD_WINDOW;
            }else{
                //若当前系统是linux系统
                UPLOAD_FOLDER = UPLOAD_LINUX;
            }
            String filename=getFilename(files.getOriginalFilename());
            Path path = Paths.get(UPLOAD_FOLDER + File.separator +filename);
            String url = "/" +filename;
            //如果没有此文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            //若上传成功
            return  Result.reOk("上传成功",url);
        } catch (IOException ex) {
            return  Result.reError("上传失败，系统异常");
        }

    }


    /**
     * 设置文件名,防止相同文件名冲突
     * 原名称+时间(年月日)+后缀
     * @param originalFilename 原名称
     * @return string
     */
    private String getFilename(String originalFilename) {
        //后缀名  如 .txt
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //后缀名之前的名称
        String prefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 将此时时间转换为字符串
        String formatDate = format.format(new Date());
        // 拼接文件名
        String filename = new StringBuffer().append(prefix).append("_").append(formatDate).append(suffix).toString();
        return filename;
    }


    @RequestMapping("/getImage")
    @ResponseBody
    public void getImage(String filePath, HttpServletResponse rp) {
        File imageFile = new File(UPLOAD_WINDOW+filePath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //模拟文件，myfile.txt为需要下载的文件
        String fileName =UPLOAD_WINDOW+"/"+filename;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        // String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

}
