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
    ListNode *reverse(ListNode *curr, ListNode *prev)
    {
        if (curr == NULL)
            return prev;

        ListNode *next = curr->next;
        curr->next = prev;
        return reverse(next, curr);
    }

    bool isPalindrome(ListNode *head)
    {
        ListNode *slow = head;
        ListNode *fast = head;

        while (fast && fast->next)
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode *rev = reverse(slow, NULL);
        ListNode *tmp = head;

        while (rev && tmp)
        {
            if (rev->val != tmp->val)
                return false;
            rev = rev->next;
            tmp = tmp->next;
        }

        return true;
    }
};