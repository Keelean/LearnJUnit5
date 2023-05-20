package com.keelean.tech;

import com.keelean.com.StubHttpURLConnection;
import com.keelean.com.WebClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientOne {

    @BeforeAll
    public static void setUp(){
        URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());
    }

    private static class StubStreamHandlerFactory implements URLStreamHandlerFactory {

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    @Test
    public void testContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String workingContent = client.getContent(new URL("http://localhost"));
        assertEquals("It works", workingContent);
    }

    private static class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpURLConnection(url);
        }
    }

    @AfterAll
    public static void tearDown(){
    }
}
