package com.epam.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestChangeSuiteName implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Suite started:" + iSuite.getName() + iSuite.getSuiteState());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite finished:" + iSuite.getName() + iSuite.getSuiteState());
    }
}