package cc.tianny.concurrence.thread.jcip.ch2;

import cc.tianny.concurrence.thread.jcip.annotations.GuardedBy;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 3:30 下午
 * Description:
 *  重新构造后的 CachedFactorize 实现了在简单性（对整个方法进行同步）与并发性（对尽可能短的代码路径进行同步）之间的平衡。
 *  在获取与释放锁等操作上都需要一定的开销，因此如果将同步代码块分解得过细（例如将 ++hits 分解到它自己的同步代码块中〉，
 *  那么通常并不好，尽管这样做不破坏原子姓。当访问状态变量或者在复合操作的执行期间，
 *  CachedFactorize 需要持有锁，但在执行时间较长的因数分解运算之前要释放锁。这样既确保
 *  了钱程安全性，也不会过多地影响并发性，而且在每个问步代码块中的代码路径都"足够短"。
 */
public class CachedFactorize extends GenericServlet implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    /*
    不再使用 AtomicLong 类型，只使用了long 类型
    由于已经使用了同步代码块来构造原子操作，而使用两种不同的同步机制不仅会带来混乱，
    而且也不会在性能或安全性上带来任何好处，因此在这里不使用原子变量。
     */
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
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

