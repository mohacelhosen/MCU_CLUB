package com.mohacel.studenthub;

import java.util.UUID;

public class Experiment {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long mostSignificantBits = uuid.getMostSignificantBits();

        System.out.println(uuid);
        System.out.println(mostSignificantBits);
        System.out.println(String.valueOf(leastSignificantBits).replace("-",""));
    }
}
