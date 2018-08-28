package cn.peter.auto;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Peter Yu
 * @date 2018/6/19 11:30
 */
public class CompareUtils {

    private CompareUtils(){}

    public static Set<String> getCxxPluginRules() throws DocumentException {
        HashSet<String> ruleNames = new HashSet<>();
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = CompareUtils.class.getResourceAsStream("/cppcheck.xml");
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> ruleElements = rootElement.elements("rule");
        for (Element ruleElement : ruleElements) {
            Element element = ruleElement.element("key");
            if (element != null) {
                String key = element.getStringValue();
                ruleNames.add(key.toLowerCase());
            }
        }
        return ruleNames;
    }

    public static Set<String> getErrorlistRules() throws DocumentException {
        HashSet<String> ruleNames = new HashSet<>();
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = CompareUtils.class.getResourceAsStream("/errorlist1_83.xml");
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> ruleElements = rootElement.element("errors").elements("error");
        for (Element ruleElement : ruleElements) {
            String key = ruleElement.attribute("id").getStringValue();
            ruleNames.add(key.toLowerCase());
        }
        return ruleNames;
    }

    public static void main(String[] args) throws DocumentException {
        Set<String> cxxPluginRules = getCxxPluginRules();
        Set<String> errorlistRules = getErrorlistRules();
        for (String errorlistRule : errorlistRules) {
            if(!cxxPluginRules.contains(errorlistRule)){
                System.out.println(errorlistRule);
            }
        }
        System.out.println("===========");
        for (String cxxPluginRule : cxxPluginRules) {
            if(!errorlistRules.contains(cxxPluginRule)){
                System.out.println(cxxPluginRule);
            }
        }
        System.out.println("===========");
    }
}
