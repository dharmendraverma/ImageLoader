package com.example.dharmendraverma.imageloader.utils;

import android.content.Context;

import java.io.File;

public class FileCache {

    private File cacheDir;
    private static  final String FILE_PATH ="/uber";

    FileCache(Context context){

        cacheDir= new File(context.getFilesDir() + FILE_PATH);

        if(!cacheDir.exists())
            cacheDir.mkdirs();
    }

    /**
     * @param uid is the unique identifier for each photo;
     *            on disk wwe save file via name as uid
     * @return
     */
    public File getFile(String uid){
        File f = new File(cacheDir, uid);
        return f;

    }

    public void clear(){
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }

}