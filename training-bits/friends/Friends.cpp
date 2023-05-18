#include "judge.h"

class Friends : public iFriends {
    public:
	void addFriend(int a, int b) {
    }
	bool haveCommonFriend(int a, int b) {
        return false;
    }
};

Friends solution;

int main() {
    judge::run(&solution);
    return 0;
}
