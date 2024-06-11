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
    ListNode* rotateRight(ListNode* head, int k) 
    {
        if(head == NULL ||  k == 0) return head;

        ListNode* temp = head;
        int length = 1;

        while(temp->next != NULL)
        {
            length++;
            temp = temp->next;
        }
        
        temp->next = head;
        k %= length;

        int stepToTail = length - k - 1;
        ListNode* tail = head;
        for(int i = 0; i < stepToTail; i++) tail = tail->next;

        ListNode* newHead = tail->next;
        tail->next = nullptr;
        return newHead;
    }
};