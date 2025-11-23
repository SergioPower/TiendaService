package com.tienda.service;

public class Venta {
    private int id;
    private int idCliente;
    private int idProducto;
    private int cantidad;

    public Venta() {
    }

    public Venta(int id, int idCliente, int idProducto, int cantidad) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                '}';
    }
}
