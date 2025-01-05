#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    string shiftingLetters(string s, vector<vector<int>> &shifts)
    {
        vector<int> letters(s.size() + 1, 0);

        for (auto &shift : shifts)
        {
            int start = shift[0], end = shift[1], dir = shift[2];

            if (dir == 1)
            {
                letters[start] += 1;
                letters[end + 1] -= 1;
            }
            else
            {
                letters[start] -= 1;
                letters[end + 1] += 1;
            }
        }

        int shiftSum = 0;
        for (int i = 0; i < s.size(); i++)
        {
            shiftSum = (shiftSum + letters[i]) % 26;

            if (shiftSum < 0)
                shiftSum += 26;

            s[i] = 'a' + (s[i] - 'a' + shiftSum) % 26;
        }

        return s;
    }
};