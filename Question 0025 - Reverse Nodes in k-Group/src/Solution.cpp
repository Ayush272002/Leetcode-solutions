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
    ListNode* reverseKGroup(ListNode* head, int k) 
    {
        ListNode ans(-1);
        ListNode* ansPtr = &ans;
        ListNode* headPtr = head;
        stack<ListNode*> st;

        while(headPtr != NULL)
        {
            ListNode* groupHead = headPtr;
            int count = 0;
            for(int i = 0; i < k && headPtr != NULL; i++)
            {
                count++;
                st.push(headPtr);
                headPtr = headPtr->next;
            }

            if(count < k)
            {
                ansPtr->next = groupHead;
                break;
            }

            while(!st.empty())
            {
                ansPtr->next = st.top();
                st.pop();
                ansPtr = ansPtr->next;
            }

            ansPtr->next = nullptr;
        }   

        return ans.next; 
    }
};