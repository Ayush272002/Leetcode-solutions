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

        insertUtil(child, word.substr(1));
    }

    bool searchUtil(TrieNode *root, string word)
    {
        // base case
        if (word.size() == 0)
        {
            return root->isTerminal;
        }

        int idx = word[0] - 'a';
        TrieNode *child;

        if (root->children[idx] != NULL)
            child = root->children[idx];
        else
            return false;

        return searchUtil(child, word.substr(1));
    }

    bool startsWithUtil(TrieNode *root, string word)
    {
        if (word.size() == 0)
            return true;

        int idx = word[0] - 'a';
        TrieNode *child;

        if (root->children[idx] != NULL)
            child = root->children[idx];
        else
            return false;

        return startsWithUtil(child, word.substr(1));
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

    bool search(string word)
    {
        return searchUtil(root, word);
    }

    bool startsWith(string prefix)
    {
        return startsWithUtil(root, prefix);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */