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
    ListNode *rev(ListNode *curr, ListNode *prev)
    {
        if (curr == NULL)
            return prev;
        ListNode *next = curr->next;
        curr->next = prev;
        return rev(next, curr);
    }

    void reorderList(ListNode *head)
    {
        if (!head || !head->next || !head->next->next)
            return;

        ListNode *slow = head;
        ListNode *fast = head;

        while (fast && fast->next && fast->next->next)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode *second = slow->next;
        slow->next = NULL;
        second = rev(second, NULL);

        ListNode *first = head;
        while (second)
        {
            ListNode *temp1 = first->next;
            ListNode *temp2 = second->next;

            first->next = second;
            second->next = temp1;
            first = temp1;
            second = temp2;
        }
    }
};