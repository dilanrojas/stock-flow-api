# Spring Boot Example | Software Development III
Using [Spring initializr](https://start.spring.io) for setting up a Spring Boot Project.

## Preview
<img src="./preview/image.png" alt="Image of a Java project with a source folder" />

# Flujo de una petición POST a /products

Este documento explica, usando este proyecto como ejemplo, cómo viaja una petición POST desde Postman hasta la base de datos local y cómo vuelve la respuesta al cliente.

## 1. Punto de inicio: Postman envía la solicitud
- Herramienta cliente: Postman.
- Ruta HTTP: POST /products
- Ejemplo de cuerpo JSON:

```json
{
  "name": "Laptop",
  "description": "Equipo para desarrollo",
  "price": 1500.00
}
```

La petición llega al servidor Spring Boot sobre el puerto configurado en `application.properties`.

---

## 2. Primera clase que recibe la petición (cliente → servidor)

### 2.1 Controlador
Archivo: `ProductController.java`

- La clase se expone con `@RequestMapping("/products")`.
- El método que atiende la petición POST es `save(...)`
- En ese método se recibe el JSON como `@RequestBody ProductRequestModel` y se convierte a un DTO con el mapper.

¿Qué ocurre aquí?
1. Spring Boot convierte el JSON entrante en un objeto `ProductRequestModel`.
2. El controlador delega la lógica al facade.
3. Esta es la primera clase del proyecto que realmente recibe la solicitud HTTP.

---

## 3. Capa de transformación: pasamos del modelo HTTP al DTO

### 3.1 Mapper
Archivo: `ProductMapper.java`

- El método responsable de convertir el JSON recibido en un DTO interno es `toProductRequestDto(...)`.
- En esas líneas se copian los campos:
  - `name`
  - `description`
  - `price`

Esto separa la capa HTTP de la lógica de negocio.

---

## 4. Capa de aplicación: facade

### 4.1 Fachada
Archivo: `ProductFacade.java`

- El método que inicia el proceso de creación es `addProduct(...)`.
- Su lógica es:
  1. Recibe el DTO de entrada.
  2. Lo pasa al servicio.
  3. Luego convierte la entidad persistida en un DTO de respuesta.

Importante:
- La anotación `@Transactional` indica que esta operación forma parte de una transacción.

---

## 5. Capa de negocio: servicio

### 5.1 Servicio de productos
Archivo: `ProductService.java`

- El método que crea el objeto a guardar es `addProduct(...)`.
- Aquí se construye una entidad `Product` con:
  - `name(productDto.getName())`
  - `description(productDto.getDescription())`
  - `price(productDto.getPrice())`
  - `resourceId(UUID.randomUUID())`
- Luego se delega al repositorio con `productRepository.addProduct(product)`.

Este es el punto en el que el JSON ya fue transformado en una entidad lista para persistirse.

---

## 6. Capa de persistencia: repositorio JPA

### 6.1 Repositorio
Archivo: `ProductRepository.java`

- El método `addProduct(Product product)` está implementado como default y retorna una entidad producto`

Este es el punto donde Spring Data JPA genera la operación de inserción en la base de datos.

---

## 7. Entidad que representa la tabla en la base de datos

### 7.1 Entidad Product
Archivo: `Product.java`

- La entidad está mapeada a la tabla `products` con `@Table(name = "products")`.
- Los campos principales como el nombre o la descripción se mapean con `@Column(...)`.

Esto significa que cuando el repositorio hace `save(product)`, Hibernate prepara un `INSERT` en la base de datos.

---

## 8. Conexión con la base de datos local

### 8.1 Configuración JDBC
Archivo: `application.properties`

- La URL de conexión está en:
  `spring.datasource.url=...`
- La estrategia que utiliza Hibernate está en:
  `spring.jpa.hibernate.ddl-auto=...`
- El puerto del servidor está en:
  `server.port=8080`

---

## 9. Ruta de vuelta: base de datos → servidor → Postman

Una vez que la base de datos acepta el registro, el flujo vuelve por la misma pila, pero en sentido contrario:

1. `ProductRepository.addProduct(product)` devuelve la entidad guardada.
2. `ProductService.addProduct(...)` devuelve esa entidad al facade.
3. `ProductFacade.addProduct(...)` convierte la entidad a `ProductDto` usando `productMapper.toProductDto(entity)`.
4. El controlador `ProductController.save(...)` devuelve ese `ProductDto` como respuesta HTTP.
5. Spring Boot serializa ese objeto a JSON y lo envía de vuelta a Postman.

---

## 10. Resumen visual del flujo

Cliente (Postman)
  ↓
ProductController.save(...)  → recibe el JSON
  ↓
ProductMapper.toProductRequestDto(...)  → convierte a DTO
  ↓
ProductFacade.addProduct(...)  → llama al servicio
  ↓
ProductService.addProduct(...)  → arma la entidad Product
  ↓
ProductRepository.addProduct(...)  → hace save(product)
  ↓
Base de datos local (tabla products)
  ↓
ProductRepository → devuelve la entidad guardada
  ↓
ProductFacade → convierte a ProductDto
  ↓
ProductController → devuelve la respuesta al cliente
  ↓
Postman recibe la respuesta JSON
