package com.sda.restaurant.restaurant.DTO;

public class TablesDTO {

    private Long id;
    private int size;

    public TablesDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TablesDTO{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
