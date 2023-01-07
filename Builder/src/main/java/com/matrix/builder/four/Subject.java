package com.matrix.builder.four;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:39
 */
@Data
@AllArgsConstructor
public class Subject {

    private String partOne;

    private Long partTwo;

    private String partThree;

    public void show() {
        System.out.println("partOne: " + partOne);
        System.out.println("partTwo: " + partTwo);
        System.out.println("partThree: " + partThree);
    }
}
