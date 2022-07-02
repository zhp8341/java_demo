package hadoop;


import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.GroupFactory;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;

/*
 *
 * @author zhuhuipei
 * @Description:
 * @date 2022/06/27
 */
public class WriterParquet {


//  private static String schemaStr = "message schema {"
//      + "optional int32 id;"
//      + "optional int32 bad;" +
//      "}";

  /*
   *每一个字段有三个属性：重复数、数据类型和字段名，重复数可以是以下三种：
   *   required(出现1次)
   * repeated(出现0次或多次)
   * optional(出现0次或1次)
   * 数据类型有
   *  INT64, INT32, BOOLEAN, BINARY, FLOAT, DOUBLE, INT96, FIXED_LEN_BYTE_ARRAY
   */
  private static String schemaStr = "message schema {"
      +  "required int64 log_id;"
      + "required binary idc_id;" + "required int64 house_id;"
      + "required int64 src_ip_long;" + "required int64 dest_ip_long;"
      + "required int64 src_port;" + "required int64 dest_port;"
      + "required int32 protocol_type;" + "required binary url64;"
      + "required binary access_time;}";
  static MessageType schema = MessageTypeParser.parseMessageType(schemaStr);


  public static void main(String[] args) throws Exception {

    GroupFactory factory = new SimpleGroupFactory(schema);
    Path path = new Path("/Users/edy/Desktop/test_data/out/parquet/1");
    Configuration configuration = new Configuration();
    GroupWriteSupport writeSupport = new GroupWriteSupport();
    writeSupport.setSchema(schema, configuration);
    ParquetWriter<Group> writer = new ParquetWriter<Group>(path, configuration, writeSupport);

   // Group groupFactory = factory.newGroup();
//    for(int i=0;i<100;i++){
//      writer.write(groupFactory
//          .append("id", i)
//          .append("bad", i));
//    }

    String[] access_log = {"111111", "22222", "33333", "44444", "55555",
        "666666", "777777", "888888", "999999", "101010"};
    for (int i = 0; i < 1000; i++) {
      System.out.println(i+"=i");

      writer.write(factory.newGroup()
          .append("log_id", Long.parseLong(access_log[0]))
          .append("idc_id", access_log[1])
          .append("house_id", Long.parseLong(access_log[2]))
          .append("src_ip_long", Long.parseLong(access_log[3]))
          .append("dest_ip_long", Long.parseLong(access_log[4]))
          .append("src_port", Long.parseLong(access_log[5]))
          .append("dest_port", Long.parseLong(access_log[6]))
          .append("protocol_type", Integer.parseInt(access_log[7]))
          .append("url64", access_log[8])
          .append("access_time", access_log[9]));


    }
    writer.close();

  }

}
