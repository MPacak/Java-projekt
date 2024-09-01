/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import hr.algebra.model.CategoryType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author majap
 */
public class CategoryTypeAdapter extends XmlAdapter<String, CategoryType> {

    @Override
    public CategoryType unmarshal(String categoryStr) throws Exception {
        return CategoryType.getCategory(categoryStr);
    }

    @Override
    public String marshal(CategoryType categoryType) throws Exception {
        return categoryType != null ? categoryType.name() : null;
    }
}
