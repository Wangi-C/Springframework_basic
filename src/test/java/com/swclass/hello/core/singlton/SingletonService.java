package com.swclass.hello.core.singlton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        // SingletonService객체는 getInstance로만 return 받을 수 있다.
        return instance;
    }

    private SingletonService() {
        //외부에서 new SingletonService() 를 불가능하게.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
