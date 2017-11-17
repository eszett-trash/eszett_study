#ifndef __CONV_SCENE_H__
#define __CONV_SCENE_H__

#include "cocos2d.h"

class Conv : public cocos2d::Layer
{
public:
    static cocos2d::Scene* createScene();

    virtual bool init();
    
    //// a selector callback
    //void menuCloseCallback(cocos2d::Ref* pSender);
    //

	void convFileIo();
    // implement the "static create()" method manually
    CREATE_FUNC(Conv);
};

#endif // __HELLOWORLD_SCENE_H__
