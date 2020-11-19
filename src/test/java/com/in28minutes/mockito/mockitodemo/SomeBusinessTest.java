package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SomeBusinessTest {

    @Test
    public void testFindTheGreatestFromAllData() {
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

}// SomeBusinessTest


/*  Stub을 썼을 때 문제점
 * 1. 메소드를 만들 때마다 계속 추가해야 한다
 * 2. 전혀 다른 시나리오로 테스트하고 싶을 때 (매개변수가 다를때) 계속 만들어야 한다.
 * => Mock이 해결!! mock을 쓰면 매번 메소드를 새로 만들지 않아도 된다!!
 * */
class DataServiceStub implements DataService { 

    @Override
    public int[] retrieveAllData() {
        return new int[] { 24, 6, 15 };
    }

}
