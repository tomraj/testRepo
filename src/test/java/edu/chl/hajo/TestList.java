package edu.chl.hajo;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/*
    
     This is a test class (for some other class, in this case the List class)

 */
public class TestList {

    @Test
    public void testAdd() {
        List l = new List();
        l.add(1);                               // Call method to test
        assertTrue(l.getLength() == 1); // Logical check
        l.add(2);
    }

    @Test
    public void testRemove() {
        List l = new List();
        l.add(2);
        l.add(5);
        int ret = l.remove();
        assertTrue(l.getLength() == 1);
        assertTrue(ret == 5);
    }

    @Test
    public void testGet() {
        List l = new List();
        for (int i = 0; i < 5; i++) {
            l.add(i+5);
        }
        assertTrue(l.get(2) == 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBadIndex() {
        new List().get(-1);
    }

    @Test
    public void copyTest() {
        Random rnd = new Random();
        List l = new List();
        for (int i = 0; i < 3; i++) {
            int k = rnd.nextInt() % 30;
            l.add(k < 0 ? -k : k);
        }
        List copy = l.copy();
        assertTrue(l.getLength() == copy.getLength());
        for (int i = 0; i < copy.getLength(); i++) {
            assertTrue(l.get(i) == copy.get(i));
        }
    }

    @Test
    public void copyEmptyTest() {
        assertTrue(new List().copy().getLength() == 0);
    }

    
    @BeforeClass
    public static void beforeClass(){  //First of all
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass(){  // Last of all
        System.out.println("After class");
    }

    @Before
    public void before(){  //Before each test method
        System.out.println("Before");
    }

    @After
    public void after(){  //After each test method
        System.out.println("After");
    }
}
