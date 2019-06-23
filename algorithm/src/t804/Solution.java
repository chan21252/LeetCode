package t804;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * <p>
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * <p>
 * 返回我们可以获得所有词不同单词翻译的数量。
 * <p>
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 * <p>
 * 注意:
 * <p>
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 */
public class Solution {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        Solution solution = new Solution();
        System.out.println(solution.uniqueMorseRepresentations(words));
    }

    /**
     * 对于给定的单词数组，得到所有单词摩尔电码不同翻译的数量
     *
     * @param words 单词数组
     * @return 摩尔电码不同翻译的数量
     */
    public int uniqueMorseRepresentations(String[] words) {
        /* 摩尔密码数组 */
        final String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};

        //words 的长度不会超过 100
        final int maxWordArrLen = 100;

        /*
         每个单词 words[i]的长度范围为 [1, 12]
         每个单词 words[i]只包含小写字母
         */
        final int minWordLength = 1;
        final int maxWordLength = 12;

        //检查单词数组长度
        if (words.length > maxWordArrLen) {
            return -1;
        }

        //所有单词摩尔翻译的结果集合
        Set<String> morseResultSet = new HashSet<String>();

        for (String word : words) {
            int wordLen = word.length();
            //单词长度检查
            if (wordLen < minWordLength || wordLen > maxWordLength) {
                return -1;
            }

            //存放单词翻译结果的StringBuilder
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordLen; i++) {
                char c = word.charAt(i);

                //检查是否都是小写字母
                if (c >= 97 && c <= 122) {
                    //根据字符的ASCII码和A的差，从摩尔密码数组中找到翻译结果
                    sb.append(morseCodes[((byte) c - 97)]);
                } else {
                    return -1;
                }
            }
            morseResultSet.add(sb.toString());
        }

        return morseResultSet.size();
    }
}
