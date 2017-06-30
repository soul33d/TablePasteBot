package com.homelearning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClipboardHelperTest {
    private String expected;

    @Before
    public void setUp() throws Exception {
        expected = "Clipboard";
        ClipboardHelper.putValueToClipboard(expected);
    }

    @Test
    public void getValueFromClipboard() throws Exception {
        Assert.assertEquals(expected, ClipboardHelper.getValueFromClipboard());
    }
}