package hadoop.orc;



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

public class WriteOrc {

  public static void main(String [ ] args) throws java.io.IOException
  {
    Configuration conf = new Configuration();
    TypeDescription schema = TypeDescription.createStruct()
        .addField("long_value", TypeDescription.createLong())
        .addField("double_value", TypeDescription.createDouble())
        .addField("boolean_value", TypeDescription.createBoolean())
        .addField("string_value", TypeDescription.createString());

    Writer writer = OrcFile.createWriter(new Path("/Users/edy/git/java_demo/spark-my-file.orc"),
        OrcFile.writerOptions(conf)
            .setSchema(schema));


    VectorizedRowBatch batch = schema.createRowBatch();
    LongColumnVector longVector = (LongColumnVector) batch.cols[0];
    DoubleColumnVector doubleVector = (DoubleColumnVector) batch.cols[1];
    LongColumnVector booleanVector = (LongColumnVector) batch.cols[2];
    BytesColumnVector stringVector = (BytesColumnVector) batch.cols[3];


    for(int r=0; r < 2000; ++r) {
      int row = batch.size++;

      longVector.vector[row] = r;
      doubleVector.vector[row] = r;
      booleanVector.vector[row] =  r< 50000 ? 1 : 0;
      stringVector.setVal(row, UUID.randomUUID().toString().getBytes());

      if (batch.size == batch.getMaxSize()) {
        writer.addRowBatch(batch);
        batch.reset();
      }
    }
    if (batch.size != 0) {
      writer.addRowBatch(batch);
      batch.reset();
    }
    writer.close();
  }


}

