import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(())()"));
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                }else{
                    stack.pop();
                }
                if (stack.size() > s.length() - i){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.size() == 0;
    }

}
