package alg4.strings;

/**
 * @author banxuan
 * Date : 2021/2/12
 * Time : 11:11 下午
 * https://book.douban.com/subject/19952400/discussion/59623403/
 */
public class KMP2 {

    /*
    dfa[text.charAt(i)][j]是指当文本字符串的字符(str.txt)s[i]与模式字符串(pat)的字符p[j]比较后下一次与文本字符串的字符s[i+1]比较的 模式字符串(pat) 的字符位。

    当文本字符串的第i位字符与模式字符串的第j位进行匹配时，如果此两位字符匹配，则说明下一步应该为i++ j++之后再比较，也就是说当txt.charAt(i)==pat.charAt(j)时，有dfa[pat.charAt(j)][j]=j+1。

    txt.charAt(i) = pat.charAt(j) => dfa[text.charAt(i)][j] = dfa[pat.charAt(j)][j] = j+1

    当文本字符串的第i位字符与模式字符串的第j位检测到不匹配时，设txt.charAt(i)==c，c!=pat.charAt(j)，但文本字符串的s[i-j...i-1]这部分与模式字符串的p[0...j-1]这部分是匹配的。这时从文本字符串的i-j位置起已不可能出现匹配字符串，现在已不用管s[i-j]字符，现在的问题是依次输入s[i-j+1...i-1]c后会进入什么状态，由于s[i-j...i-1]这部分与模式字符串的p[0...j-1]这部分是匹配的，也就是说现在的问题是依次输入p[1...j-1]c后会进入什么状态。

    // 现在引入一个新的变量 X[j]是指正确输入p[1...j-1]后进入的状态
    // 这个时候我们可以确定的是状态是 dfa[c][j]，所以 dfa[c][j-1]=dfa[c][x[j]]。

    引入一个状态指示数组X，X[j]是指正确输入p[1...j-1]后进入的状态，输入p[1...j-1]c后进入的状态就是dfa[c][X[j]]（在X[j]状态时输入c），即dfa[c][j]=dfa[c][x[j]]。


而计算X[]数组的方法为递推方法：X[j+1]为正确输入p[1...j]后进入的状态，即正确输入p[1...j-1]p[j]后进入的状态，也就是在X[j]状态时输入p[j]时进入的状态，就是dfa[pat.charAt[j]][X[j]]，即递推公式为：X[j+1]=dfa[pat.charAt[j]][X[j]]，而X[0]手动初始化为0。
由于X[]数组为辅助数据，且为递推的，所以书中仅使用了一个变量X来指示当前的X[j]，

    X[j+1]为正确输入p[1...j]后进入的状态 这个时候的状态就是dfa[text.charAt(i)][j] => X[j+1]=dfa[pat.charAt[j]][X[j]]
*/

}
