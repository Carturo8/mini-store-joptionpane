# 🛒 Mini Store JOptionPane

> 📄 Este README también está disponible en [English 🇺🇸](README.md)

Un simple **sistema de gestión de inventario** construido con **Java** usando **ArrayList, Array y HashMap**, integrado con una interfaz gráfica usando `JOptionPane`.  
Esta aplicación permite agregar, listar, comprar, buscar productos y mostrar estadísticas con un menú claro e interactivo.

---

## ✨ Funcionalidades

- ➕ Agregar nuevos productos al inventario (nombre, precio, stock)
- 📋 Listar todos los productos con precio y stock
- 🛒 Comprar productos con validación de stock y cálculo de subtotal
- 📊 Mostrar estadísticas: producto más barato y más caro
- 🔎 Buscar productos por coincidencias parciales en el nombre
- 🧾 Generar un ticket final con el total de compras
- ⚠️ Validación de entradas: valores vacíos, formatos numéricos y duplicados

---

## 🖼️ Vista previa

Aquí una vista previa del menú principal de la aplicación:

![Vista previa del menú](assets/menu-preview.png)

---

## 📂 Estructura del proyecto

```bash
mini-store-joptionpane/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.carturo.ministore/
│   │   │       ├── Main.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       ├── service/
│   │   │       │   └── InventoryService.java
│   │   │       └── util/
│   │   │           └── Validation.java
├── .gitignore
├── LICENSE
├── pom.xml
├── README.md
└── README.es.md
```

---

## ⚙️ Requisitos

- JDK 21+ (probado con JDK 24)
- Maven 3
- IntelliJ IDEA u otro IDE para Java
- No se requieren librerías adicionales

---

## ▶️ Ejecutar la aplicación

1. Compila el proyecto en tu IDE.
2. Ejecuta `Main.java`.
3. Interactúa con el menú de `JOptionPane` para gestionar el inventario.

---

## 📜 Licencia

Este proyecto está bajo la [Licencia MIT](LICENSE).
