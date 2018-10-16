package cn.peter.compare;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Yu 2018/10/10 11:48
 */
public class FileContentCompare {

    public static void main(String[] args) {
        showDiff();
    }

    private static void showDiff() {
        Map<String, Integer> diffMap = loadFile(new File("D:\\diff.txt"));
        Map<String, Integer> recordMap = loadFile(new File("D:\\record.txt"));
        doubledFile(recordMap);
        notInRecord(diffMap, recordMap);
        notInDiff(diffMap, recordMap);
    }

    private static void doubledFile(Map<String,Integer> recordMap) {
        for (Map.Entry<String, Integer> entry : recordMap.entrySet()) {
            String file = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) {
                System.out.println("=====================");
                System.out.println("重复的类："+file);
            }
        }
    }

    private static void notInDiff(Map<String, Integer> diffMap, Map<String, Integer> recordMap) {
        System.out.println("============================");
        System.out.println("diff.txt里面没有的:");
        int i = 0;
        for (String file : recordMap.keySet()) {
            if (!diffMap.containsKey(file)) {
                System.out.println(i + " : " + file);
                i++;
            }
        }
    }

    private static void notInRecord(Map<String, Integer> diffMap, Map<String, Integer> recordMap) {
        System.out.println("============================");
        System.out.println("record.txt里面没有的:");
        int i = 0;
        for (String file : diffMap.keySet()) {
            if (!recordMap.containsKey(file)) {
                System.out.println(i + " : " + file);
                i++;
            }
        }
    }

    private static Map<String, Integer> loadFile(File file) {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String buf = null;
            while ((buf = br.readLine()) != null) {
                buf = trim(buf);
                mapAggregate(map, buf);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    private static void mapAggregate(Map<String, Integer> map, String buf) {
        if (map.containsKey(buf)) {
            Integer integer = map.get(buf);
            map.put(buf, integer + 1);
        } else {
            map.put(buf, 1);
        }
    }

    private static String trim(String buf) {
        return buf.replaceFirst(" diff result fileName: b/", "");
    }
}
