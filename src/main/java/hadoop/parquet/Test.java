package hadoop.parquet;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.GroupFactory;
import org.apache.parquet.example.data.simple.SimpleGroup;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.apache.parquet.schema.GroupType;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2022/06/28
 */
public class Test {


  private static String schemaStr = "message schema {"
      + "required int64 log_id;"
      + "required binary idc_id;"
      + "}";
  static MessageType schema = MessageTypeParser.parseMessageType(schemaStr);

  static Configuration configuration = new Configuration();

  public static void main(String[] args) throws Exception {
    //readParquet("/Users/edy/Desktop/test_data/read/parquet/parquet-1");

    write();

  }


  private static void write() throws Exception {

    String outPath = "/Users/edy/Desktop/test_data/out/parquet/3";
    String[] access_log = {"111111", "22222"};

    GroupFactory factory = new SimpleGroupFactory(schema);
    Path path = new Path(outPath);
    GroupWriteSupport writeSupport = new GroupWriteSupport();
    writeSupport.setSchema(schema, configuration);
    ParquetWriter<Group> writer = new ParquetWriter<Group>(path, configuration, writeSupport);

    for (int i = 0; i < 1000; i++) {
      System.out.println(i + "=i");

      writer.write(factory.newGroup()
          .append("log_id", Long.parseLong(access_log[0]))
          .append("idc_id", access_log[1]));


    }
    writer.close();

  }


  private static void readParquet(String filePath) throws Exception {
    Path file = new Path(filePath);
    ParquetReader.Builder<Group> builder = ParquetReader.builder(new GroupReadSupport(), file);
    ParquetReader<Group> reader = builder.build();
    SimpleGroup group = null;
    GroupType groupType = null;
    int count = 0;
    while ((group = (SimpleGroup) reader.read()) != null) {
      if (groupType == null) {
        groupType = group.getType();
      }
      if (count < 100) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < groupType.getFieldCount(); i++) {
          String tmpName = groupType.getFieldName(i);
          try {
            String tmp = group.getValueToString(i, 0);
            System.out.println(tmpName + ":" + tmp);
          } catch (Exception e) {
            System.out.println(tmpName + ":" + "");
          }
        }
        count++;
      }
    }
  }


}
