import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.alibaba.druid.util.Utils.md5;

/**
 * 测试Password
 */
public class Test {
    @org.junit.Test
    /**
     * MD5加密
     * 1. MD5是一个加密的算法，可以对铭文字符串进行加密，得到一个密文。
     * 2. MD5原文和密文是一对一的键值对。
     *    1. 例如：原文：123 密文：202cb962ac59075b964b07152d234b70
     *    2. 不管执行多少次，加密算法是固定的，得到的密文永远不变
     *    3. 相对来说就不安全，容易被破解
     * 3. 公司中使用MD5进行加密
     *    1. 例如：原文密码是123，把首尾交换，再加上用户名进行加密
     *    2. 例如：321meimei 进行加密e5212215b8cbf493e04f4290cf7cecc8
     *    3. 这样做相对来说会安全
     */
    public void TestPassword() {
        Md5Hash h = new Md5Hash("123", "ha", 2);
        System.out.println(h);
    }

    @org.junit.Test
    /**
     *  BCryptPasswordEncoder加密（加盐加密算法）
     *  1. shiro框架有md5hash算法加密，该加密是加盐的方式进行加密的。
     *  2. 在原有的密码中随机加入盐（就是字符串），再进行加密。
     */
    public void tesy02() {
        System.out.println(md5("321meimei"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String str = encoder.encode("123");
        System.out.println(str);

        // 进行判断
        boolean b = encoder.matches("123", "$2a$10$UxZneVG78UkChbx4sZND7.mWWx6ulbnl38updtSMRK0KQw5QvEdUy");
        System.out.println(b);
    }

}
