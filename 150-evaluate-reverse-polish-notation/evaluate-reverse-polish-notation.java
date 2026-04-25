class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (isoperator(token)) {
                int opr2 = st.pop();
                int opr1 = st.pop();
                int res = evaluate(token, opr1, opr2);
                st.push(res); // push the result back
            } else {
                // converts string number to primitive int
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    boolean isoperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    int evaluate(String token, int opr1, int opr2) {
        if (token.equals("+")) {
            return opr1 + opr2;
        } else if (token.equals("-")) {
            return opr1 - opr2;
        } else if (token.equals("*")) {
            return opr1 * opr2;
        } else { // "/"
            return opr1 / opr2; // integer division
        }
    }
}
