package com.example.dharmendraverma.imageloader.dataobject;

import com.example.dharmendraverma.imageloader.utils.Utils;

/**
 * Created by dharmendraverma on 16/07/18.
 */

public class Feed {

    public static final String LOAD_MORE_OBJ_TYPE = "load_more_obj_type";

    private String adObjType;
    private Photo photo;
    private String mImageUrl;

    public String getObjType() {
        return adObjType;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        mImageUrl = Utils.buildImageUrl(photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public Photo getPhoto() {
        return photo;
    }
}
