package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.

 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。

 思路:灵活思维，不要硬碰硬
 * Created by zhaiyi on 2018/10/13.
 */
public class CodeC535 {
    public static void main(String[] args) {
        CodeC535 codeC535 = new CodeC535();
        System.out.println(codeC535.encode("https://leetcode.com/problems/design-tinyurl"));
    }

    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String short_ = "" + longUrl.hashCode();
        map.put(short_, longUrl);
        return short_;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
