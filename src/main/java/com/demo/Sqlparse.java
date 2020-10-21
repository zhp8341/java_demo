package com.demo;


import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-17
 * @time 10:42
 */
public class Sqlparse {

    public static void main(String[] args) {

        // String sql = "update t set name = 'x' where id < 100 limit 10";
        // String sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ? limit 2";
        //String sql = "select * from tablename limit 10";

//       String sql = "select user as t from tablename";
//        String dbType = JdbcConstants.MYSQL;
//
//        //格式化输出
//        String result = SQLUtils.format(sql, dbType);
//        System.out.println(result); // 缺省大写格式
//        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
//
//        //解析出的独立语句的个数
//        System.out.println("size is:" + stmtList.size());
//        for (int i = 0; i < stmtList.size(); i++) {
//
//            SQLStatement stmt = stmtList.get(i);
//            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
//            stmt.accept(visitor);
//
//            //获取字段名称
//             System.out.println("fields : " + visitor.getColumns());
//        }



       // String sql = "select id,name from user";
        String sql = " SELECT * FROM t_blog LEFT JOIN t_type ON t_blog.typeId=t_type.id";

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement statement = parser.parseStatement();

        // 使用visitor来访问AST
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);

        // 从visitor中拿出你所关注的信息
        System.out.println(visitor.getColumns());


    }
}
