package com.automation.resources;

import com.automation.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Resources extends SpringBaseTestNGTest {

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource sourceFile;
    @Value("${screenshot.path}")
    private String path;

    @Test
    public void resourceTest() throws IOException {
        FileCopyUtils.copy(sourceFile.getInputStream(), Files.newOutputStream(Path.of(path + "/new.txt")));
       System.out.println("Path print: "+path);
    }


}
