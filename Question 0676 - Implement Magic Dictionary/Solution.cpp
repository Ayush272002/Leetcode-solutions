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

class MagicDictionary
{
private:
    TrieNode *root;

    void insert(TrieNode *root, string word)
    {
        // base case
        if (word.size() == 0)
        {
            root->isTerminal = true;
            return;
        }

        int idx = word[0] - 'a';
        TrieNode *child;

        if (root->children[idx] != NULL)
        {
            child = root->children[idx];
        }
        else
        {
            child = new TrieNode(word[0]);
            root->children[idx] = child;
        }

        insert(child, word.substr(1));
    }

    bool searchUtil(TrieNode *root, string word, int swaps)
    {
        // base case
        if (word.size() == 0)
            return (root->isTerminal && swaps == 1);

        if (swaps > 1)
            return false;

        int idx = word[0] - 'a';
        TrieNode *child;

        if (root->children[idx] != NULL)
        {
            child = root->children[idx];
            if (searchUtil(child, word.substr(1), swaps))
                return true;
        }
        if (swaps == 0)
        {
            for (int i = 0; i < 26; i++)
            {
                if (root->children[i] != NULL && i != idx)
                {
                    if (searchUtil(root->children[i], word.substr(1), swaps + 1))
                        return true;
                }
            }
        }
        return false;
    }

public:
    MagicDictionary()
    {
        root = new TrieNode('\0');
    }

    void buildDict(vector<string> dictionary)
    {
        for (int i = 0; i < dictionary.size(); i++)
        {
            insert(root, dictionary[i]);
        }
    }

    bool search(string searchWord)
    {
        return searchUtil(root, searchWord, 0);
    }
};

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary* obj = new MagicDictionary();
 * obj->buildDict(dictionary);
 * bool param_2 = obj->search(searchWord);
 */