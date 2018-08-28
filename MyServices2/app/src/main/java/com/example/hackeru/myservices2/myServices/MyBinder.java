package com.example.hackeru.myservices2.myServices;

import android.os.Binder;

public class MyBinder extends Binder { //Binder is a container for a MyBoundService
    private final MyBoundService service; //MyBinder HAS MyBoundService

    public MyBinder(MyBoundService service) { //Dependency Injection - for MyBoundService
        this.service = service;
    }

    public MyBoundService getService() { //public getter
        return service;
    }
}
