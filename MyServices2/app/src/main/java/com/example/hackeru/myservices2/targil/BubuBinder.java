package com.example.hackeru.myservices2.targil;

import android.os.Binder;

public class BubuBinder extends Binder {
    private BubuService service;
    public BubuBinder(BubuService service) {
        this.service = service;
    }
    public BubuService getService() {
        return service;
    }
}
