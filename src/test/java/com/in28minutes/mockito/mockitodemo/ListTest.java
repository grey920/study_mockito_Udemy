package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

    @Test
    public void testSize() {
        List listMock = mock(List.class);
        
        when(listMock.size()).thenReturn(10);
        
        assertEquals(10, listMock.size()); // 기대값, 실제값
        assertEquals(10, listMock.size()); // 기대값, 실제값
    }
    
    /* thenReturn을 여러번 쓰면 다른 값들을 리턴받는다.*/
    @Test
    public void testSize_multipleReturns() {
        List listMock = mock(List.class);
        // 첫번째 호출에서는 10을 리턴받고 두번째 호출때는 20을 리턴받고 싶다. 
        when(listMock.size()).thenReturn(10).thenReturn(20);
        
        assertEquals(10, listMock.size()); // 기대값, 실제값
        assertEquals(20, listMock.size()); // 기대값, 실제값
        assertEquals(20, listMock.size()); // 기대값, 실제값
    }

    /* 특정 파라미터를 받는 경우 테스트 */
    @Test
    public void testGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("SomeString");
        
        // 특정 파라미터값에 따른 리턴
        assertEquals("SomeString", listMock.get(0)); // 기대값, 실제값
        assertEquals(null, listMock.get(1)); // 기대값, 실제값
    }
    
    /* 늘 같은 값을 리턴하는 일반적인 파라미터를 받는 경우 테스트 */
    @Test
    public void testGet_GenericParameter() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeString"); // Mockito.anyInt() - 어떤 정수값을 넣어도 SomeString을 반환
        
        assertEquals("SomeString", listMock.get(0)); 
        assertEquals("SomeString", listMock.get(1)); 
        assertNotEquals(null, listMock.get(1));
    }
}
