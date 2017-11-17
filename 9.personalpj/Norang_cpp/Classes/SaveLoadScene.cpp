#include "SaveLoadScene.h"
#include "SimpleAudioEngine.h"
#include "HelloWorldScene.h"

USING_NS_CC;

Scene* SaveLoad::createScene()
{
    auto scene = Scene::create();
    auto layer = SaveLoad::create();
    scene->addChild(layer);
    return scene;
}

bool SaveLoad::init()
{
    if (!LayerColor:initWithColor(Color4B(0, 255, 0, 255)))
    {
        return false;
    }
    
    auto visibleSize = Director::getInstance()->getVisibleSize();
    Vec2 origin = Director::getInstance()->getVisibleOrigin();
	Director::getInstance()->setClearColor(Color4F(0, 0, 0, 0));



    return true;
}