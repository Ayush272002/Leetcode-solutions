#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int val;
    Node *next;
    Node *random;

    Node(int _val)
    {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

class Solution
{
public:
    void insertAtEnd(Node *&copy, Node *node)
    {
        Node *n = new Node(node->val);
        if (copy == NULL)
        {
            copy = n;
        }
        else
        {
            Node *temp = copy;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }

            temp->next = n;
        }
    }

    Node *copyRandomList(Node *head)
    {
        Node *copy = NULL;
        Node *temp = head;

        while (temp)
        {
            insertAtEnd(copy, temp);
            temp = temp->next;
        }

        unordered_map<Node *, Node *> oldToNew;
        Node *original = head;
        Node *cloned = copy;

        while (original && cloned)
        {
            oldToNew[original] = cloned;
            original = original->next;
            cloned = cloned->next;
        }

        original = head;
        cloned = copy;

        while (original)
        {
            cloned->random = oldToNew[original->random];
            original = original->next;
            cloned = cloned->next;
        }

        return copy;
    }
};