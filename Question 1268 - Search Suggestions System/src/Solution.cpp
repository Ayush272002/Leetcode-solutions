#include <bits/stdc++.h>
using namespace std;

class TrieNode
{
public:
    char data;
    TrieNode *children[26];
    bool isTerminal;

    TrieNode(char ch)
    {
        data = ch;
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

    void insertUtil(TrieNode *root, string word)
    {
        if (word.empty())
        {
            root->isTerminal = true;
            return;
        }

        int index = word[0] - 'a';

        TrieNode *child;
        if (root->children[index] != NULL)
        {
            child = root->children[index];
        }
        else
        {
            child = new TrieNode(word[0]);
            root->children[index] = child;
        }

        insertUtil(child, word.substr(1));
    }

    void suggest(TrieNode *curr, vector<string> &tmp, string &prefix)
    {
        if (tmp.size() == 3)
            return;

        if (curr->isTerminal)
            tmp.push_back(prefix);

        for (char ch = 'a'; ch <= 'z'; ch++)
        {
            if (tmp.size() == 3)
                return;

            TrieNode *next = curr->children[ch - 'a'];

            if (next)
            {
                prefix.push_back(ch);
                suggest(next, tmp, prefix);

                prefix.pop_back();
            }
        }
    }

public:
    Trie()
    {
        root = new TrieNode('\0');
    }

    void insert(string word)
    {
        insertUtil(root, word);
    }

    vector<vector<string>> searchSuggestions(string word)
    {
        TrieNode *prev = root;
        vector<vector<string>> ans;
        string prefix;

        for (int i = 0; i < word.size(); i++)
        {
            char lastCh = word[i];

            prefix.push_back(lastCh);

            TrieNode *curr = prev->children[lastCh - 'a'];
            if (curr == NULL)
                break;

            vector<string> tmp;
            suggest(curr, tmp, prefix);

            ans.push_back(tmp);
            prev = curr;
        }

        while (ans.size() < word.size())
            ans.push_back(vector<string>());

        return ans;
    }
};

class Solution
{
public:
    vector<vector<string>> suggestedProducts(vector<string> &products, string searchWord)
    {
        Trie t;

        for (int i = 0; i < products.size(); i++)
        {
            string tmp = products[i];
            t.insert(tmp);
        }

        return t.searchSuggestions(searchWord);
    }
};