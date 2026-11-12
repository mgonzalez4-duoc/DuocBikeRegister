# Duoc Bike Register

Proyecto académico JavaFX + Maven + SQLite, inspirado en la organización del proyecto FitPower.

## Requisitos
- JDK 21
- IntelliJ IDEA
- Maven (IntelliJ puede importar el `pom.xml` automáticamente)

## Abrir en IntelliJ IDEA
1. Descomprime `DuocBikeRegister.zip`.
2. IntelliJ IDEA → Open → selecciona la carpeta `DuocBikeRegister` (la que contiene `pom.xml`).
3. Acepta la importación Maven y espera a que descargue las dependencias.
4. Ejecuta `src/main/java/cl/duoc/bikeregister/Launcher.java`.

También puedes ejecutar desde la terminal de IntelliJ:

```bash
mvn clean javafx:run
```

## ¿Dónde se guardan los datos?
La primera vez se crea automáticamente `data/duoc_bikes.db`. Es una base de datos SQLite real y local. Los registros permanecen guardados aunque cierres la aplicación.

## Estructura

```text
src/main/java/cl/duoc/bikeregister/
├── App.java
├── Launcher.java
├── controller/
│   └── MainController.java
├── model/
│   └── RegistroBicicleta.java
└── repository/
    ├── RegistroDAO.java
    ├── SQLiteRegistroDAO.java
    └── RegistroRepository.java

src/main/resources/cl/duoc/bikeregister/view/
└── main-view.fxml
```

## Funcionalidades incluidas
- Registrar datos de estudiante/funcionario y bicicleta.
- Persistir registros en SQLite.
- Listar todos los registros en una tabla.
- Buscar por RUT (búsqueda parcial o completa).
- Eliminar el registro seleccionado, previa confirmación.
- Validar campos obligatorios y evitar números de serie duplicados.

## Para Scene Builder
Abre `src/main/resources/cl/duoc/bikeregister/view/main-view.fxml`.
El controlador configurado es `cl.duoc.bikeregister.controller.MainController`.

## Nota para la presentación
Este es un prototipo funcional para demostrar POO, JavaFX, FXML, patrón DAO/Repository y persistencia SQLite. Antes de usarlo con datos reales, habría que agregar controles de acceso, protección de datos personales, validación formal de RUT y políticas de retención/autorización de Duoc UC. No ingresar datos personales reales en una demostración.
