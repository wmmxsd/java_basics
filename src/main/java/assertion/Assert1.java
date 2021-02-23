package assertion;

/**
 * 断言demo
 * assert boolean-expression;
 * assert boolean-expression:information-expression;
 * assert（我断定这个布尔表达式会产生true，否则抛出AssertException异常）
 * @author wangmingming160328
 * @date @2021/2/23 11:06
 */
public class Assert1 {
    public static void main(String[] args) {
        //assert false;
        assert false:"错误";
        /*
        Exception in thread "main" java.lang.AssertionError
	        at assertion.Assert1.main(Assert1.java:13)
        */
    }
}
