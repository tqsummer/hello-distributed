package com.study.hello.distributed.mybatis.demo.test;

import com.study.hello.distributed.mybatis.demo.HelloMybatisDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootTest(classes = HelloMybatisDemoApplication.class)
@ActiveProfiles("test")
public class DmJdbcTest {
    @Test
    public void testQuerySql() {
// 数据库连接信息
        String url = "jdbc:dm://192.168.31.3:5236";
        String user = "SYSDBA";
        String password = "SYSDBA001";

        // 修改 SQL 查询，使用 DM8 的字符串函数
        String[] traceIds = {"GW.Hgcf3drs", "GW.u74lsO0y"};
        String traceIdList = Arrays.stream(traceIds)
                                   .map(id -> "'" + id.replace("'", "''") + "'")
                                   .collect(Collectors.joining(","));

        Long[] ids = {1834068155457003521L, 1834494230224261122L, 3L, 4L};
        String idList = Arrays.stream(ids)
                .map(Object::toString)
                .collect(Collectors.joining(","));

        String sql = "SELECT * FROM BC_AUDIT_LOG WHERE trace_id IN (" + traceIdList + ")" +" and id in (" + idList + ")";

        System.out.println(sql);
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // 执行查询
            ResultSet rs = stmt.executeQuery(sql);

            // 处理结果集
            while (rs.next()) {
                // 假设 BC_AUDIT_LOG 表有一个名为 id 的列
                String result = rs.getString("id");
                System.out.println("Query Result: " + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
