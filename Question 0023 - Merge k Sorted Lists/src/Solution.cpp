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

bool cmp(ListNode* a, ListNode* b)
{
    return a->val > b->val;
}

class Solution
{
public:

    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        priority_queue<ListNode *, vector<ListNode *>, function<bool(ListNode*, ListNode*)>> pq(cmp);
        for (auto node : lists)
        {
            while (node != NULL)
            {
                pq.push(node);
                node = node->next;
            }
        }

        ListNode ans(-1);
        ListNode *ptr = &ans;
        while (!pq.empty())
        {
            ListNode *temp = pq.top();
            pq.pop();
            ptr->next = new ListNode(temp->val);
            ptr = ptr->next;
        }

        return ans.next;
    }
};