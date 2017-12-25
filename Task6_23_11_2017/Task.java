package com.company.Task6_23_11_2017;

import java.io.IOException;
import java.util.*;

public class Task {

    public static ArrayList<String> choose20URL(WebPage page){
        ArrayList<String> allURL = page.findURLaddresses();
        ArrayList<String> result = new ArrayList<String>();
        for(String url : allURL) {
            try {
                WebPage myPage = new WebPage(url);
                result.add(url);
                if(result.size()==20)
                    break;
            } catch (IOException e) {}
        }
        return result;
    }

    public static Map<WebPage,Integer> findFrequentlyURL(WebPage page,String key) throws IOException {
        List<WebPage> pages = new ArrayList<WebPage>();
        ArrayList<String> top20pages = choose20URL(page);
        Map<WebPage,Integer> freq = new HashMap<WebPage,Integer>();
        for(String URL:top20pages){
            WebPage myPage = new WebPage(URL);
            Integer frequency = myPage.getFrequency().get(key);
            if(frequency!= null)
                freq.put(myPage,frequency);
            else {
                freq.put(myPage, 0);
            }
        }
        return sortByValue(freq);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (-1)*(o1.getValue()).compareTo( o2.getValue() );
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
