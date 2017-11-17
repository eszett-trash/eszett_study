#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"
#include "ConvScene.h"
#include "SaveLoadScene.h"

USING_NS_CC;

Scene* HelloWorld::createScene()
{
    // 'scene' is an autorelease object
    auto scene = Scene::create();
    
    // 'layer' is an autorelease object
    auto layer = HelloWorld::create();

    // add layer as a child to scene
    scene->addChild(layer);

    // return the scene
    return scene;
}

// on "init" you need to initialize your instance
bool HelloWorld::init()
{
	if (!Layer::init()) { return false; }

	auto visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();


	//��ư�����
	auto btn_start = MenuItemImage::create("UI_btn/UI_start.png", "UI_btn/UI_start.png", CC_CALLBACK_1(HelloWorld::startGame, this));
	auto btn_load = MenuItemImage::create("UI_btn/UI_load.png", "UI_btn/UI_load.png", CC_CALLBACK_1(HelloWorld::loadGame, this));
	auto btn_extra = MenuItemImage::create("UI_btn/UI_extra.png", "UI_btn/UI_extra.png", CC_CALLBACK_1(HelloWorld::menuCloseCallback, this));
	auto btn_exit = MenuItemImage::create("UI_btn/UI_exit.png", "UI_btn/UI_exit.png", CC_CALLBACK_1(HelloWorld::menuCloseCallback, this));

	btn_start->setPosition(Vec2(visibleSize.width / 2, 400));
	btn_load->setPosition(Vec2(visibleSize.width / 2, 300));
	btn_extra->setPosition(Vec2(visibleSize.width / 2, 200));
	btn_exit->setPosition(Vec2(visibleSize.width / 2, 100));

	// ��ư��� �ڵ��Ҵ������� ���� ����
	auto btn_start_reg = Menu::create(btn_start, NULL);
	btn_start_reg->setPosition(Vec2::ZERO);
	auto btn_load_reg = Menu::create(btn_load, NULL);
	btn_load_reg->setPosition(Vec2::ZERO);
	auto btn_extra_reg = Menu::create(btn_extra, NULL);
	btn_extra_reg->setPosition(Vec2::ZERO);
	auto btn_exit_reg = Menu::create(btn_exit, NULL);
	btn_exit_reg->setPosition(Vec2::ZERO);

	this->addChild(btn_start_reg, 1);
	this->addChild(btn_load_reg, 1);
	this->addChild(btn_extra_reg, 1);
	this->addChild(btn_exit_reg, 1);

	//ȭ�鿡 �ѷ��ִ� ��������Ʈ
	auto main_bg = Sprite::create("ill_temp.png");
	main_bg->setPosition(Vec2(visibleSize.width / 2 + origin.x, visibleSize.height / 2 + origin.y));

	auto main_title = Sprite::create("tmpimg/title.png");
	main_title->setPosition(Vec2(visibleSize.width / 2, 650));

	this->addChild(main_bg, 0);
	this->addChild(main_title, 0);

	return true;
}

void HelloWorld::startGame(Ref *sender)
{
	//MAIN�̶�� Ŭ���� �̸��� ���� ������ �̵�
	Director::getInstance()->replaceScene(Conv::createScene());
}

void HelloWorld::loadGame(Ref *sender)
{
	//�ε�ȭ�� Ǫ�ý�Ŵ. ���̺�/�ε�� ���� ȭ���� ���� ���� �Ѱܼ� ���̺����� �ε����� üũ�ϱ�
	Director::getInstance()->pushScene(SaveLoad::createScene());

}


void HelloWorld::menuCloseCallback(Ref* pSender)
{
    Director::getInstance()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
