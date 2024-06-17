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
    ListNode *deleteDuplicates(ListNode *head)
    {
        if(head == NULL) return head;
        ListNode ans(-1);
        ListNode *ansPtr = &ans;

        ListNode *curr = head;
        ListNode *next = curr->next;

        while (next != NULL)
        {
            if (curr->val == next->val)
            {
                while (next != NULL && curr->val == next->val)
                {
                    curr = next;
                    next = curr->next;
                }

                curr = next;
                if (next != NULL) next = curr->next;
            }
            else
            {
                ansPtr->next = curr;
                ansPtr = curr;
                curr = curr->next;
                next = curr->next;
            }
        }

        ansPtr->next = curr;
        return ans.next;
    }
};