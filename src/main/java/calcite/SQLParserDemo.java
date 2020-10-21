package calcite;

import org.apache.calcite.avatica.util.Casing;
import org.apache.calcite.avatica.util.Quoting;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.impl.SqlParserImpl;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-10-20
 * @time 10:33
 */
public class SQLParserDemo {

    public static void main(String[] args){

        SchemaPlus rootSchema = Frameworks.createRootSchema(true);
        final FrameworkConfig config = Frameworks.newConfigBuilder()
                .parserConfig(SqlParser.configBuilder()
                        .setParserFactory(SqlParserImpl.FACTORY)
                        .setCaseSensitive(false)
                        .setQuoting(Quoting.BACK_TICK)
                        .setQuotedCasing(Casing.TO_UPPER)
                        .setUnquotedCasing(Casing.TO_UPPER)
                        .setConformance(SqlConformanceEnum.ORACLE_12)
                        .build())
                .build();

//        String sql = "INSERT INTO tmp_node\n" +
//                "SELECT s1.id1, s1.id2, s2.val1\n" +
//                "FROM source1 as s1 INNER JOIN source2 AS s2\n" +
//                "ON s1.id1 = s2.id1 and s1.id2 = s2.id2 where s1.val1 > 5 and s2.val2 = 3";


        String sql = "create function " +
                "hr.custom_function as 'com.github.quxiucheng.calcite.func.CustomFunction' " +
                "method 'eval'  " +
                "property ('a'='b','c'='1') ";

        SqlParser parser = SqlParser.create(sql, config.getParserConfig());
        try {
            SqlNode sqlNode = parser.parseStmt();
            System.out.println(sqlNode.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
