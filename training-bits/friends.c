#include <assert.h>
#include <stdbool.h>
#include <stdio.h>

#define EMPLOYEE_COUNT 64

static long employees[EMPLOYEE_COUNT];
void initEmployees()
{
    for (int i = 0; i < EMPLOYEE_COUNT; i++)
        employees[i] = (1 << i);
}

void addFriend(int a, int b)
{
    employees[a] |= (1 << b);
    employees[b] |= (1 << a);
}

bool haveCommonFriend(int a, int b)
{
    long aFriendsExceptB = employees[a] & ~(1 << a) & ~(1 << b);
    long bFriendsExceptA = employees[b] & ~(1 << a) & ~(1 << b);
    return (aFriendsExceptB & bFriendsExceptA) ? true : false;
}

int main()
{
    initEmployees();

    addFriend(1, 0);
    addFriend(4, 1);
    addFriend(2, 1);
    addFriend(1, 3);
    addFriend(2, 0);

    assert(haveCommonFriend(1, 0) == true);
    assert(haveCommonFriend(2, 0) == true);
    assert(haveCommonFriend(3, 0) == true);
    assert(haveCommonFriend(3, 1) == false);
    assert(haveCommonFriend(1, 2) == true);
}
