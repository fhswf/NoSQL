package de.fhswf.nosql.persistence;

import de.fhswf.nosql.ContextHolder;
import de.fhswf.nosql.model.Foo;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class FooRepositoryTest {

    Logger log = LoggerFactory.getLogger(FooRepositoryTest.class);


    private final FooRepository fooRepository;

    public FooRepositoryTest() {
        this.fooRepository = ContextHolder.getFooRepository();
    }

    @Test
    public void testSelectAllFoos_secoundCallShouldBeFaster() {

        LocalDateTime start = LocalDateTime.now();
        List<Foo> fooList = fooRepository.selectAllFoos();
        Duration duration_nonCached = Duration.between(start, LocalDateTime.now());

        assertFalse(fooList.isEmpty());

        start = LocalDateTime.now();
        List<Foo> fooListCached = fooRepository.selectAllFoos();
        Duration duration_cached = Duration.between(start, LocalDateTime.now());

        assertFalse(fooListCached.isEmpty());

        // Enthalten beide Listen dieselben Elemente?
        fooListCached.removeAll(fooList);
        assertTrue(fooListCached.isEmpty());

        log.info("duration_nonCached:\t{}", duration_nonCached);
        log.info("duration_cached:\t{}", duration_cached);

        assertTrue(duration_cached.compareTo(duration_nonCached) < 0);
    }

    @Test
    public void selectFooById_secoundCallShouldBeFaster() {

        LocalDateTime start = LocalDateTime.now();
        Foo foo = fooRepository.selectFooById(80001L);
        Duration duration_nonCached = Duration.between(start, LocalDateTime.now());

        assertNotNull(foo);

        start = LocalDateTime.now();
        Foo fooCached = fooRepository.selectFooById(80001L);
        Duration duration_cached = Duration.between(start, LocalDateTime.now());

        assertNotNull(foo);
        assertEquals(fooCached, foo);

        log.info("duration_nonCached:\t{}", duration_nonCached);
        log.info("duration_cached:\t{}", duration_cached);

        assertTrue(duration_cached.compareTo(duration_nonCached) < 0);
    }
}
