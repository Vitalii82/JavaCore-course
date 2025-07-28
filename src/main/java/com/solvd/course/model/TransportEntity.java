
package com.solvd.course.model;

import com.solvd.course.annotations.EntityInfo;

@EntityInfo(author = "Svinovei_Vitalii", description = "Represents a transport entity with ID and type")
public class TransportEntity {
    private String id;
    private String type;

    public TransportEntity(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() { return id; }
    public String getType() { return type; }
}
