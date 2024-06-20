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
    ListNode* deleteDuplicates(ListNode* head) 
    {
        if(head == NULL) return head;
        ListNode *curr = head;
        ListNode *next = head->next;

        while(curr->next != NULL)
        {
            if(curr->val == next->val)
            {
                curr->next = next->next;
                next = curr->next;
            }
            else
            {
                curr = curr->next;
                next = curr->next;
            }
        }

        return head;
    }
};