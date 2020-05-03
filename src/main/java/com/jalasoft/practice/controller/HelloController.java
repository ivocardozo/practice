package com.jalasoft.practice.controller;

//import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
//import org.apache.tomcat.jni.File;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String sayHello(
            @RequestParam(value="name") String name,
            @RequestParam("imageFile") MultipartFile imageFile) {
        System.out.println("Testing WebService");

        StoreFile(imageFile);

        return "Hello " + imageFile.getName();
    }
    private void StoreFile(MultipartFile file) {
        try{
            String targetFolder = "../../../inputFiles/";
            byte[] bytes = file.getBytes();

            Path filePath = Paths.get(file.getOriginalFilename());
            Files.write(filePath, bytes);
        }
        catch (Exception e)
        {

        }

    }
}
