package com.practice.designPattern.bridge;

/**
 * Created by vyast3 on 10/16/15.
 */

/**
 * "Implementor"
 */
public interface FileDownloadImplementor {

    public Object downloadFile(String path);

    public boolean storeFile(Object object);

    public boolean delete(String object);
}
