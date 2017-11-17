#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"
#include "ConvScene.h"
#include <fstream>
#include <iostream>

USING_NS_CC;
using namespace std;

Scene* Conv::createScene()
{
    auto scene = Scene::create();
    auto layer = Conv::create();
    scene->addChild(layer);
    return scene;
}

bool Conv::init()
{
    if ( !Layer::init() )
    {
        return false;
    }
    
    auto visibleSize = Director::getInstance()->getVisibleSize();
    Vec2 origin = Director::getInstance()->getVisibleOrigin();

	Conv::convFileIo();
    return true;
}

void Conv::convFileIo()
{

	Size windowSize = Director::getInstance()->getWinSize();
	auto label = Label::createWithSystemFont("안녕하세요, Hello,　您好、 こんにちは", "D2Coding.ttf", 50);
	label->setPosition(400, 250);
	this->addChild(label);

	string filePath = "test.txt";

	// read File
	ifstream openFile(filePath.data());
	if (openFile.is_open()) {
		string line;
		while (getline(openFile, line)) {
			auto label = Label::createWithSystemFont(line, "D2Coding.ttf", 50);
			label->setPosition(400, 250);
			this->addChild(label);

			if (EOF == 1)
			{
				break;
			}
		}
		openFile.close();
	}

}