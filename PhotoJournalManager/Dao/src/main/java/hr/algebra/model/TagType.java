/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.util.Optional;

/**
 *
 * @author majap
 */

public enum TagType {

        ITEM("item"),
        TITLE("title"),
        CATEGORY("category"),
        DESCRIPTION("descriptionText"),
        CREDITS("credits"),
        PICTURELINK("hiresJpeg"),
        MISSION("mission"),
        INSTRUMENT("instrument"),
        SPACECRAFT("spacecraft"),
        TARGET("target"),
        PUB_DATE("pubDate");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

       public static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }


