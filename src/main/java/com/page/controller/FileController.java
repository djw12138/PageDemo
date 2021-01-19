package com.page.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

@Controller
@RequestMapping("/fileController")
public class FileController {

    private static final String FILE_PATH="E:/test/fileUpload/";

    @RequestMapping ( "/upload" )
    @ResponseBody
    public String  springUpload(HttpServletRequest request)  throws  IllegalStateException, IOException
    {
        long   startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver= new  CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while (iter.hasNext())
            {

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if (file!= null )
                {
                    String path= FILE_PATH +file.getOriginalFilename();
                    //上传
                    file.transferTo( new File(path));
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println( "Spring方法的运行时间：" +String.valueOf(endTime-startTime)+ "ms" );
        return  "/success" ;
    }

    /**
     * @Author dai jiawei
     * @Description 上传并压缩文件
     * @Date 2021/1/19 15:24
     * @param file
     * @Return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping (method = RequestMethod.POST,path = "/uploadCompress" )
    @ResponseBody
    public JSONObject uploadCompress(@RequestPart("file") MultipartFile file) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
        byte[] bytes = commpressPicCycle(file.getBytes(),1024,0.8);;
        InputStream inputStream = new ByteArrayInputStream(bytes);
        MultipartFile mfileInfos = new MockMultipartFile(file.getOriginalFilename(), file.getOriginalFilename(), file.getContentType(), inputStream);

        File newFile = new File(FILE_PATH + file.getOriginalFilename());

            mfileInfos.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        return result;
    }

    /**
     * 根据指定大小和指定精度压缩图片
     *
     * @param srcPath
     *            源图片地址
     * @param desPath
     *            目标图片地址
     * @param desFileSize
     *            指定图片大小，单位kb
     * @param accuracy
     *            精度，递归压缩的比率，建议小于0.9
     *  @param desMaxWidth
     *             目标最大宽度
     *  @param desMaxHeight
     *             目标最大高度
     * @return 目标文件路径
     */
    public static String commpressPicForScale(String srcPath, String desPath,
                                              long desFileSize, double accuracy,int desMaxWidth,int desMaxHeight) {
        if (StringUtils.isEmpty(srcPath) || StringUtils.isEmpty(srcPath)) {
            return null;
        }
        if (!new File(srcPath).exists()) {
            return null;
        }
        try {
            File srcFile = new File(srcPath);
            long srcFileSize = srcFile.length();
            System.out.println("源图片：" + srcPath + "，大小：" + srcFileSize / 1024
                    + "kb");
            //获取图片信息
            BufferedImage bim = ImageIO.read(srcFile);
            int srcWidth = bim.getWidth();
            int srcHeight = bim.getHeight();

            //先转换成jpg
            Thumbnails.Builder builder = Thumbnails.of(srcFile).outputFormat("jpg");

            // 指定大小（宽或高超出会才会被缩放）
            if(srcWidth > desMaxWidth || srcHeight > desMaxHeight) {
                builder.size(desMaxWidth, desMaxHeight);
            }else{
                //宽高均小，指定原大小
                builder.size(srcWidth,srcHeight);
            }

            // 写入到内存
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
            builder.toOutputStream(baos);

            // 递归压缩，直到目标文件大小小于desFileSize
            byte[] bytes = commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);

            // 输出到文件
            File desFile = new File(desPath);
            FileOutputStream fos = new FileOutputStream(desFile);
            fos.write(bytes);
            fos.close();

            System.out.println("目标图片：" + desPath + "，大小" + desFile.length() / 1024 + "kb");
            System.out.println("图片压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return desPath;
    }

    private static byte[] commpressPicCycle(byte[] bytes, long desFileSize, double accuracy) throws IOException {
        // File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = bytes.length;
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return bytes;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(
                new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(
                new BigDecimal(accuracy)).intValue();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //字节输出流（写入到内存）
        Thumbnails.of(new ByteArrayInputStream(bytes)).size(desWidth, desHeight).outputQuality(accuracy).toOutputStream(baos);
        return commpressPicCycle(baos.toByteArray(), desFileSize, accuracy);
    }

}
