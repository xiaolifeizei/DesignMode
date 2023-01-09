package com.matrix.prototype.database;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : cui_feng
 * @since : 2023-01-09 09:36
 */
public class SubjectCache {

    private final static ConcurrentHashMap<String, Subject> cache = new ConcurrentHashMap<>(16);

    public static Subject getSubject(String id) {
        Subject subject = cache.get(id);
        return subject == null ? null : subject.clone();
    }

    /**
     * 每个subject都从数据库查询
     * shapeMap.put(shapeKey, shape);
     */
    public static void loadCache() {
        Subject subjectOne = new SubjectOneImpl();
        subjectOne.setId("1");
        subjectOne.setPartTwo(1L);
        cache.put(subjectOne.getId(), subjectOne);

        Subject subjectTwo = new SubjectTwoImpl();
        subjectTwo.setId("2");
        subjectTwo.setPartTwo(2L);
        cache.put(subjectTwo.getId(), subjectTwo);
    }
}
