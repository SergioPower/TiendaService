package com.tienda.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class TiendaService {
    List<Producto> productos;
    List<Cliente> clientes;
    List<Venta> ventas;

    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        return productos.stream()
                .filter(producto -> producto.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    public Optional<Producto> obtenerProductoMasCaro(){
        return productos.stream()
                .max((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
    }

    public List<Producto> obtenerNombresOrdenados(){
        return productos.stream()
                .sorted((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()))
                .toList();
    }

    public List<Cliente> obtenerClientesMayores(int edad){
        return clientes.stream()
                .filter(c -> c.getEdad() > edad)
                .toList();
    }

    public double obtenerPromedioEdad(){
        return clientes.stream()
                .mapToInt(Cliente::getEdad)
                .average()
                .orElse(0);
    }

    public double obtenerTotalVendidoCliente(int idCliente){
        return ventas.stream()
                .filter(v -> v.getIdCliente() == idCliente)
                .mapToDouble(v -> {
                    Optional<Producto> productoOpt = productos.stream()
                            .filter(p -> p.getId() == v.getIdProducto())
                            .findFirst();
                    return productoOpt.map(producto -> producto.getPrecio() * v.getCantidad()).orElse(0.0);
                })
                .sum();
    }

    public Map<Integer, List<Venta>> agruparVentarPorCliente(){
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getIdCliente));
    }

    public Optional<Producto> obtenerProductoMasVendido(){
        return ventas.stream()
                .collect(Collectors.groupingBy(Venta::getIdProducto, Collectors.summingInt(Venta::getCantidad)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .flatMap(entry -> productos.stream()
                        .filter(p -> p.getId() == entry.getKey())
                        .findFirst());
    }
}
