package com.vn.jmssample.mvputils;

public interface View<P extends Presenter> {
    P getPresenter();
}
