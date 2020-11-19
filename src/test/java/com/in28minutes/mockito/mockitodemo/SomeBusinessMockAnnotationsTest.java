package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) // mockito 애노테이션을 쓸 때 붙여줘야 한다
public class SomeBusinessMockAnnotationsTest {
    
    @Mock 
    DataService dataServiceMock;
    
    @InjectMocks
    SomeBusinessImpl businessImpl;

   @Test
    public void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
        //SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock); // @InjectMocks써서 필요가 없다!
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testFindTheGreatestFromAllData_NoValues() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData()); // SomeBusinessImpl에서 MIN_VALUE로 초기화했으니까
    }

    
}
