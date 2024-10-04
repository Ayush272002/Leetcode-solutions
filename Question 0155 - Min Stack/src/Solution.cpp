#include<bits/stdc++.h>
using namespace std;

struct Node {
    int val;
    Node* next;
    Node() : val(0), next(nullptr) {}
    Node(int x) : val(x), next(NULL) {}
    Node(int x, Node *next) : val(x), next(next) {}
};

class MinStack {
private: 
    Node* head;
    int minVal;

public:
    MinStack() {
        head = nullptr;
        minVal = INT_MAX;
    }
    
    void push(int val) {
        if(head == nullptr){
            head = new Node(val);
            minVal = min(minVal, val);
        }
        else{
            Node *temp = new Node(val);
            temp->next = head;
            head = temp;
            minVal = min(minVal, val);
        }
    }
    
    void pop() {
        if(head->val == minVal){
            head = head->next;
            minVal = INT_MAX;
            Node *temp = head;

            while(temp != nullptr){
                minVal = min(minVal, temp->val);
                temp = temp->next;
            }
        } else {
            head = head->next;
        }
    }
    
    int top() {
        return head->val;
    }
    
    int getMin() {
        return minVal;
    }
};