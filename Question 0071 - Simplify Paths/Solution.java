class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] dir = path.split("/");

        for (String d : dir) {
            if (d.equals(".") || d.isEmpty())
                continue;
            else if (d.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else
                st.push(d);
        }

        return "/" + String.join("/", st);
    }
}