package ru.tilman.gb.patterns.ht6;

import java.util.HashMap;

public class FullOrderIdentityMap {
    private static FullOrderIdentityMap instance = new FullOrderIdentityMap();

    public static FullOrderIdentityMap getInstance() {
        return instance;
    }

    private HashMap<String, FullOrder> map = new HashMap<>();


    public void put(FullOrder fullOrder) {
        map.put(fullOrder.getId(), fullOrder);
    }

    public boolean isContainsById(String id) {
        return map.containsKey(id);
    }

    public boolean isContains(FullOrder fullOrder) {
        return map.containsKey(fullOrder.getId());
    }

    public FullOrder get(String id) {
        return map.get(id);
    }

}
