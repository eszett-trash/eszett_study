#ifndef __SAVELOAD_SCENE_H__
#define __SAVELOAD_SCENE_H__

#include "cocos2d.h"

class SaveLoad : public cocos2d::Layer
{
public:
    static cocos2d::Scene* createScene();

    virtual bool init();
    
    CREATE_FUNC(SaveLoad);
};

#endif // __HELLOWORLD_SCENE_H__
