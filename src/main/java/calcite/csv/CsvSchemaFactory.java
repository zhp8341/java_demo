package calcite.csv;

import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.util.Map;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-10-20
 * @time 10:48
 */

public class CsvSchemaFactory implements SchemaFactory {

    /**
     * parentSchema 他的父节点，一般为root
     * name     数据库的名字，它在model中定义的
     * operand  也是在mode中定义的，是Map类型，用于传入自定义参数。
     * */
    @Override
    public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
        return new CsvSchema(String.valueOf(operand.get("dataFile")));
    }
}
