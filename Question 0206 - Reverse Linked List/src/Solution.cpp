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

class Solution {
public:
    ListNode* rev(ListNode* head, ListNode* tail){
        if(head == NULL)
            return tail;

        ListNode* tmp = head->next;
        head->next = tail;
        return rev(tmp, head);
    }

    ListNode* reverseList(ListNode* head) {
        return rev(head, NULL);
    }
};