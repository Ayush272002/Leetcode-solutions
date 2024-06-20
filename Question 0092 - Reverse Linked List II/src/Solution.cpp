#include<bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution 
{
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) 
    {
        if(!head || left == right)
            return head;

        ListNode dummy(0);
        dummy.next = head;
        ListNode *prev = &dummy;
        for (int i = 1; i < left; i++)
            prev = prev->next;

        ListNode *curr = prev->next;
        ListNode *next = nullptr;

        for (int i = left; i <= right; i++)
        {
            ListNode *temp = curr->next;
            curr->next = next;
            next = curr;
            curr = temp;
        }

        prev->next->next = curr;
        prev->next = next;

        return left == 1 ? next : head;
    }
};