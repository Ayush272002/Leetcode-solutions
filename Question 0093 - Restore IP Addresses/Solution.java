import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(List<String> ans, StringBuilder curr, String s, int idx, int segments) {
        if (segments == 4 && idx == s.length()) {
            ans.add(curr.toString());
            return;
        }

        if (idx >= s.length() || segments > 4)
            return;

        int size = curr.length();

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String part = s.substring(idx, idx + i);

            if (part.length() > 1 && part.startsWith("0"))
                continue;

            int val = Integer.parseInt(part);
            if (val < 0 || val > 255)
                continue;

            if (curr.length() > 0)
                curr.append(".");

            curr.append(part);
            solve(ans, curr, s, idx + i, segments + 1);
            curr.setLength(size);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        solve(ans, curr, s, 0, 0);

        return ans;
    }
}