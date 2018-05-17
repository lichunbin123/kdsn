package com.usping.kdsn;

import com.usping.kdsn.bean.Note;
import org.junit.Test;

/**
 * @author ning on 18-4-5.
 * @project kdsn
 */
public class TestNote {

    @Test
    public void testLombok(){
        Note note = Note.builder().noteContent("hello").build();

        System.out.println(note.toString());

    }
}

