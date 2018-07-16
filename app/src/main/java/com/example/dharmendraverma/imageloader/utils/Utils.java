package com.example.dharmendraverma.imageloader.utils;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dharmendraverma on 16/07/18.
 */

public class Utils {

    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }

    private final static String FLICK_IMAGE_EXTENSION = ".jpg";

    //    To load the photo, you can build the full URL following this pattern:
//    http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg
//    Thus, using our Flickr photo model example above, the full URL would be:
//    http://farm1.static.flickr.com/578/23451156376_8983a8ebc7.jpg
    public static String buildImageUrl(String farmNumber, String server, String id, String secret) {

        String url = "http://farm" + farmNumber +
                ".static.flickr.com/" +
                server +
                "/" +
                id +
                "_" +
                secret +
                FLICK_IMAGE_EXTENSION;
        return url;
    }

    public static String buildImageUrl(int farmNumber, String server, String id, String secret) {

        String url = "http://farm" + farmNumber +
                ".static.flickr.com/" +
                server +
                "/" +
                id +
                "_" +
                secret +
                FLICK_IMAGE_EXTENSION;
        return url;
    }

    public static String buildSearchApiUrl(String query) {
        String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1&safe_search=1&text=";
        url += query;
        return url;

    }
}
