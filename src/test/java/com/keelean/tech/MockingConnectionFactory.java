package com.keelean.tech;

import com.keelean.com.ConnectionFactory;

import java.io.InputStream;

public class MockingConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getData() throws Exception {
        return inputStream;
    }
}
