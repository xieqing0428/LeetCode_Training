import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: No_038_Count_and_Say
 * @Description:
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * @Author: XieQing
 * @Date: 2018/11/1 19:01
 * @Version: 1.0
 */
public class No_038_Count_and_Say {
    class SolutionA {
        public String countAndSay(int n) {
            String prev, result;
            int len, num;
            num = 0;
            Map<Integer, String> temp = new HashMap<>();
            temp.put(1, "1");
            for (int i = 2; i <= n; i++) {
                result = "";
                prev = temp.get(i - 1);
                len = prev.length();
                char first, next;
                first = '0';
                for (int j = 0; j < len; j++) {
                    next = prev.charAt(j);
                    if (j == 0) {
                        first = prev.charAt(0);
                        num = 1;
                        continue;
                    }
                    if (next == first) {
                        num++;
                    } else {
                        result += String.valueOf(num) + String.valueOf(first);
                        first = next;
                        num = 1;
                    }
                }
                result += String.valueOf(num) + String.valueOf(first);
                temp.put(i, result);
            }
            return temp.get(n);
        }
    }
    class SolutionB {
        public String countAndSay(int n) {
            if (n < 1) {
                return null;
            }
            String result = "1";
            // 递归
            for (int i = 2; i <=n ; i++) {
                result = countAndSay(result);
            }
            return result;
        }

        private String countAndSay(String str) {
            StringBuilder builder = new StringBuilder();
            int count = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                } else {
                    builder.append(count);
                    builder.append(str.charAt(i - 1));
                    count = 1;
                }
            }
            builder.append(count);
            builder.append(str.charAt(str.length() - 1));
            return builder.toString();
        }
    }
    class SolutionC {
        public String countAndSay(int n) {
            // 打表可耻……
            switch (n) {
                case 1: return "1";
                case 2: return "11";
                case 3: return "21";
                case 4: return "1211";
                case 5: return "111221";
                case 6: return "312211";
                case 7: return "13112221";
                case 8: return "1113213211";
                case 9: return "31131211131221";
                case 10: return "13211311123113112211";
                case 11: return "11131221133112132113212221";
                case 12: return "3113112221232112111312211312113211";
                case 13: return "1321132132111213122112311311222113111221131221";
                case 14: return "11131221131211131231121113112221121321132132211331222113112211";
                case 15: return "311311222113111231131112132112311321322112111312211312111322212311322113212221";
                case 20: return "11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211";
                case 25: return "132113213221133112132123123112111311222112132113311213211231232112311311222112111312211311123113322112132113212231121113112221121321132132211231232112311321322112311311222113111231133221121113122113121113221112131221123113111231121123222112132113213221133112132123123112111312111312212231131122211311123113322112111312211312111322111213122112311311123112112322211211131221131211132221232112111312111213111213211231132132211211131221232112111312212221121123222112132113213221133112132123123112111311222112132113213221132213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121132211332113221122112133221123113112221131112311332111213122112311311123112111331121113122112132113121113222112311311221112131221123113112221121113311211131122211211131221131211132221121321132132212321121113121112133221123113112221131112212211131221121321131211132221123113112221131112311332211211133112111311222112111312211311123113322112111312211312111322212321121113121112133221121321132132211331121321231231121113112221121321132122311211131122211211131221131211322113322112111312211322132113213221123113112221131112311311121321122112132231121113122113322113111221131221";
                case 30: return "3113112221131112311332111213122112311311123112111331121113122112132113121113222112311311221112131221123113112221121113311211131122211211131221131211132221121321132132212321121113121112133221123113112221131112212211131221121321131211132221123113112221131112311332211211133112111311222112111312211311123113322112111312211312111322212321121113121112133221121321132132211331121321132213211231132132211211131221232112111312212221121123222112311311222113111231133211121321321122111312211312111322211213211321322123211211131211121332211231131122211311123113321112131221123113111231121123222112111331121113112221121113122113111231133221121113122113121113221112131221123113111231121123222112111312211312111322212321121113121112131112132112311321322112111312212321121113122122211211232221121321132132211331121321231231121113112221121321132132211322132113213221123113112221133112132123222112111312211312112213211231132132211211131221131211322113321132211221121332211231131122211311123113321112131221123113111231121113311211131221121321131211132221123113112211121312211231131122211211133112111311222112111312211312111322211213211321223112111311222112132113213221133122211311221122111312211312111322212321121113121112131112132112311321322112111312212321121113122122211211232221121321132132211331121321231231121113112221121321132132211322132113213221123113112221133112132123222112111312211312112213211231132132211211131221131211322113321132211221121332211213211321322113311213212312311211131122211213211331121321123123211231131122211211131221131112311332211213211321223112111311222112132113213221123123211231132132211231131122211311123113322112111312211312111322111213122112311311123112112322211213211321322113312211223113112221121113122113111231133221121321132132211331222113321112131122211332113221122112133221123113112221131112311332111213122112311311123112111331121113122112132113121113222112311311221112131221123113112221121113311211131122211211131221131211132221121321132132212321121113121112133221123113112221131112311332111213122112311311123112112322211322311311222113111231133211121312211231131112311211232221121113122113121113222123211211131221132211131221121321131211132221123113112211121312211231131122113221122112133221121321132132211331121321231231121113121113122122311311222113111231133221121113122113121113221112131221123113111231121123222112132113213221133112132123123112111312211322311211133112111312211213211311123113223112111321322123122113222122211211232221121113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123211211131211121332211213111213122112132113121113222112132113213221232112111312111213322112132113213221133112132123123112111311222112132113311213211221121332211231131122211311123113321112131221123113112221132231131122211211131221131112311332211213211321223112111311222112132113212221132221222112112322211211131221131211132221232112111312111213111213211231131112311311221122132113213221133112132123222112311311222113111231132231121113112221121321133112132112211213322112111312211312111322212321121113121112131112132112311321322112111312212321121113122122211211232221121311121312211213211312111322211213211321322123211211131211121332211213211321322113311213211322132112311321322112111312212321121113122122211211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113111231133221121321132122311211131122211213211321222113222122211211232221123113112221131112311332111213122112311311123112111331121113122112132113121113222112311311221112131221123113112221121113311211131122211211131221131211132221121321132132212321121113121112133221123113112221131112311332111213213211221113122113121113222112132113213221232112111312111213322112132113213221133112132123123112111312211322311211133112111312212221121123222112132113213221133112132123222113223113112221131112311332111213122112311311123112112322211211131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112211322212322211231131122211322111312211312111322211213211321322113311213211331121113122122211211132213211231131122212322211331222113112211";
            }
            return null;
        }
    }
}
