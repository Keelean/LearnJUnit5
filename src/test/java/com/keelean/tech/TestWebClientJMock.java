package com.keelean.tech;

import com.keelean.com.ConnectionFactory;
import com.keelean.com.WebClient;
import com.keelean.com.WebClient1;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestWebClientJMock {

    @RegisterExtension
    Mockery context = new JUnit5Mockery(){
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    @Test
    public void testGetContentOk() throws Exception {
        ConnectionFactory connectionFactory = context.mock(ConnectionFactory.class);
        InputStream mockStream = context.mock(InputStream.class);
        context.checking(new Expectations(){
            {
                oneOf(connectionFactory).getData();
                will(returnValue(mockStream));

                atLeast(1).of(mockStream).read();
                will(onConsecutiveCalls(
                        returnValue(Integer.valueOf((byte) 'W')),
                        returnValue(Integer.valueOf((byte) 'o')),
                        returnValue(Integer.valueOf((byte) 'r')),
                        returnValue(Integer.valueOf((byte) 'k')),
                        returnValue(Integer.valueOf((byte) 's')),
                        returnValue(Integer.valueOf((byte) '!')),
                        returnValue(-1)
                ));
                oneOf(mockStream).close();
            }
        });
        WebClient1 client = new WebClient1();
        String workingClient = client.getContent(connectionFactory);
        assertEquals("Works!", workingClient);
    }

    public void testGetContentCannotCloseInputStream() throws Exception {
        ConnectionFactory factory = context.mock(ConnectionFactory.class);
        InputStream mockStream = context.mock(InputStream.class);
        context.checking(new Expectations(){
            {
                oneOf(factory).getData();
                will(returnValue(mockStream));
                oneOf(mockStream).read();
                will(returnValue(-1));
                oneOf(mockStream).close();
                will(throwException( new IOException("cannot close")));
            }
        });
        WebClient1 client = new WebClient1();
        String workingClient = client.getContent(factory);
        assertNull(workingClient);
    }
}
