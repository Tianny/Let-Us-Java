package cc.tianny.concurrence.thread.jcip.ch2;

import cc.tianny.concurrence.thread.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 11:41 上午
 * Description:
 * 存在竞态条件
 * 读取 - 修改 - 写入
 * 竞态条件并不总是会产生错误，还需要某种不恰当的执行时序
 */


@ThreadSafe
public class UnsafeCountingFactorize extends GenericServlet implements Servlet {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
