package regex;

import java.util.regex.Pattern;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2021/4/2
 * @time 16:53
 */
public class RegexExample1 {


    final static String pattern_s = "this\\s+text";
    final static String pattern_xin = "this*";
    final static String pattern_xin_2 = "output_data_\\d.*";

    public static void main(String[] args){
        String content = "output_data_202108112059562468_hetero_feature_fc_0";
        boolean isMatch = Pattern.matches(pattern_xin_2, content);
        System.out.println(isMatch);
    }
}
