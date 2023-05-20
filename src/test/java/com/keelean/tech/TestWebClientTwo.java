package com.keelean.tech;

import com.keelean.com.ConnectionFactory;
import com.keelean.com.WebClient1;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientTwo {

    @Test
    public void testGetContentOk() throws Exception {
        MockingConnectionFactory mockingConnectionFactory = new MockingConnectionFactory();
        mockingConnectionFactory.setInputStream(new ByteArrayInputStream("It works".getBytes()));
        WebClient1 webClient = new WebClient1();
        String workingContent = webClient.getContent(mockingConnectionFactory);
        assertEquals("It works", workingContent);
    }
}
