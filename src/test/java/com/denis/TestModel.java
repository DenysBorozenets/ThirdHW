package com.denis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
    private Model model;

    @Before
    public void setValue() {
        model = new Model(40);
    }

    @Test
    public void testCompareMore(){
        Assert.assertEquals(Model.MORE, model.userNumber(38));
    }

    @Test
    public void testCompareLess(){
        Assert.assertEquals(Model.LESS, model.userNumber(42));
    }

    @Test
    public void testCompare(){
        Assert.assertEquals(Model.COMPARE, model.userNumber(40));
    }

    @Test
    public void testCorrectWorkMaxBarrier() {
        model.userNumber(60);
        Assert.assertEquals(model.getMaxBarrier(), 59);
    }

    @Test
    public void testCorrectWorkMinBarrier() {
        model.userNumber(20);
        Assert.assertEquals(21, model.getMinBarrier());
    }

    @Test
    public void testOutOfRange(){
        Assert.assertEquals(Model.OUT_OF_RANGE, model.userNumber(101));
    }

    @Test
    public void testGuessNumberGuesses() {
        List<Integer>  tries =  new ArrayList<>();
        tries.add(50);
        tries.add(40);
        tries.add(30);
        model.userNumber(50);
        model.userNumber(40);
        model.userNumber(30);
        Assert.assertEquals(model.getTries(), tries);
    }

//    @Test
//    public void randNumberInRange() {
//        int result = model.generateGuessNumber();
//        Assert.assertTrue(result > model.getMinBarrier() && result < model.getMaxBarrier());
//
//    }

    @Test
    public void testRand(){
        int result = model.generateGuessNumber();
        Assert.assertTrue(result >= 0 && result <= model.MAX);
    }

}
