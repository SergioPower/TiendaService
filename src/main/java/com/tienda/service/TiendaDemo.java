package com.tienda.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TiendaDemo {
    public static void main(String[] args) {
        TiendaService ts = new TiendaService();

        Producto p1 = new Producto(1, "Arroz", 2.0, "abarrotes");
        Producto p2 = new Producto(2, "Jabón", 1.2, "limpieza");
        Producto p3 = new Producto(3, "Queso", 3.5, "alimentos");

        Cliente c1 = new Cliente(1, "Luis", 28);
        Cliente c2 = new Cliente(2, "María", 22);

        Venta v1 = new Venta(1, c1.getId(), p1.getId(), 2); // Luis compra 2 Arroz
        Venta v2 = new Venta(2, c1.getId(), p3.getId(), 1); // Luis compra 1 Queso
        Venta v3 = new Venta(3, c2.getId(), p1.getId(), 5); // María compra 5 Arroz

        ts.productos = List.of(p1, p2, p3);
        ts.clientes = List.of(c1, c2);
        ts.ventas = List.of(v1, v2, v3);

        System.out.println("--- Productos por categoría 'abarrotes' ---");
        System.out.println(ts.obtenerProductosPorCategoria("abarrotes"));

        System.out.println("--- Producto más caro ---");
        Optional<Producto> masCaro = ts.obtenerProductoMasCaro();
        masCaro.ifPresent(System.out::println);

        System.out.println("--- Productos ordenados por nombre ---");
        System.out.println(ts.obtenerNombresOrdenados());

        System.out.println("--- Clientes mayores de 25 ---");
        System.out.println(ts.obtenerClientesMayores(25));

        System.out.println("--- Promedio de edad de clientes ---");
        System.out.println(ts.obtenerPromedioEdad());

        System.out.println("--- Total vendido por cliente (Luis id=1) ---");
        System.out.println(ts.obtenerTotalVendidoCliente(1));

        System.out.println("--- Ventas agrupadas por cliente ---");
        Map<Integer, List<Venta>> ventasPorCliente = ts.agruparVentarPorCliente();
        System.out.println(ventasPorCliente);

        System.out.println("--- Producto más vendido ---");
        Optional<Producto> masVendido = ts.obtenerProductoMasVendido();
        masVendido.ifPresent(System.out::println);
    }
}
