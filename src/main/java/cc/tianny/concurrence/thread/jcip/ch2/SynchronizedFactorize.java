package cc.tianny.concurrence.thread.jcip.ch2;

import cc.tianny.concurrence.thread.jcip.annotations.GuardedBy;
import cc.tianny.concurrence.thread.jcip.annotations.NotRecommend;
import cc.tianny.concurrence.thread.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 2:25 下午
 * Description: 在同一时刻只有一个线程可以执行 server 方法。
 * 现在的 SynchronizedFactorize 是线程安全的。
 * 然而，这种方法却过于极端，因为多个客户端无法同时使用因数分解 Servlet ，服务的响应性非常低，无法令人接受。
 * 这是个性能问题，而不是线程安全问题，将在 2.5 节解决
 */
@ThreadSafe
@NotRecommend
public class SynchronizedFactorize extends GenericServlet implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;


    @Override
    public synchronized void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(res, lastFactors);
        } else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(res, factors);
        }
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

