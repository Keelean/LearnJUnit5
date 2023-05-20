package com.keelean.tech;

import com.keelean.com.WebClient1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientFailSkeleton {

    @Test
    public void testGetContentOk() throws Exception{
        MockingConnectionFactory mockingConnectionFactory = new MockingConnectionFactory();
        MockInputStream mockInputStream = new MockInputStream();
        mockInputStream.setBuffer("It works");
        mockingConnectionFactory.setInputStream(mockInputStream);
        WebClient1 client = new WebClient1();
        String workingContent = client.getContent(mockingConnectionFactory);
        assertEquals("It works", workingContent);
        mockInputStream.verify();
    }
}
