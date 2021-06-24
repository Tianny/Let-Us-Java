package cc.tianny.jcip.ch3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/6
 * Time: 6:40 下午
 * Description: 使用 ThreadLocal 来维持线程封闭性
 *  由于 JDBC 的连接对象不一定是线程安全的，因此，当多个
 *  线程应用程序在没有协同的情况下使用全局变量时，就不是
 *  线程安全的，通过将 JDBC 的连接保存到 ThreadLocal 对象
 *  中，每个线程都会拥有属于自己的连接
 */
public class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private ThreadLocal<Connection> connectionHolder
            = new ThreadLocal() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection, e");
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
