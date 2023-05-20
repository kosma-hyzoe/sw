#include "judge.h"

class Container : public IContainer {

public:
	 void init(int size) {
	 }
	 bool add(int a) {
	 }
	 bool contains(int a) {
	 }
	 bool remove(int a) {
	 }

};

int main() {
	Container * container = new Container();
	Judge::run(container);
}
