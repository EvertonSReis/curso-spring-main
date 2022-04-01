package com.evertonreis.service.util;

import com.evertonreis.util.HashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class HashUtilTest {

    @Test
    public void getSecureHashTest(){
        String hash = HashUtil.getSecureHash("123");
        System.out.println(hash);

        assertThat(hash.length()).isEqualTo(64);
    }

}
