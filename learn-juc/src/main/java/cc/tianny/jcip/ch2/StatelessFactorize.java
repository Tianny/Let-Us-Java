package cc.tianny.jcip.ch2;

import cc.tianny.jcip.annotations.ThreadSafe;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 11:11 上午
 * Description:
 * 引自原文：
 * 与大多数 Servlet 相同， StatelessFactorize  是无状态的：它既不包含任何域，也不包含任何对其他类中域的引用。计算过程中的临时状态仅存在于
 * 线程栈上的局部变量中，井且只能由正在执行的线程访问。
 * 访问 StatelessFactorize 的线程不会影响另一个访问同一个 StatelessFactorize 的线程的计算结果，因为这两个线程并没有共享状态，就好像它们都在访问不同的实例。
 * 由于线程访问无状态对象的行为并不会影响其他线程中操作的正确性，因此无状态对象是线程安全的。
 * 无状态对象一定是线程安全的。
 */

/*
 *  StatelessFactorize
 *  A stateless servlet
 */
@ThreadSafe
public class StatelessFactorize extends GenericServlet implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
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