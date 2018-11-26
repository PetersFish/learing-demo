package cn.peter.lombok;

import lombok.Builder;
import lombok.Data;

/**
 * @author Peter Yu 2018/11/13 16:34
 */
@Data
@Builder
public class Student {

    private String name;

    private String clazz;
}
