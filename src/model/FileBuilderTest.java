package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileBuilderTest {
    @Test
    void saveTermsTest() {
        SetIndexList list = new SetIndexList();
        list.add(new SetIndex(0, "Test", 2));
        TermList terms = new TermList();

        terms.add(new StudyTerm(0, "banana", "банан")).
                add(new StudyTerm(1, "orange", "апельсин")).
                add(new StudyTerm(2, FileBuilder.commandDelimiter() + "plum", FileBuilder.doubleDelimiter() +"//слива//")).
                add(new StudyTerm(3, FileBuilder.delimiter, FileBuilder.doubleDelimiter()));

        FileBuilder.writeTerms(0, terms);
        list.save();

        list.clear();

        list.load();
        StudySet set = new StudySet(list.get(0).getID());
        assertEquals(terms, set.getList());
    }
}
