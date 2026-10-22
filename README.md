# Room Sample
ToDo List Application created as a sample for Room persistence library included this functions:

1. add a row to the database
2. remove a row from database 
3. retrieve rows from the database 
4. save multiple rows to the database
5. clear all rows from the database 

read more about Room in the [Android documentation](https://developer.android.com/topic/libraries/architecture/room)

---

## Práctica 10 · Cambios

Aplicación original: [AyatKhraisat/RoomExample](https://github.com/AyatKhraisat/RoomExample)

Versión modificada por **Mario Rapado Sánchez**.

Esta versión mantiene el funcionamiento original de la lista de tareas y añade tres cambios:

1. **Pantalla «Acerca de»**: información de la aplicación, autoría y acceso al repositorio original.
2. **Nueva paleta de colores**: verde azulado, ámbar y verde claro en la barra, los botones, las tarjetas y el fondo.
3. **Sistema de prioridades**: cada tarea puede ser alta, media o baja. La lista se ordena de mayor a menor prioridad y cada nivel tiene un color propio.

Los datos se guardan en Room. Las tareas creadas con la versión anterior se conservan y pasan a tener prioridad media.

### Cómo ejecutar

1. Abrir la carpeta del proyecto con Android Studio.
2. Usar un emulador o un dispositivo con Android 6.0 (API 23) o superior.
3. Ejecutar la configuración `app`.

> Nota: las herramientas de compilación se actualizaron para que el proyecto funcione con Android Studio actual. Esto no cambia el comportamiento de la aplicación.

### Documentación

La memoria de la práctica está en [`docs/Practica10_Ape1_Ape2_Rapado_Sanchez.docx`](docs/Practica10_Ape1_Ape2_Rapado_Sanchez.docx).

