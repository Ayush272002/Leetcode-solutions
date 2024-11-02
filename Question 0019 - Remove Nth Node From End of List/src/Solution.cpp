#include <bits/stdc++.h>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        if (head == NULL)
            return head;
        int length = 0;
        ListNode *temp = head;

        while (temp != nullptr)
        {
            length++;
            temp = temp->next;
        }

        if (length - n == 0)
            return head->next;
        temp = head;
        for (int i = 1; i < length - n; i++)
            temp = temp->next;

        if (temp->next != nullptr)
            temp->next = temp->next->next;
        return head;
    }
};