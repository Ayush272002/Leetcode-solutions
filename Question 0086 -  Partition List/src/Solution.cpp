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
    ListNode* partition(ListNode* head, int x) 
    {
        ListNode small(-1);
        ListNode big(-1);

        ListNode *smallPtr = &small;
        ListNode *bigPtr = &big;

        while(head)
        {
            if(head->val < x)
            {
                smallPtr->next = head;
                smallPtr = smallPtr->next;
            }
            else
            {
                bigPtr->next = head;
                bigPtr = bigPtr->next;
            }

            head = head->next;
        }

        bigPtr->next = nullptr;
        smallPtr->next = big.next;
        return small.next;
    }
};