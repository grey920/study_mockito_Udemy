package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SomeBusinessMockTest {

    /* 생성자에 들어가는 mock 객체 */
    @Test
    public void testFindTheGreatestFromAllData() {
        DataService dataServiceMock = mock(DataService.class); // static으로 임포트해서 mock 생성
        // => new int[] {24, 15, 3};// 원하는 리턴값
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
        
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }
    
    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
        DataService dataServiceMock = mock(DataService.class);
        // dataServiceMock.retrieveAllData() => new int[] {15};// 원하는 리턴값
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
        
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    
}
