# IronLibrary

## Introducción

Este proyecto consiste en un sistema de gestión de biblioteca que permite administrar y obtener datos sobre los libros utilizados por los estudiantes. A continuación, se detallan las instrucciones para ejecutar y probar la aplicación.

---

## Requisitos previos

1. **Java**: Java 21.
2. **Maven**: correctamente configurado.
3. **Base de datos**:  MySQL o MariaDB (ajustando las credenciales en el archivo `application.properties`).

---

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/VAlexS/homework-java-ironlibrary
   cd homework-java-ironlibrary
   ```

2. Compila el proyecto:
   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

---

## Uso

Al iniciar la aplicación, se mostrará un menú interactivo en la consola. A continuación, se presentan capturas de pantalla y ejemplos de uso.

### Menú principal

```plaintext
=========== 📖 Iron Library ===========
1. 📕 Add a book
2. 🔎 Search book by title
3. 🗂️ Search book by category
4. 🖋️ Search book by author
5. 📚 List all books along with author
6. 🎓 Issue book to student
7. 🆔 List books by USN
8. 🚪 Exit
Choose an option:
```

### Ejemplo: Agregar un libro

```plaintext
Enter your choice: 1
Enter isbn : 978-3-16-148410-0
Enter title : The Notebook
Enter category : Romance
Enter Author name : Nicholas Sparks
Enter Author mail : nicholassparks@gmail.com
Enter number of books : 4
Record created successfully!
```

### Ejemplo: Buscar un libro por título

```plaintext
Enter your choice: 2
Enter title : The Notebook

Book ISBN               Book Title          Category    No of Books
978-3-16-148410-0       The Notebook        Romance     4
```

### Ejemplo: Emitir un libro a un estudiante

```plaintext
Enter your choice: 6
Enter usn : 09003688800
Enter name : John Doe
Enter book ISBN : 978-3-17-148410-0

Book issued. Return date : 2023-10-15
```

---

## Pruebas

El proyecto incluye pruebas unitarias para todos los servicios principales. Para ejecutarlas, utiliza el siguiente comando:

```bash
mvn test
```


