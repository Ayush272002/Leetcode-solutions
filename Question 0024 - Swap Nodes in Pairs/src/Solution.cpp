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
    ListNode* swapPairs(ListNode* head) 
    {
        ListNode ans(-1);
        ListNode* ansPtr = &ans;
        stack<ListNode*> st;
        ListNode* headPtr = head;

        while(headPtr != NULL)
        {
            for(int i = 0; i < 2 && headPtr != NULL; i++)
            {
                st.push(headPtr);
                headPtr = headPtr->next;
            }

            while(!st.empty())
            {
                ansPtr->next = st.top();
                st.pop();
                ansPtr = ansPtr->next;
            }
        }    

        ansPtr->next = NULL;
        return ans.next;
    }
};