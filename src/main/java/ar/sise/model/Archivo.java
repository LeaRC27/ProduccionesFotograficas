/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.model;

/**
 *
 * @author LeaRC
 */
public class Archivo {
    
    String fileName="";
    String fileSize="";
    String fileType="";
    private byte bytes[]=null;

    public Archivo() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Archivo{" + "fileName=" + fileName + ", fileSize=" + fileSize + ", fileType=" + fileType + ", bytes=" + bytes + '}';
    }

}
