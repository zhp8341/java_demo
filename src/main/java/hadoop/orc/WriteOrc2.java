package hadoop.orc;



import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.orc.OrcFile;
import org.apache.orc.TypeDescription;
import org.apache.orc.Writer;

public class WriteOrc2 {

  public static void main(String [ ] args) throws java.io.IOException
  {
    Configuration conf = new Configuration();
    TypeDescription schema = TypeDescription.createStruct()
        .addField("id", TypeDescription.createString())
        .addField("name", TypeDescription.createString());

    Writer writer = OrcFile.createWriter(new Path("/Users/edy/Desktop/test_data/my-file.orc"),
        OrcFile.writerOptions(conf)
            .setSchema(schema));


    VectorizedRowBatch batch = schema.createRowBatch(1000000);
    BytesColumnVector id = (BytesColumnVector) batch.cols[0];
    BytesColumnVector name = (BytesColumnVector) batch.cols[1];


    String fileName = "/Users/edy/Desktop/test_data/party10000000";

    try (Scanner sc = new Scanner(new FileReader(fileName))) {
      while (sc.hasNextLine()) {  //按行读取字符串
        String[] line = sc.nextLine().split(",");
        int row = batch.size++;

        id.setVal(row,line[0].getBytes(StandardCharsets.UTF_8));
        name.setVal(row, line[1].getBytes(StandardCharsets.UTF_8));

        if (batch.size == batch.getMaxSize()) {
          System.out.println("batch.size1="+batch.size);
          writer.addRowBatch(batch);
          batch.reset();
        }
      }
    }

    System.out.println("batch.size2=="+batch.size);
    if (batch.size != 0) {
      writer.addRowBatch(batch);
      batch.reset();
    }
    writer.close();
    try {
      Thread.sleep(10000000000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }



}

