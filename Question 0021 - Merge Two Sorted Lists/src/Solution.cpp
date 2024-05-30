#include<bits/stdc++.h>
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) 
    {
        ListNode* ptr1 = list1; 
        ListNode* ptr2 = list2;    

        ListNode ans(-1);

        ListNode* ansPtr = &ans;

        while(ptr1 != NULL && ptr2 != NULL)
        {
            if(ptr1->val <= ptr2->val)
            {
                ansPtr->next = ptr1;
                ptr1 = ptr1->next;
            }
            else
            {
                ansPtr->next = ptr2;
                ptr2 = ptr2->next;
            }

            ansPtr = ansPtr->next;
        }

        if(ptr1 != NULL) ansPtr->next = ptr1;
        if(ptr2 !=NULL) ansPtr->next = ptr2;

        return ans.next;

    }
};