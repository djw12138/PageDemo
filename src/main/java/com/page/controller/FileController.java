package com.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/fileController")
public class FileController {

    private static final String FILE_PATH="E:/test/fileUpload";

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
}
