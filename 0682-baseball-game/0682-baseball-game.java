 class Solution {
    public int calPoints(String[] ops) {
        int[] stack = new int[ops.length];
        int top = 0;

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                top--;
            } else if (ops[i].equals("D")) {
                stack[top] = 2 * stack[top - 1];
                top++;
            } else if (ops[i].equals("+")) {
                stack[top] = stack[top - 1] + stack[top - 2];
                top++;
            } else {
                stack[top] = Integer.parseInt(ops[i]);
                top++;
            }
        }

        int sum = 0;
        for (int i = 0; i < top; i++) {
            sum += stack[i];
        }
        return sum;
    }
}
