package cn.peter.compare;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Peter Yu 2018/12/5 15:34
 */
public class RuleCompare {

    public static void showDiff() throws DocumentException, IOException {
        Map<String, Integer> newRules = fetchRules(new File("D:\\messages_new.xml"));
        Map<String, Integer> oldRules = fetchRules(new File("D:\\messages_old.xml"));
        for (String rule : newRules.keySet()) {
            if (!oldRules.containsKey(rule)) {
                System.out.println("new rule: "+rule);
            }
        }
    }

    private static Map<String, Integer> sonarPmd(File file) throws IOException {
        Map<String, Integer> rules = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String buffer;
        while ((buffer = reader.readLine())!=null){
            if (StringUtils.isNotBlank(buffer)) {
                putToMap(rules, buffer);
            }
        }
        return rules;
    }

    private static void putToMap(Map<String, Integer> rules, String buffer) {
        String[] split = buffer.split("\\.");
        buffer = split[2];
        if (rules.containsKey(buffer)) {
            rules.put(buffer, rules.get(buffer) + 1);
        } else {
            rules.put(buffer, 1);
        }
    }

    private static Map<String, Integer> fetchRules(File file) throws DocumentException {

        Map<String, Integer> rules = new HashMap<>();

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element rootElement = document.getRootElement();
//        Element properties = rootElement.element("properties");
        for (Iterator<Element> it = rootElement.elementIterator("entry");it.hasNext();){
            Element element = it.next();
            String key = element.attribute("key").getValue();
            putToMap(rules, key);
        }
        return rules;
    }

    public static void main(String[] args) throws DocumentException, IOException {
        showDiff();
    }
}
