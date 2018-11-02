package cn.peter.extend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Peter Yu 2018/10/29 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {

    private String  name;
    private Integer age;
}
