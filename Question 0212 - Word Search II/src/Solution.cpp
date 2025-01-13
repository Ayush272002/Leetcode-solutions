#include <bits/stdc++.h>
using namespace std;

class TrieNode
{
public:
    char data;
    TrieNode *children[26];
    bool isTerminal;

    TrieNode(char data)
    {
        this->data = data;

        for (int i = 0; i < 26; i++)
        {
            children[i] = NULL;
        }

        isTerminal = false;
    }
};

class Trie
{
private:
    TrieNode *root;

    void addUtil(TrieNode *root, string word)
    {
        if (word.empty())
        {
            root->isTerminal = true;
            return;
        }

        int idx = word[0] - 'a';
        if (root->children[idx] == NULL)
            root->children[idx] = new TrieNode(word[0]);

        addUtil(root->children[idx], word.substr(1));
    }

public:
    Trie()
    {
        root = new TrieNode('\0');
    }

    void add(string word)
    {
        addUtil(root, word);
    }

    TrieNode *getRoot()
    {
        return root;
    }
};

class Solution
{
private:
    void solve(vector<vector<char>> &board, vector<vector<bool>> &vis, string currWord, set<string> &ans, TrieNode *t, int r, int c, vector<vector<int>> &dir)
    {
        if (r < 0 || r >= board.size() || c < 0 || c >= board[0].size() || vis[r][c])
            return;

        char ch = board[r][c];
        int idx = ch - 'a';

        if (!t->children[idx])
            return;

        vis[r][c] = true;
        currWord.push_back(ch);
        t = t->children[idx];

        if (t->isTerminal)
        {
            ans.insert(currWord);
        }

        for (auto &d : dir)
        {
            int x = r + d[0];
            int y = c + d[1];

            solve(board, vis, currWord, ans, t, x, y, dir);
        }

        vis[r][c] = false;
        currWord.pop_back();
    }

public:
    vector<string> findWords(vector<vector<char>> &board, vector<string> &words)
    {
        Trie *trie = new Trie();

        for (const string &w : words)
        {
            trie->add(w);
        }

        TrieNode *t = trie->getRoot();
        int n = board.size(), m = board[0].size();
        set<string> ans;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        vector<vector<int>> dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                string currWord = "";
                solve(board, vis, currWord, ans, t, i, j, dir);
            }
        }

        vector<string> res(ans.begin(), ans.end());
        return res;
    }
};