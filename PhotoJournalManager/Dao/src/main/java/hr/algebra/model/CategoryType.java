/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author majap
 */
public enum CategoryType {
    SUN(1), UNIVERSE(2);
    
    private final int id;

    private CategoryType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static CategoryType from(int id) {
        for(CategoryType value : values()) {
            if(value.id == id ) {
                return value;
            }
        }
         throw new RuntimeException("no such category");
    }
    public static CategoryType getCategory(String data) {
    try {
        return CategoryType.valueOf(data.toUpperCase());
    } catch (IllegalArgumentException e) {
        return CategoryType.SUN; 
    }
}
}
