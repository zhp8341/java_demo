package hadoop.orc;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.DoubleColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.hadoop.hive.ql.io.sarg.PredicateLeaf;
import org.apache.hadoop.hive.ql.io.sarg.SearchArgumentFactory;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.RecordReader;
import org.apache.orc.TypeDescription;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2022/06/28
 */
public class ReadOrc {
  public static void main(String [ ] args) throws java.io.IOException
  {
    Configuration conf = new Configuration();

    TypeDescription readSchema = TypeDescription.createStruct()
        .addField("long_value", TypeDescription.createLong())
        .addField("double_value", TypeDescription.createDouble())
        .addField("boolean_value", TypeDescription.createBoolean())
        .addField("string_value", TypeDescription.createString());


    Reader reader = OrcFile.createReader(new Path("my-file.orc"),
        OrcFile.readerOptions(conf));

    Reader.Options readerOptions = new Reader.Options(conf)
        .searchArgument(
            SearchArgumentFactory
                .newBuilder()
                .between("long_value", PredicateLeaf.Type.LONG, 0L,1024L)
                .build(),
            new String[]{"long_value"}
        );

    RecordReader rows = reader.rows(readerOptions.schema(readSchema));

    VectorizedRowBatch batch = readSchema.createRowBatch();
    int j=0;
    while (rows.nextBatch(batch)) {

      LongColumnVector longVector = (LongColumnVector) batch.cols[0];
      DoubleColumnVector doubleVector  = (DoubleColumnVector) batch.cols[1];
      LongColumnVector booleanVector = (LongColumnVector) batch.cols[2];
      BytesColumnVector stringVector = (BytesColumnVector)  batch.cols[3];


      for(int r=0; r < batch.size; r++) {
        long longValue = longVector.vector[r];
        double doubleValue = doubleVector.vector[r];
        boolean boolValue = booleanVector.vector[r] != 0;
        String stringValue = stringVector.toString(r);

        System.out.println(j+","+longValue + ", " + doubleValue + ", " + boolValue + ", " + stringValue);
        j++;
      }

    }
    rows.close();
  }
}
