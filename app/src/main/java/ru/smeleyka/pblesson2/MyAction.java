package ru.smeleyka.pblesson2;

import io.reactivex.functions.Action;

/**
 * Created by smeleyka on 05.03.18.
 */

public class MyAction implements Action {
    @Override
    public void run() throws Exception {
        System.out.println("TEST");
    }
}
