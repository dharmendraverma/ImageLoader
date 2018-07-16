
package com.example.dharmendraverma.imageloader.dataobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiSearchData {
    private Photos photos;
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
