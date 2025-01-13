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

class WordDictionary
{
private:
    TrieNode *root;

    void add(TrieNode *root, string word)
    {
        if (word.size() == 0)
        {
            root->isTerminal = true;
            return;
        }

        int idx = word[0] - 'a';

        if (root->children[idx] == NULL)
            root->children[idx] = new TrieNode(word[0]);

        TrieNode *child = root->children[idx];
        add(child, word.substr(1));
    }

    bool searchUtil(TrieNode *root, string word)
    {
        if (word.empty())
            return root->isTerminal;

        if (word[0] == '.')
        {
            for (int i = 0; i < 26; i++)
            {
                if (root->children[i] != NULL)
                {
                    if (searchUtil(root->children[i], word.substr(1)))
                        return true;
                }
            }

            return false;
        }
        else
        {
            int idx = word[0] - 'a';
            TrieNode *child;
            if (root->children[idx] != NULL)
                child = root->children[idx];
            else
                return false;

            return searchUtil(child, word.substr(1));
        }
    }

public:
    WordDictionary()
    {
        root = new TrieNode('\0');
    }

    void addWord(string word)
    {
        add(root, word);
    }

    bool search(string word)
    {
        return searchUtil(root, word);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */