package com.usping.kdsn.Note;

import com.usping.kdsn.KdsnApplication;
import com.usping.kdsn.bean.Note;
import com.usping.kdsn.news.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KdsnApplication.class)
public class NoteMapperTest {

    @Autowired
    private NoteService noteService;

    @Test
    @Transactional
    public void testA() {
        Note note = Note.builder().newsId("AWEO35nWHB4m_dAeBhwp").userId(6).build();
        System.out.println(note.toString());


//        noteService.findByNewsIdAndUserId(note).getData().forEach(
//                e -> System.out.println(e)
//        );
//        noteService.findByNewsIdAndUserId(note).getData().forEach(
//                e -> System.out.println(e)
//        );
    }

    @Test
    @Transactional
    public void testInsert() {
        Note note = Note.builder().newsId("AWEO35nWHB4m_dAeBhwp").userId(6).build();

        System.out.println(note.toString());

        noteService.save(note);
    }

    @Test
    @Transactional
    public void testSelectSelective() {
        Note note = Note.builder().userId(6).build();

        noteService.selectSelective(note).forEach(
                e -> System.out.println(e.toString())
        );

        note.setNewsId("AWEO35nWHB4m_dAeBhwp");


        noteService.selectSelective(note).forEach(
                e -> System.out.println(e.toString())
        );

    }
}
