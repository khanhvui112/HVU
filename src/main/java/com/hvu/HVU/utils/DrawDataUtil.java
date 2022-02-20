package com.hvu.HVU.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DrawDataUtil {

    public static List<String> loopDataDraw(List<String> list,int n, String url) {
        for (int i= 1; i < n; i ++){
            String urlBuild = url + i +".hvu";
            list.add(urlBuild);
        }
        return list;
    }

    public static Document buildDoc(String url) throws IOException{
        return Jsoup.connect(url).get();
    }

    public static Elements buildElements(Document docs,String fill) {
        return docs.select(fill);
    }

    public static Iterator buildIterators(Elements elements) {
        return elements.iterator();
    }

    public static boolean isStringUpperCase(String str){

        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is not in upper case, return false
            if( Character.isLowerCase( charArray[i] ))
                return false;
        }

        return true;
    }

}
