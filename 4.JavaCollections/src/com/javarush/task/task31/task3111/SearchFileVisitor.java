package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    List<Boolean> flags = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize = Integer.MAX_VALUE;
    private int maxSize = 0;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        flags.add(true);
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        flags.add(true);
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        flags.add(true);
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        flags.add(true);
    }



    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentString = new String(Files.readAllBytes(file));

        //System.out.println(contentString);
        if (flags.size()==4){
            if((file.getFileName().toString().contains(partOfName))&(contentString.contains(partOfContent))&(content.length>minSize)&(content.length<maxSize)){
                foundFiles.add(file);
            }
        } else if((partOfName!=null)&&file.getFileName().toString().contains(partOfName)){
            foundFiles.add(file);
        } else if ((partOfContent!=null)&&(contentString.contains(partOfContent))){
            foundFiles.add(file);
        } else if ((content.length>minSize)){
            foundFiles.add(file);
        } else if ((content.length<maxSize)){
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
