package com.tiwatch.app;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * Created by Chandan Jana on 05-10-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

@HiltViewModel
public class MainViewModel extends AndroidViewModel {

    @Inject
    MainViewModel(Application application){
        super(application);
    }
}

