package cc.tianny.jcip.ch2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 2:01 下午
 * Description:
 *  假设我们希望提升 Servlet 的性能：将最近的计算结果缓存起来，当两个连续的请求对相同的数值进行因数分解时
 *  可以直接使用上一次的计算结果，而无须重新计算。（这并非一种有效的缓存策略， 5.6 节将给出一种更好的策略。）
 *  要实现该缓存策略，需要保存两个状态。
 *  最近执行因数分解的数值(lastNumber)，以及分解结果(lastFactors)。
 *  尽管对 set 方法的每次调用都是原子的，但仍然无法同时更新 lastNumber和lastFactors.
 */
public class UnsafeCachingFactorize extends GenericServlet implements Servlet {
    // AtomicReference 是一种替代对象引用的线程安全类
    private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<>();


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(res, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            /*
             1. 如果只修改了其中一个变量，那么在这两次修改操作之间，
             其他线程将发现不变性条件被破坏了
             2. 我们也不能保证会同时获取两个值:线程 A 获取这两个值的
             过程中，线程 B 可能修改了它们，这样线程 A 也会发现不变性
             条件被破坏了
             */
            lastNumber.set(i);
            lastFactors.set(factors);
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