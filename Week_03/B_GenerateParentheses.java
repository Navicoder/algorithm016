import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangwenchao
 * @Date 2020/11/22 19:02
 * @Description
 * @Version 1.0
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class B_GenerateParentheses {
    List list= new ArrayList();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(0,0,n,"");
        return list;

    }

    /**
     *
     * @param left 用了 left个左括号
     * @param right 用了 right个左括号
     * @param n 共 n对
     * @param s 之前的括号串
     */
    private void generateParenthesis(int left, int right, int n, String s) {
        //终止条件
        //本层处理
        //drill down
        // process 本层资源

        while (left==n && right ==n){
            list.add(s);
            return;
        }
        if (left < n) {
            generateParenthesis(left+1,right,n,s+"(");
        }
        if (right<left &&right < n) {
            generateParenthesis(left,right+1,n,s+")");
        }


    }

    public static void main(String[] args) {
        System.out.println(new B_GenerateParentheses().generateParenthesis(3));
    }



}
