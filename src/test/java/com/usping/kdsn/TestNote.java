package com.usping.kdsn;

import com.usping.kdsn.bean.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ning on 18-4-5.
 * @project kdsn
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KdsnApplication.class)
public class TestNote {

    @Test
    public void testLombok(){
        Note note = Note.builder().noteContent("hello").build();

        System.out.println(note.toString());

    }
}

