#include <bits/stdc++.h>

using namespace std;

int main()
{

    int n;
    cin>>n;
    bool ch = true;

    while(n!=0)
    {
        int temp = n%10;
        n = n/10;
        if((temp != 4) || (temp!=7))
        {
            ch = false;
            break;
        }

    }
    if(ch)
    {
        cout<< "YES";
    }else{
    cout << "NO";
    }
}
